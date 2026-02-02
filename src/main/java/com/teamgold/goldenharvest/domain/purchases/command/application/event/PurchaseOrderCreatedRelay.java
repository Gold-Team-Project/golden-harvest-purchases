package com.teamgold.goldenharvest.domain.purchases.command.application.event;

import com.teamgold.goldenharvest.common.broker.KafkaProducerHelper;
import com.teamgold.goldenharvest.domain.purchases.command.application.event.dto.PurchaseOrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class PurchaseOrderCreatedRelay {

    private final KafkaProducerHelper producer;

    @Async
    @EventListener
    public void purchaseOrderCreatedEventRelay(PurchaseOrderCreatedEvent event) {
        log.info("Publishing purchaseOrderCreatedEvent");

        producer.send("purchase.order.created",
                UUID.randomUUID().toString(),
                event,
                null);
        // Todo: onFailure callback
    }
}
