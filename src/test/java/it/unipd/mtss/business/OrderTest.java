package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.User;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

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
    public void MethodGetOrderPriceShouldExists() {
        User user = new User(1, 22, "Aldo", "Giovanni");
        order.getOrderPrice(list, user);
    }

    //getNumberOfCPU

    @Test
    public void MethodGetNumberOfCPUShouldReturn0IfEmpty(){
        assertEquals(order.getNumberofCPU(list), 0);
    } 

    @Test
    public void MethodGetNumberOfCPUShouldReturnCorrectValues(){
        List<EItem> list= Arrays.asList(
            new EItem(ItemType.PROCESSOR, "a", 12.0),
            new EItem(ItemType.PROCESSOR, "b", 30.0), 
            new EItem(ItemType.MOTHERBOARD, "c", 12.0)
        );
        assertEquals(order.getNumberofCPU(list), 2);
    } 

    @Test
    public void MethodGetNumberOfCPUShouldReturn0IfNoProcessorInList(){
        List<EItem> list= Arrays.asList(
            new EItem(ItemType.MOUSE, "a", 12.0),
            new EItem(ItemType.KEYBOARD, "b", 30.0), 
            new EItem(ItemType.MOTHERBOARD, "c", 12.0)
        );
        assertEquals(order.getNumberofCPU(list), 0);
    }
}
