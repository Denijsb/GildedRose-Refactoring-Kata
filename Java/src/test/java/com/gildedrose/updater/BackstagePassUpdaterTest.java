package com.gildedrose.updater;

import static com.gildedrose.utils.factory.ItemFactory.createItem;
import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BackstagePassUpdaterTest {

    @ParameterizedTest(name = "{index} => initialSellIn={0}, initialQuality={1}, expectedQuality={2}, expectedSellIn={3}")
    @CsvSource({
        "15, 20, 21, 14", // More than 10 days, quality increases by 1
        "0, 20, 0, 0", // After the concert (sellIn = 0), quality drops to 0
        "5, 20, 23, 4", // 5 days or less, quality increases by 3
        "9, 20, 22, 8", // 10 days or less, quality increases by 2
        "10, 50, 50, 9", // At max quality, quality stays the same (max is 50)
        "0, 0, 0, 0" // At min quality, quality stays at min (min is 0)
    })
    void testBackstagePassUpdate(final int initialSellIn, final int initialQuality,
        final int expectedQuality, final int expectedSellIn) {
        // Arrange
        final Item item = createItem("Backstage passes to a TAFKAL80ETC concert", initialSellIn,
            initialQuality);
        final BackstagePassUpdater updater = new BackstagePassUpdater(item);
        // Act
        updater.update();
        // Assert
        assertEquals(expectedQuality, item.quality);
        assertEquals(expectedSellIn, item.sellIn);
    }
}
