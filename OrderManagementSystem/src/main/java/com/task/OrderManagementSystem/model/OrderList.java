package com.task.OrderManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "product_id")
    private Product product;

    // no. of product selected in 1 order
    private Integer count;
}
