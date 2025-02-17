package com.gildedrose.updater;

import static com.gildedrose.utils.factory.ItemFactory.createItem;
import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SulfurasUpdaterTest {

    @ParameterizedTest(name = "{index} => initialSellIn={0}, initialQuality={1}, expectedQuality={2}, expectedSellIn={3}")
    @CsvSource({
        "5, 80, 80, 5", // Before sellIn: Quality remains at 80, SellIn remains at 5
        "0, 80, 80, 0" // After sellIn: Quality remains at 80, SellIn remains at 0
    })
    void testSulfurasQualityRemainsConstant(int initialSellIn, int initialQuality, int expectedQuality, int expectedSellIn) {
        // Arrange
        final Item item = createItem("Sulfuras, Hand of Ragnaros", initialSellIn, initialQuality);
        final SulfurasUpdater updater = new SulfurasUpdater(item);
        // Act
        updater.update();
        // Assert
        assertEquals(expectedQuality, item.quality);
        assertEquals(expectedSellIn, item.sellIn);
    }

}
