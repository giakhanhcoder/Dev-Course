package com.develop.devcourse.domain.payment.model;

import com.develop.devcourse.domain.security.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "serial_number")
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String serialNumber;

    @Column(name = "payment_at")
    private Date paymentAt;

    @ManyToOne
    @JoinColumn(name = "total_expenses_id", referencedColumnName = "total_expenses_id")
    private TotalExpenses totalExpenses;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users users;

//    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
//    private List<OrderCourse> orderCourseList;
}
