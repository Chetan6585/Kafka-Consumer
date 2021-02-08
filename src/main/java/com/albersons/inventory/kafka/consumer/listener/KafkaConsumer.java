package com.albersons.inventory.kafka.consumer.listener;


import com.albersons.inventory.kafka.consumer.inventory.Inventory;
import com.albersons.inventory.kafka.consumer.inventory.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class KafkaConsumer {
    private InventoryRepository inventoryRepository;

    @KafkaListener(topics = "OSDC_ITEM_UPDATE_QA", groupId = "group-id")
    public void consumeAndSaveInventory(Inventory inventory) {

        log.info(String.format("Message Inventory recieved -> %s", inventory));
        inventoryRepository.save(inventory);
    }

}

