package it.unipd.mtss.business;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.EItem.ItemType;
import it.unipd.mtss.model.User;
import it.unipd.mtss.business.Order;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.*;

public class OrderManagerTest {
    
    OrderManager manager;
    Date date18, date20;
    List<EItem> itemList, itemListCompare;
    List<Order> list, compare;

    @Before
    public void GenerateEnvironment(){
        manager=new OrderManager();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try{
            date18= dateFormat.parse("18:00"); 
            date20= dateFormat.parse("20:00"); 
        }catch(ParseException e){}
        itemList=new ArrayList<EItem>();
        itemListCompare=new ArrayList<EItem>();
        list=new ArrayList<Order>();
        compare=new ArrayList<Order>();
    }

    @Test
    public void MethodOrderGiftedShouldGiftAllLessThan10Order() {
        list=Arrays.asList(
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                )
        );
        assertEquals(1, manager.OrderGifted(list).size());
    }

    @Test
    public void MethodOrderGiftedShouldGiftAllMoreThan10Order() {
        list=Arrays.asList(
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                ),
                new Order(
                        new User(0, 14, "name", "surname"),
                        date18,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                )
        );
        assertEquals(10, manager.OrderGifted(list).size());  
    }

    @Test
    public void MethodOrderGiftedShouldntGiftLessThan10Order() {
        list=Arrays.asList(
                new Order(
                        new User(0, 20, "name", "surname"),
                        date20,
                        itemList=Arrays.asList(
                            new EItem(ItemType.MOUSE, "a", 16.0)
                        )  
                )
        );
        assertEquals(0, manager.OrderGifted(list).size());
    }

    @Test
    public void MethodOrderGiftedShouldntGiftMoreThan10Order() {
        list=Arrays.asList(
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            )
        );
        assertEquals(0, manager.OrderGifted(list).size());
    }

    @Test
    public void MethodOrderGiftedShouldntGiftCorrectOrders() {
        list=Arrays.asList(
            new Order(
                new User(0, 25, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date18,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 14, "name", "surname"),
                date20,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            ),
            new Order(
                new User(0, 25, "name", "surname"),
                date18,
                itemList=Arrays.asList(
                    new EItem(ItemType.MOUSE, "a", 16.0)
                )  
            )
        );
        assertEquals(1, manager.OrderGifted(list).size());
    }

}
