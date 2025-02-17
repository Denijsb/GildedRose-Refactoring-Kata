package com.gildedrose.utils.factory;

import com.gildedrose.model.Item;

public class ItemFactory {

    public static Item createItem(final String name, final int sellIn, final int quality) {
        return new Item(name, sellIn, quality);
    }

}
