////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.OrderInterface;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.EItem.ItemType;

import java.util.List;

public class Order implements OrderInterface {

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) {
        double price;
        price = totalPrice(itemsOrdered);
        return price;
    }

    public double totalPrice(List<EItem> items){
        double price = 0;
        for (EItem item : items) price += item.getPrice();
        return price;
    }

    public int getNumberofCPU(List<EItem> itemsOrdered){
        if(itemsOrdered.isEmpty())
        {
            return 0;
        }
        else
        {
            int n=0;
            for(int i=0; i<itemsOrdered.size(); i++)
            {
                if(itemsOrdered.get(i).getType()==ItemType.PROCESSOR) ++n;
            }
            return n;
        }
    }
}
