package com.edem.LibraryManagementSystem.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user")
    private Author author;

//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = false)
//    private User user;
}
