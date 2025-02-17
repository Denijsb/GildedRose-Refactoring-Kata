package com.gildedrose.updater;

import static com.gildedrose.common.ItemConstants.QUALITY_DECREASE_MULTIPLIER_AFTER_SELL_IN;
import static com.gildedrose.common.ItemConstants.QUALITY_DECREASE_STEP;

import com.gildedrose.model.Item;

public class RegularItemUpdater extends BaseItemUpdater {

    public RegularItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality(calculateDecreaseValue());
    }

    private int calculateDecreaseValue() {
        return isExpired()
            ? QUALITY_DECREASE_STEP * QUALITY_DECREASE_MULTIPLIER_AFTER_SELL_IN
            : QUALITY_DECREASE_STEP;
    }
}
