package com.gildedrose.updater;

import static com.gildedrose.common.ItemConstants.MAX_QUALITY;
import static com.gildedrose.common.ItemConstants.MIN_QUALITY;

import com.gildedrose.model.Item;
import com.gildedrose.common.ItemConstants;

public abstract class BaseItemUpdater implements ItemUpdater {

    private final Item item;

    public BaseItemUpdater(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    protected void decreaseSellIn() {
        getItem().sellIn--;
    }

    protected void increaseQuality(int quality) {
        if (getItem().quality < MAX_QUALITY) {
            getItem().quality = Math.min(getItem().quality + quality, MAX_QUALITY);
        }
    }

    protected void decreaseQuality(final int quality) {
        if (getItem().quality > MIN_QUALITY) {
            getItem().quality = Math.max(getItem().quality - quality, MIN_QUALITY);
        }
    }

    protected boolean isExpired() {
        return getItem().sellIn <= ItemConstants.SELL_IN_THRESHOLD;
    }

    @Override
    public abstract void update();
}
