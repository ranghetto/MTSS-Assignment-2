////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.OrderInterface;
import it.unipd.mtss.model.User;

import java.util.List;

public class Order implements OrderInterface {

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) {
        return 0;
    }
}
