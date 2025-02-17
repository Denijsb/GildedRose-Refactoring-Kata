package com.gildedrose.updater;

import static com.gildedrose.utils.factory.ItemFactory.createItem;
import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RegularItemUpdaterTest {

    @ParameterizedTest(name = "{index} => initialSellIn={0}, initialQuality={1}, expectedQuality={2}, expectedSellIn={3}")
    @CsvSource({
        "5, 20, 19, 4", // Before sellIn: Quality decreases by 1, sellIn decreases by 1
        "0, 20, 18, -1", // After sellIn: Quality decreases by 2, sellIn decreases by 1
        "5, 1, 0, 4", // Quality never goes below 0
        "0, 0, 0, -1" // Edge case where quality is already at the lowest (0)
    })
    void testRegularItemUpdate(final int initialSellIn, final int initialQuality,
        final int expectedQuality, final int expectedSellIn) {
        // Arrange
        final Item item = createItem("Random item", initialSellIn, initialQuality);
        final RegularItemUpdater updater = new RegularItemUpdater(item);
        // Act
        updater.update();
        // Assert
        assertEquals(expectedQuality, item.quality);
        assertEquals(expectedSellIn, item.sellIn);
    }
}
