package com.task.OrderManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.OrderManagementSystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("orderList")
    private Customer customer;

    // because if Order is deleted then whole order list should be deleted
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
