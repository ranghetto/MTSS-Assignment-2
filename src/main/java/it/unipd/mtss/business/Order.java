////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import java.util.Date;
import it.unipd.mtss.exception.ItemNotFoundException;
import it.unipd.mtss.exception.OrderException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.OrderInterface;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.EItem.ItemType;


import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface {

    private User user;
    private Date time;
    private List<EItem> list;

    public Order(User u, Date t, List<EItem> l){
        this.user=u;
        this.time=t;
        this.list=l; 
    }

    public User getUserOrder(){
        return user;
    }

    public Date getTimeOrder(){
        return time;
    }

    public List<EItem> getListOrder(){
        return list;
    }

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) 
            throws ItemNotFoundException, OrderException{
        double price;
        CheckOrdinability(itemsOrdered);
        price = totalPrice(itemsOrdered);
        if(price < 10) price += 2;
        if(price > 1000) price -= ApplyDiscount(price, 10);
        if(countItemType(itemsOrdered, ItemType.PROCESSOR)>5) {
            price -= ApplyDiscount(
                    FindCheaperProcessor(itemsOrdered),50);
        }
        if(countItemType(itemsOrdered, ItemType.MOUSE)>10){
            price -= FindCheaperMouse(itemsOrdered);
        }
        if(countItemType(itemsOrdered, ItemType.MOUSE)==
            countItemType(itemsOrdered, ItemType.KEYBOARD)) {
            price-=CheaperMouseKeyboard(itemsOrdered);
        }
        return price;
    } 

    public boolean CheckOrdinability(List<EItem> list)
            throws OrderException{
        if(list.size()<=30)
        {
            return true;
        }
        else
        {
            throw new OrderException("order with more than 30 items");
        }
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

        for (EItem eItem : list) {
            if (eItem.getType() == ItemType.PROCESSOR) {
                if (!found) cheap = eItem.getPrice();
                found = true;
                if (eItem.getPrice() < cheap) {
                    cheap = eItem.getPrice();
                }
            }
        }
        if(!found){
            throw new ItemNotFoundException("no processor found");
        }
        return cheap;
    }

    public double CheaperMouseKeyboard(List<EItem> list){
        double cheap=0;
        boolean first=true;
        for (EItem eItem : list) {
            if (eItem.getType() == ItemType.KEYBOARD ||
                    eItem.getType() == ItemType.MOUSE) {
                if (eItem.getPrice() < cheap || first) {
                    first = false;
                    cheap = eItem.getPrice();
                }
            }
        }
        return cheap;
    }

    public double ApplyDiscount(double price, double percentage){
        if(price<=0) return 0;
        return (percentage * price) / 100;
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
