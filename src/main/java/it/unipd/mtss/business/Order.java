////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.exception.ItemNotFoundException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.OrderInterface;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.EItem.ItemType;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface {

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) 
            throws ItemNotFoundException {
        double price;
        price = totalPrice(itemsOrdered);
        if(countItemType(itemsOrdered, ItemType.PROCESSOR)>5) {
            return price-Apply50PercDiscount(
                    FindCheaperProcessor(itemsOrdered));
        }
        if(countItemType(itemsOrdered, ItemType.MOUSE)>10){
            return price-FindCheaperMouse(itemsOrdered);
        }
        return price;
    }

    public double FindCheaperMouse(List<EItem> items)
            throws ItemNotFoundException{
        List<EItem> mouses = FindMouses(items);
        if(mouses.isEmpty()){
            throw new ItemNotFoundException("Any mouse found");
        }
        double lowestPrice = mouses.get(0).getPrice();
        for(EItem mouse : mouses){
            if(mouse.getPrice()<lowestPrice) lowestPrice = mouse.getPrice();
        }
        return lowestPrice;
    }

    public List<EItem> FindMouses(List<EItem> items){
        List<EItem> mouses = new ArrayList<>();
        for(EItem item : items) {
            if(item.getType() == ItemType.MOUSE) mouses.add(item);
        }
        return mouses;
    }

    public double FindCheaperProcessor(List<EItem> list)
            throws ItemNotFoundException {
        
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
            throw new ItemNotFoundException("no processor found");
        }
        return cheap;
    }

    public double Apply50PercDiscount(double price){
        if(price<=0) return 0;
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
