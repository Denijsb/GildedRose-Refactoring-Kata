package com.gildedrose.updater;

import static com.gildedrose.common.ItemConstants.BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.MIN_QUALITY;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP_BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP_BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD;

import com.gildedrose.model.Item;

public class BackstagePassUpdater extends BaseItemUpdater {

    public BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (isExpired()) {
            getItem().quality = MIN_QUALITY;
        } else {
            increaseQuality(calculateIncreaseValue());
            decreaseSellIn();
        }
    }

    private int calculateIncreaseValue() {
        if (isWithinTripleBoostThreshold()) {
            return QUALITY_INCREASE_STEP_BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD;
        } else if (isWithinDoubleBoostThreshold()) {
            return QUALITY_INCREASE_STEP_BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD;
        } else {
            return QUALITY_INCREASE_STEP;
        }
    }

    private boolean isWithinTripleBoostThreshold() {
        return getItem().sellIn <= BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD;
    }

    private boolean isWithinDoubleBoostThreshold() {
        return getItem().sellIn <= BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD;
    }
}
