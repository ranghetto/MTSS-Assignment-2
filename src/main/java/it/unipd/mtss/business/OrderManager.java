////////////////////////////////////////////////////////////////////
// Matteo Rango 2008066
// Antonio Oseliero 1226325
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.sql.Timestamp;
import java.util.List;

public class OrderManager {
    public List<Order> OrderGifted(List<Order> list){
        Collections.shuffle(list);

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date1, date2;
        Timestamp t1, t2;
        List<Order> temp=new ArrayList<>();
        int size=list.size()<10 ? list.size() : 10;

        try{
            date1= dateFormat.parse("18:00"); 
            date2= dateFormat.parse("19:00");
            t1 = new Timestamp(date1.getTime());
            t2 = new Timestamp(date2.getTime()); 
            for(int i=0; i<size; i++)
            {
                if(list.get(i).getUserOrder().getAge()<18)
                {
                    if(list.get(i).getTimeOrder().compareTo(t1)>=0 &&
                       list.get(i).getTimeOrder().compareTo(t2)<=0)
                    {
                        temp.add(list.get(i));
                    }
            }
        }
        }catch(ParseException e){return temp;}

        return temp;     
    }
}
