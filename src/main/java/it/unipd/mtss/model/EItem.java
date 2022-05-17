////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

public class EItem {
    public enum ItemType {
        PROCESSOR,
        MOTHERBOARD,
        MOUSE,
        KEYBOARD
    }

    private final ItemType type;
    private final String name;
    private final double price;

    public EItem(ItemType type, String name, double price){
        if(price < 0) throw new IllegalArgumentException(
                "Cannot use negative value for 'price'");
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
