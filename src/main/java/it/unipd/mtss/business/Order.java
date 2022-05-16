////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.exception.CheaperProcessorException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.OrderInterface;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.EItem.ItemType;

import java.util.List;

public class Order implements OrderInterface {

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) 
            throws CheaperProcessorException {
        double price;
        price = totalPrice(itemsOrdered);
        if(countItemType(itemsOrdered, ItemType.PROCESSOR)>5)
        {
            price=price-Apply50PercDiscount(FindCheaperProcessor(itemsOrdered));
        }
        return price;
    }

    public double FindCheaperProcessor(List<EItem> list)
            throws CheaperProcessorException {
        
        double cheap=0;
        boolean found=false;

        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).getType()==ItemType.PROCESSOR)
            {   
                if(i==0) cheap=list.get(i).getPrice();
                found=true;
                if(list.get(i).getPrice()<cheap){
                    cheap=list.get(i).getPrice();
                }
            }  
        }
        if(!found){
            throw new CheaperProcessorException("no processor found");
        }
        return cheap;
    }

    public double Apply50PercDiscount(double price){
        if(price<=0)
        {
            return 0;
        }
        return price/2;
    }

    public double totalPrice(List<EItem> items){
        double price = 0;
        for (EItem item : items) price += item.getPrice();
        return price;
    }

    public int countItemType(List<EItem> items, ItemType type){
        int count = 0;
        for (EItem item : items) {
            if (item.getType() == type) count++;
        }
        return count;
    }
}
