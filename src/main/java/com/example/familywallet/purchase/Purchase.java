package com.example.familywallet.purchase;

import com.example.familywallet.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
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

    @ManyToMany(mappedBy = "purchases", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> users;

    @Override
    public String toString() {
        return name + ' ';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return Objects.equals(uuid, purchase.uuid) && Objects.equals(name, purchase.name) &&
                Objects.equals(users, purchase.users);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
