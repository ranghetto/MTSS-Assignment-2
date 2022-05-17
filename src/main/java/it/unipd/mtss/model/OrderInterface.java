////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import it.unipd.mtss.exception.ItemNotFoundException;
import it.unipd.mtss.exception.OrderException;
import java.util.List;

public interface OrderInterface {

    double getOrderPrice(List<EItem> itemsOrdered, User user) 
        throws ItemNotFoundException, OrderException;
}
