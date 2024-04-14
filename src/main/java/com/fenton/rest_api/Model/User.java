package com.fenton.rest_api.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")})
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false,length = 20)
    private String username;
    @Column(nullable = false,length = 50)
    private String email;
    @Column(nullable = false,length = 50)
    private  String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles"
            ,joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();


}


