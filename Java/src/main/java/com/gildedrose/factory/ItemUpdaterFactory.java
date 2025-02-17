package com.gildedrose.factory;

import com.gildedrose.model.Item;
import com.gildedrose.updater.SulfurasUpdater;
import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassUpdater;
import com.gildedrose.updater.ConjuredUpdater;
import com.gildedrose.updater.RegularItemUpdater;
import com.gildedrose.updater.ItemUpdater;

public class ItemUpdaterFactory {

    public static ItemUpdater getUpdater(final Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdater(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassUpdater(item);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdater(item);
            case "Conjured":
                return new ConjuredUpdater(item);
            default:
                return new RegularItemUpdater(item);
        }
    }
}
