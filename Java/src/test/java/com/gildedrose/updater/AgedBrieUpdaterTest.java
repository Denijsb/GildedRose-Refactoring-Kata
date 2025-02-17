package com.gildedrose.updater;

import static com.gildedrose.utils.factory.ItemFactory.createItem;
import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AgedBrieUpdaterTest {

    @ParameterizedTest(name = "{index} => initialSellIn={0}, initialQuality={1}, expectedQuality={2}, expectedSellIn={3}")
    @CsvSource({
        "5, 10, 11, 4", // Before sell-in: Quality increases by 1, sellIn decreases by 1
        "0, 10, 12, -1", // After sell-in: Quality increases by 2, sellIn decreases by 1
        "5, 50, 50, 4", // At max quality: Quality stays at 50, sellIn decreases by 1
        "0, 50, 50, -1", // Quality stays at 50 after sell-in passed
        "5, 50, 50, 4", // Quality stays at max when it is already at max value, sellIn decreases by 1
        "0, 50, 50, -1" // Quality stays at max after sellIn passed
    })
    void testAgedBrieUpdate(final int initialSellIn, final int initialQuality,
        final int expectedQuality, final int expectedSellIn) {
        // Arrange
        final Item item = createItem("Aged Brie", initialSellIn, initialQuality);
        final AgedBrieUpdater updater = new AgedBrieUpdater(item);
        // Act
        updater.update();
        // Assert
        assertEquals(expectedQuality, item.quality);
        assertEquals(expectedSellIn, item.sellIn);
    }
}
