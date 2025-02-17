package com.gildedrose.updater;

import static com.gildedrose.common.ItemConstants.BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.MIN_QUALITY;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP_BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.QUALITY_INCREASE_STEP_BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD;
import static com.gildedrose.common.ItemConstants.SELL_IN_THRESHOLD;

import com.gildedrose.model.Item;

public class BackstagePassUpdater extends BaseItemUpdater {

    public BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (getItem().sellIn <= SELL_IN_THRESHOLD) {
            getItem().quality = MIN_QUALITY;
        } else {
            if (getItem().sellIn <= BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD) {
                increaseQuality(QUALITY_INCREASE_STEP_BACKSTAGE_PASS_TRIPLE_BOOST_THRESHOLD);
            } else if (getItem().sellIn <= BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD) {
                increaseQuality(QUALITY_INCREASE_STEP_BACKSTAGE_PASS_DOUBLE_BOOST_THRESHOLD);
            } else {
                increaseQuality(QUALITY_INCREASE_STEP);
            }
        }
        if (getItem().sellIn > SELL_IN_THRESHOLD) {
            decreaseSellIn();
        }
    }
}
