package com.gildedrose.factory;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemTypeEnum;
import com.gildedrose.updater.SulfurasUpdater;
import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassUpdater;
import com.gildedrose.updater.ConjuredUpdater;
import com.gildedrose.updater.RegularItemUpdater;
import com.gildedrose.updater.ItemUpdater;

public class ItemUpdaterFactory {

    public static ItemUpdater getUpdater(final Item item) {
        final ItemTypeEnum itemType = ItemTypeEnum.fromString(item.name);

        switch (itemType) {
            case AGED_BRIE:
                return new AgedBrieUpdater(item);
            case BACKSTAGE_PASSES:
                return new BackstagePassUpdater(item);
            case SULFURAS:
                return new SulfurasUpdater(item);
            case CONJURED:
                return new ConjuredUpdater(item);
            default:
                return new RegularItemUpdater(item);
        }
    }
}
