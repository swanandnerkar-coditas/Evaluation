package com.task.OrderManagementSystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class OrderItemDTO {

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;
}
