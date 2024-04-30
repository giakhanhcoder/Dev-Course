package com.develop.devcourse.domain.payment.model;

import com.develop.devcourse.domain.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "total_expenses")
public class TotalExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "total_expenses_id")
    private Long totalExpensesId;

    @Column(name = "total_expenses")
    private Long totalExpenses;

    @OneToMany(mappedBy = "totalExpenses")
    @JsonIgnore
    private List<Orders> ordersList;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
}
