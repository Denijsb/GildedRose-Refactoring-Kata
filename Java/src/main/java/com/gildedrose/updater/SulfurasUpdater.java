package com.gildedrose.updater;

import com.gildedrose.model.Item;

public class SulfurasUpdater extends BaseItemUpdater {

    public SulfurasUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        // No action needed for Sulfuras, as quality and sellIn remain constant
    }
}
