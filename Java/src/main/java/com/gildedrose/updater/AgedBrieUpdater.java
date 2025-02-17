package com.gildedrose.updater;

import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_MULTIPLIER_AFTER_SELL_IN;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP;

import com.gildedrose.model.Item;

public class AgedBrieUpdater extends BaseItemUpdater {

    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality(calculateDecreaseValue());
        decreaseSellIn();
    }

    private int calculateDecreaseValue() {
        return isExpired()
            ? QUALITY_INCREASE_STEP * QUALITY_INCREASE_MULTIPLIER_AFTER_SELL_IN
            : QUALITY_INCREASE_STEP;
    }
}
