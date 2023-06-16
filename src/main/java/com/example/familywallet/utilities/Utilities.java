package com.example.familywallet.utilities;

import com.example.familywallet.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "utilities")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Utilities {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuid;

    @Column(name = "utilities_name", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "cost")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer cost;

    @Column(name = "amount")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer amount;

    @Column(name = "total")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer total;

    @ManyToMany(mappedBy = "utilities", fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @Override
    public String toString() {
        return name + ' ';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilities utilities)) return false;
        return Objects.equals(uuid, utilities.uuid) &&
                Objects.equals(name, utilities.name) &&
                Objects.equals(cost, utilities.cost) &&
                Objects.equals(amount, utilities.amount) &&
                Objects.equals(total, utilities.total) &&
                Objects.equals(user, utilities.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, cost, amount, total, user);
    }
}
