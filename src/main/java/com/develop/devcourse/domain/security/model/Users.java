package com.develop.devcourse.domain.security.model;

import com.develop.devcourse.domain.payment.model.Orders;
import com.develop.devcourse.domain.payment.model.TotalExpenses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
//import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "create_At")
    private Date creatAt;

    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "budget")
    private Long budget;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<TotalExpenses> totalExpenses;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<Orders> ordersList;

    @Transient
    private String fullName;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}