package com.example.familywallet.purchase;

import com.example.familywallet.user.User;
import com.example.familywallet.utilities.Utilities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "purchases")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuid;

    @Column(name = "purchase_name", nullable = false, unique = true)
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

    @ManyToMany(mappedBy = "purchases", fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @ManyToMany(mappedBy = "purchases", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Utilities utilities;

    @Override
    public String toString() {
        return name + ' ';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return Objects.equals(uuid, purchase.uuid) &&
                Objects.equals(name, purchase.name) &&
                Objects.equals(cost, purchase.cost) &&
                Objects.equals(amount, purchase.amount) &&
                Objects.equals(total, purchase.total) &&
                Objects.equals(user, purchase.user) &&
                Objects.equals(utilities, purchase.utilities);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
