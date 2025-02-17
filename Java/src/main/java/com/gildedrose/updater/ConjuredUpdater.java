package com.gildedrose.updater;

import static com.gildedrose.common.ItemConstants.CONJURED_QUALITY_DECREASE_MULTIPLIER;
import static com.gildedrose.common.ItemConstants.QUALITY_DECREASE_STEP;

import com.gildedrose.model.Item;

public class ConjuredUpdater extends BaseItemUpdater {

    public ConjuredUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality(calculateDecreaseValue());
    }

    private int calculateDecreaseValue() {
        if (isExpired()) {
            return (QUALITY_DECREASE_STEP * CONJURED_QUALITY_DECREASE_MULTIPLIER)
                * CONJURED_QUALITY_DECREASE_MULTIPLIER;
        } else {
            return QUALITY_DECREASE_STEP
                * CONJURED_QUALITY_DECREASE_MULTIPLIER;
        }
    }
}
