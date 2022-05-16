package it.unipd.mtss.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EItemTest {
    @Test(expected = IllegalArgumentException.class)
    public void CreateEItemWithNegativePriceShouldThrowException() {
        new EItem(EItem.ItemType.KEYBOARD, "Keychron K6", -10.0);
    }

    @Test
    public void CreateEItemWithCorrectValueShouldPass() {
        new EItem(EItem.ItemType.MOTHERBOARD, "Keychron K6", 10.0);
    }

    @Test
    public void CreateValidEItemShouldContainCorrectItemType() {
        EItem item = new EItem(EItem.ItemType.MOUSE, "Logitech G303", 10.0);
        assertEquals(item.getType(), EItem.ItemType.MOUSE);
    }

    @Test
    public void CreateValidEItemShouldContainCorrectName() {
        EItem item = new EItem(EItem.ItemType.MOUSE, "Logitech G303", 10.0);
        assertEquals(item.getName(), "Logitech G303");
    }

    @Test
    public void CreateValidEItemShouldContainCorrectPrice() {
        EItem item = new EItem(EItem.ItemType.PROCESSOR, "Ryzen 3700K", 10.0);
        assertEquals(item.getPrice(), 10.0, 0.001);
    }

}
