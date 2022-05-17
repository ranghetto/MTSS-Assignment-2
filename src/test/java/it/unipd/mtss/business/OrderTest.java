package it.unipd.mtss.business;

import it.unipd.mtss.exception.ItemNotFoundException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.User;
import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

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
    public void MethodGetOrderPriceShouldReturnTotal() throws ItemNotFoundException {
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 16.0),
            new EItem(ItemType.MOTHERBOARD, "b", 30.0),
            new EItem(ItemType.MOTHERBOARD, "c", 14.0)
        );
        assertEquals(60.0, order.getOrderPrice(list, user), 0.001);
        order.getOrderPrice(list, user);
    }

    @Test
    public void MethodGetOrderPriceShouldAddCommission() throws ItemNotFoundException {
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Collections.singletonList(
                new EItem(ItemType.MOUSE, "g", 5.0)
        );
        assertEquals(7, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceShouldDiscountCheaperProcessor() throws ItemNotFoundException {
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
    public void MethodGetOrderPriceShouldGiftCheaperMouse() throws ItemNotFoundException {
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

    @Test
    public void MethodGetOrderPriceShouldDiscount10FromTotalPrice() throws ItemNotFoundException {
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 300.0),
                new EItem(ItemType.MOUSE, "b", 50.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.PROCESSOR, "e", 300.0),
                new EItem(ItemType.MOTHERBOARD, "a", 200.0),
                new EItem(ItemType.PROCESSOR, "b", 800.0)
        );
        assertEquals(1800.0, order.getOrderPrice(list, user), 0.001);
    }
    @Test
    public void MethodGetOrderPriceShouldDiscount10FromTotalPriceAndGiftMouse() throws ItemNotFoundException {
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 300.0),
                new EItem(ItemType.MOUSE, "b", 50.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.PROCESSOR, "e", 300.0),
                new EItem(ItemType.MOTHERBOARD, "a", 200.0),
                new EItem(ItemType.PROCESSOR, "b", 800.0)
        );
        assertEquals(3010.0, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceShouldDiscount10FromTotalPriceAndGiftMouseAndDiscountProcessor()
            throws ItemNotFoundException {
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.MOUSE, "b", 50.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOUSE, "d", 50.0),
                new EItem(ItemType.MOTHERBOARD, "a", 200.0),
                new EItem(ItemType.PROCESSOR, "b", 800.0),
                new EItem(ItemType.PROCESSOR, "e", 600.0),
                new EItem(ItemType.PROCESSOR, "e", 300.0),
                new EItem(ItemType.PROCESSOR, "e", 300.0),
                new EItem(ItemType.PROCESSOR, "e", 300.0),
                new EItem(ItemType.PROCESSOR, "e", 300.0)
        );
        assertEquals(4210.0, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceShouldGiftCheaperIfMouseEqualKeyboard()
            throws ItemNotFoundException{
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.KEYBOARD, "c", 300.0),
                new EItem(ItemType.KEYBOARD, "c", 300.0),
                new EItem(ItemType.PROCESSOR, "c", 300.0)
        );
        assertEquals(1050, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceShouldReturn0IfMouseDifKeyboard()
            throws ItemNotFoundException{
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 300.0),
                new EItem(ItemType.MOUSE, "c", 300.0),
                new EItem(ItemType.KEYBOARD, "c", 300.0),
                new EItem(ItemType.PROCESSOR, "c", 300.0)
        );
        assertEquals(1080, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceShouldGiftCheaperIfRequirementNotMet()
            throws ItemNotFoundException{
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.PROCESSOR, "c", 300.0),
                new EItem(ItemType.PROCESSOR, "c", 300.0)
        );
        assertEquals(600, order.getOrderPrice(list, user), 0.001);
    }

    @Test
    public void MethodGetOrderPriceApplyAllDiscount()
            throws ItemNotFoundException{
        User user = new User(1, 22, "Aldo", "Giovanni");
        list= Arrays.asList(
                new EItem(ItemType.PROCESSOR, "p1", 300.0),
                new EItem(ItemType.PROCESSOR, "p2", 300.0),
                new EItem(ItemType.PROCESSOR, "p3", 300.0),
                new EItem(ItemType.PROCESSOR, "p4", 300.0),
                new EItem(ItemType.PROCESSOR, "p5", 300.0),
                new EItem(ItemType.PROCESSOR, "p6", 300.0),
                new EItem(ItemType.MOUSE, "m1", 300.0),
                new EItem(ItemType.MOUSE, "m2", 300.0),
                new EItem(ItemType.MOUSE, "m3", 300.0),
                new EItem(ItemType.MOUSE, "m4", 300.0),
                new EItem(ItemType.MOUSE, "m5", 300.0),
                new EItem(ItemType.MOUSE, "m6", 300.0),
                new EItem(ItemType.MOUSE, "m7", 300.0),
                new EItem(ItemType.MOUSE, "m8", 300.0),
                new EItem(ItemType.MOUSE, "m9", 300.0),
                new EItem(ItemType.MOUSE, "m10", 300.0),
                new EItem(ItemType.MOUSE, "m11", 300.0),
                new EItem(ItemType.KEYBOARD, "k1", 300.0),
                new EItem(ItemType.KEYBOARD, "k2", 300.0),
                new EItem(ItemType.KEYBOARD, "k3", 300.0),
                new EItem(ItemType.KEYBOARD, "k4", 300.0),
                new EItem(ItemType.KEYBOARD, "k5", 300.0),
                new EItem(ItemType.KEYBOARD, "k6", 300.0),
                new EItem(ItemType.KEYBOARD, "k7", 300.0),
                new EItem(ItemType.KEYBOARD, "k8", 300.0),
                new EItem(ItemType.KEYBOARD, "k9", 300.0),
                new EItem(ItemType.KEYBOARD, "k10", 300.0),
                new EItem(ItemType.KEYBOARD, "k11", 300.0)
        );
        assertEquals(6810, order.getOrderPrice(list, user), 0.001);
    }

    // getCheaperMouse

    @Test(expected = ItemNotFoundException.class)
    public void MethodFindCheaperMouseShouldReturnException()
            throws ItemNotFoundException {
        list= Arrays.asList(
                new EItem(ItemType.PROCESSOR, "e", 5.0),
                new EItem(ItemType.MOTHERBOARD, "a", 30.0)
        );
        order.FindCheaperMouse(list);
    }

    @Test
    public void MethodFindCheaperMouseShouldReturnLowestPrice() throws ItemNotFoundException {
        list= Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 30.0),
            new EItem(ItemType.MOUSE, "b", 20.0),
            new EItem(ItemType.MOUSE, "c", 10.0),
            new EItem(ItemType.MOUSE, "d", 5.0),
            new EItem(ItemType.PROCESSOR, "e", 5.0),
            new EItem(ItemType.MOUSE, "f", 20.0),
            new EItem(ItemType.MOTHERBOARD, "a", 30.0)
        );
        assertEquals(5.0, order.FindCheaperMouse(list), 0.001);
    }

    // getMousesInItems
    @Test
    public void MethodFindMousesShouldReturnNonEmptyList(){
        list= Arrays.asList(
                new EItem(ItemType.MOUSE, "a", 30.0),
                new EItem(ItemType.MOUSE, "b", 20.0),
                new EItem(ItemType.MOUSE, "c", 10.0),
                new EItem(ItemType.MOUSE, "d", 5.0),
                new EItem(ItemType.PROCESSOR, "e", 5.0),
                new EItem(ItemType.MOUSE, "f", 5.0),
                new EItem(ItemType.MOTHERBOARD, "a", 30.0)
        );
        assertEquals(5, order.FindMouses(list).size());
    }

    @Test
    public void MethodGetMousesInItemsShouldReturnEmptyList(){
        list= Arrays.asList(
                new EItem(ItemType.KEYBOARD, "a", 30.0),
                new EItem(ItemType.PROCESSOR, "e", 5.0),
                new EItem(ItemType.MOTHERBOARD, "a", 30.0)
        );
        assertTrue(order.FindMouses(list).isEmpty());
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
    public void MethodCheaperProcessorShouldReturnCheaperProcessorPrice() throws ItemNotFoundException {
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
    public void MethodCheaperProcessorShouldLaunchExceptionOnFreeProcessor() throws ItemNotFoundException {
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

    @Test(expected = ItemNotFoundException.class)
    public void MethodCheaperProcessorShouldLaunchExceptionOnNoProcessor()
            throws ItemNotFoundException {
        list= Arrays.asList(
            new EItem(ItemType.KEYBOARD, "a", 30.0),
            new EItem(ItemType.MOUSE, "g", 5.0)
        );
        order.FindCheaperProcessor(list);
    }

    @Test(expected = ItemNotFoundException.class)
    public void MethodCheaperProcessorShouldLaunchExceptionOnEmptyList()
            throws ItemNotFoundException {
        order.FindCheaperProcessor(list);
    }

    //ApplyDiscount

    @Test
    public void MethodApplyDiscountShouldReturn0OnValue0(){
        assertEquals(0.0, order.ApplyDiscount(0.0, 30), 0.001);
    }

    @Test
    public void MethodApplyDiscountShouldReturnHalfPrice(){
        assertEquals(8, order.ApplyDiscount(16, 50), 0.001);
    }

    //CheaperMouseKeyboard

    @Test
    public void MethodCheaperMouseKeyboardReturnCheapest(){
        list=Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 30.0),
            new EItem(ItemType.MOUSE, "b", 6.0),
            new EItem(ItemType.KEYBOARD, "c", 10.0),
            new EItem(ItemType.KEYBOARD, "d", 6.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0)
        );
        assertEquals(6, order.CheaperMouseKeyboard(list), 0.001);
    }

    @Test
    public void MethodCheaperMouseKeyboardReturn0IfFreeMouse(){
        list=Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 30.0),
            new EItem(ItemType.MOUSE, "b", 0.0),
            new EItem(ItemType.KEYBOARD, "c", 10.0),
            new EItem(ItemType.KEYBOARD, "d", 6.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0)
        );
        assertEquals(0, order.CheaperMouseKeyboard(list), 0.001);
    }

    @Test
    public void MethodCheaperMouseKeyboardReturn0IfNoKeyboardOrMouse(){
        list=Arrays.asList(
            new EItem(ItemType.PROCESSOR, "a", 30.0),
            new EItem(ItemType.PROCESSOR, "b", 12.0),
            new EItem(ItemType.PROCESSOR, "c", 10.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0),
            new EItem(ItemType.PROCESSOR, "d", 6.0)
        );
        assertEquals(0, order.CheaperMouseKeyboard(list), 0.001);
    }

    @Test
    public void MethodCheaperMouseKeyboardReturn0IfEmptyList(){
        assertEquals(0, order.CheaperMouseKeyboard(list), 0.001);
    }

}
