package com.edem.LibraryManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Basic
    @Column(name = "user_id")
    private Long userId;

    @Basic
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Author author;

    public User (String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(author, user.author);
    }


    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, author);
    }
//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = false)
//    private User user;
}
