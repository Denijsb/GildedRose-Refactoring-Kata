package com.gildedrose.factory;

import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.model.Item;
import com.gildedrose.updater.ItemUpdater;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ItemUpdaterFactoryTest {

    @ParameterizedTest
    @CsvSource({
        "'Aged Brie', AgedBrieUpdater",
        "'Backstage passes to a TAFKAL80ETC concert', BackstagePassUpdater",
        "'Sulfuras, Hand of Ragnaros', SulfurasUpdater",
        "'Conjured', ConjuredUpdater",
        "'Random Item', RegularItemUpdater"
    })
    void testGetUpdater(final String itemName, final String expectedUpdaterType) {
        // Arrange
        final Item item = new Item(itemName, 5, 20);
        // Act
        final ItemUpdater updater = ItemUpdaterFactory.getUpdater(item);
        // Assert
        assertEquals(expectedUpdaterType, updater.getClass().getSimpleName());
    }
}
