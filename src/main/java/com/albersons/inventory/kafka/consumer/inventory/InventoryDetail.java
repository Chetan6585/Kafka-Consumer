package com.albersons.inventory.kafka.consumer.inventory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document
@ToString
public class InventoryDetail implements Serializable {

private String source;
private String timestamp;
private String itemAvailability;

    @JsonCreator
    public static InventoryDetail of(@JsonProperty(value = "source") final String source,
                                    @JsonProperty(value = "timestamp") final String timestamp,
                                     @JsonProperty(value = "itemAvailability") final String itemAvailability) {
        return new InventoryDetail(source,timestamp, itemAvailability);
    }
}
