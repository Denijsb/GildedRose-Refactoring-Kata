package com.gildedrose;

import com.gildedrose.factory.ItemUpdaterFactory;
import com.gildedrose.model.Item;
import com.gildedrose.updater.ItemUpdater;
import java.util.logging.Logger;

class GildedRose {

    private static final Logger LOGGER = Logger.getLogger(GildedRose.class.getName());

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final ItemUpdater itemUpdater = ItemUpdaterFactory.getUpdater(item);
            LOGGER.info(String.format("Updating %s with quality: %s and sellIn: %s", item.name, item.quality, item.sellIn));
            itemUpdater.update();
            LOGGER.info(String.format("Updated %s to quality: %s and to sellIn: %s", item.name, item.quality, item.sellIn));
        }
    }
}
