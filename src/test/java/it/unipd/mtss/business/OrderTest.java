package it.unipd.mtss.business;

import it.unipd.mtss.exception.CheaperProcessorException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.User;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderTest {
    
    Order order;
    List<EItem> list;

    @Before
     public void GenerateEnvironment(){
        order=new Order();
        list=Collections.emptyList();
    }
    
    //getOrderPrice

    @Test
    public void MethodGetOrderPriceShouldReturnTotal() throws CheaperProcessorException {
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 16.0),
            new EItem(ItemType.KEYBOARD, "b", 30.0),
            new EItem(ItemType.MOTHERBOARD, "c", 14.0)
        );
        assertEquals(60.0, order.getOrderPrice(list, user), 0.001);
        order.getOrderPrice(list, user);
    }

    @Test
    public void MethodGetOrderPriceShouldDiscountCheaperProcessor() throws CheaperProcessorException{
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
            new EItem(ItemType.PROCESSOR, "a", 30.0),
            new EItem(ItemType.PROCESSOR, "b", 20.0),
            new EItem(ItemType.PROCESSOR, "c", 10.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0),
            new EItem(ItemType.PROCESSOR, "e", 5.0),
            new EItem(ItemType.PROCESSOR, "f", 4.0),
            new EItem(ItemType.MOUSE, "g", 5.0)
        );
        assertEquals(78, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceShouldGiftCheaperMouse() throws CheaperProcessorException{
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 30.0),
                new EItem(ItemType.MOUSE, "b", 20.0),
                new EItem(ItemType.MOUSE, "c", 10.0),
                new EItem(ItemType.MOUSE, "d", 5.0),
                new EItem(ItemType.PROCESSOR, "e", 5.0),
                new EItem(ItemType.MOUSE, "f", 5.0),
                new EItem(ItemType.MOTHERBOARD, "a", 30.0),
                new EItem(ItemType.MOUSE, "b", 20.0),
                new EItem(ItemType.MOUSE, "c", 10.0),
                new EItem(ItemType.MOUSE, "d", 5.0),
                new EItem(ItemType.MOUSE, "e", 5.0),
                new EItem(ItemType.MOUSE, "f", 4.0),
                new EItem(ItemType.MOUSE, "g", 5.0)
        );
        assertEquals(150.0, order.getOrderPrice(list, user), 0.001);
    }

    // getMousesInItems
    @Test
    public void MethodGetMousesInItemsShouldReturnNonEmptyList(){

    }

    @Test
    public void MethodGetMousesInItemsShouldReturnEmptyList(){

    }

    //getNumberOfCPU

    @Test
    public void MethodCountItemTypeShouldReturn0IfEmpty(){
        assertEquals(0, order.countItemType(list, ItemType.KEYBOARD));
    }

    @Test
    public void MethodCountItemTypeShouldReturnCorrectValues(){
        list= Arrays.asList(
            new EItem(ItemType.PROCESSOR, "a", 12.0),
            new EItem(ItemType.PROCESSOR, "b", 30.0), 
            new EItem(ItemType.MOTHERBOARD, "c", 12.0)
        );
        assertEquals(2,order.countItemType(list,ItemType.PROCESSOR));
    } 

    @Test
    public void MethodCountItemTypeShouldReturn0IfNoItemInList(){
        list= Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 12.0),
            new EItem(ItemType.KEYBOARD, "b", 30.0), 
            new EItem(ItemType.MOTHERBOARD, "c", 12.0)
        );
        assertEquals(0,order.countItemType(list, ItemType.PROCESSOR));
    }

    // totalPrice

    @Test
    public void MethodTotalPriceShouldReturnCorrectValue(){
        list= Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 12.0),
            new EItem(ItemType.KEYBOARD, "b", 30.0),
            new EItem(ItemType.MOTHERBOARD, "c", 12.0)
        );
        assertEquals(54.0, order.totalPrice(list), 0.001);
    }

    @Test
    public void MethodTotalPriceShouldReturn0IfListEmpty(){
        assertEquals(0.0, order.totalPrice(list), 0.001);
    }

    // CheaperProcessor

    @Test
    public void MethodCheaperProcessorShouldReturnCheaperProcessorPrice() throws CheaperProcessorException {
        list= Arrays.asList(
            new EItem(ItemType.PROCESSOR, "a", 30.0),
            new EItem(ItemType.PROCESSOR, "b", 20.0),
            new EItem(ItemType.PROCESSOR, "c", 10.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0),
            new EItem(ItemType.PROCESSOR, "e", 5.0),
            new EItem(ItemType.PROCESSOR, "f", 4.0),
            new EItem(ItemType.MOUSE, "g", 5.0)
        );
        assertEquals(4.0, order.FindCheaperProcessor(list),0.001);
    }

    @Test
    public void MethodCheaperProcessorShouldLaunchExceptionOnFreeProcessor() throws CheaperProcessorException {
        list= Arrays.asList(
            new EItem(ItemType.PROCESSOR, "a", 30.0),
            new EItem(ItemType.PROCESSOR, "b", 20.0),
            new EItem(ItemType.PROCESSOR, "c", 10.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0),
            new EItem(ItemType.PROCESSOR, "e", 5.0),
            new EItem(ItemType.PROCESSOR, "f", 0.0),
            new EItem(ItemType.MOUSE, "g", 5.0)
        );
        assertEquals(0, order.FindCheaperProcessor(list), 0.001); 
    }

    @Test(expected = CheaperProcessorException.class)
    public void MethodCheaperProcessorShouldLaunchExceptionOnNoProcessor()
            throws CheaperProcessorException {
        list= Arrays.asList(
            new EItem(ItemType.KEYBOARD, "a", 30.0),
            new EItem(ItemType.MOUSE, "g", 5.0)
        );
        order.FindCheaperProcessor(list);
    }

    @Test(expected = CheaperProcessorException.class)
    public void MethodCheaperProcessorShouldLaunchExceptionOnEmptyList()
            throws CheaperProcessorException {
        order.FindCheaperProcessor(list);
    }

    //Apply50PercDiscount

    @Test
    public void MethodApply50PercDiscountShouldReturn0OnValue0(){
        assertEquals(0.0, order.Apply50PercDiscount(0.0), 0.001);
    }

    @Test
    public void MetohdApply50PercDiscountShouldReturnCorrectValues(){
        assertEquals(8, order.Apply50PercDiscount(16), 0.001);
    }

}
