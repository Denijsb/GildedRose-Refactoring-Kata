package com.gildedrose.updater;

import static com.gildedrose.utils.factory.ItemFactory.createItem;
import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConjuredUpdaterTest {

    @ParameterizedTest(name = "{index} => initialSellIn={0}, initialQuality={1}, expectedQuality={2}, expectedSellIn={3}")
    @CsvSource({
        "5, 20, 18, 4", // Before sellIn: Quality decreases by 2, sellIn decreases by 1
        "0, 20, 16, -1", // After sellIn: Quality decreases by 4, sellIn decreases by 1
        "5, 1, 0, 4", // Quality never goes below 0
        "0, 0, 0, -1" // Edge case where quality is already at the lowest (0)
    })
    void testConjuredUpdate(final int initialSellIn, final int initialQuality,
        final int expectedQuality, final int expectedSellIn) {
        // Arrange
        final Item item = createItem("Conjured Mana Cake", initialSellIn, initialQuality);
        final ConjuredUpdater updater = new ConjuredUpdater(item);
        // Act
        updater.update();
        // Assert
        assertEquals(expectedQuality, item.quality);
        assertEquals(expectedSellIn, item.sellIn);
    }
}
