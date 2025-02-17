package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.utils.factory.ItemFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest(name = "{index} => itemName={0}, initialQuality={1}, expectedQuality={2}, expectedSellIn={3}")
    @CsvSource({
        "'Aged Brie', 20, 21, 4",  // Aged Brie: Quality increases by 1, SellIn decreases by 1
        "'Backstage passes to a TAFKAL80ETC concert', 20, 23, 4",  // Backstage Passes: Quality increases by 3, SellIn decreases by 1
        "'Conjured', 20, 18, 4",  // Conjured: Quality decreases by 2, SellIn decreases by 1
        "'Random Item', 20, 19, 4",  // Random Item: Quality decreases by 1, SellIn decreases by 1
        "'Sulfuras, Hand of Ragnaros', 80, 80, 5"  // Sulfuras: Quality stays at 80, SellIn remains the same
    })
    void testUpdateQualityForItems(final String itemName, final int initialQuality,
        final int expectedQualityAfterUpdate, final int expectedSellInAfterUpdate) {
        // Arrange
        final Item item = ItemFactory.createItem(itemName, 5, initialQuality);
        final GildedRose app = new GildedRose(new Item[]{item});
        // Act
        app.updateQuality();
        // Assert
        assertEquals(expectedQualityAfterUpdate, item.quality);
        assertEquals(expectedSellInAfterUpdate, item.sellIn);
    }
}
