package com.task.OrderManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class OrderItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("orderItemList")
    private Order order;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "product_id")
    private Product product;

    // no. of product selected in 1 order
    private Integer quantity;
}
