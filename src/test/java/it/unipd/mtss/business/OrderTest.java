package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class OrderTest {
    @Test
    public void MethodGetOrderPriceShouldExists() {
        Order order = new Order();
        User user = new User(1, 22, "Aldo", "Giovanni");
        List<EItem> list = Collections.emptyList();
        order.getOrderPrice(list, user);
    }
}
