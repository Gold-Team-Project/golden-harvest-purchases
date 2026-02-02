package com.teamgold.goldenharvest.domain.purchases.command.application.event.dto;


import java.time.LocalDate;

public record PurchaseOrderCreatedEvent(
        String purchaseOrderId,
        LocalDate createdAt,
        String skuNo,
        int quantity
) { }
