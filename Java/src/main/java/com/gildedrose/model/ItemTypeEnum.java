package com.gildedrose.model;

import java.util.Arrays;

public enum ItemTypeEnum {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured"),
    REGULAR("Regular");

    private final String itemName;

    ItemTypeEnum(final String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public static ItemTypeEnum fromString(String itemName) {
        return Arrays.stream(ItemTypeEnum.values())
            .filter(type -> type.getItemName().equalsIgnoreCase(itemName))
            .findFirst()
            .orElse(REGULAR);
    }
}
