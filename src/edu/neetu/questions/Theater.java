package edu.neetu.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/13/13
 * Time: 2:17 PM
 */
public class Theater {
    TicketCounter[] ticketCounters = new TicketCounter[3];

    public void setTicketCounters(TicketCounter[] newTicketCounters) {
        ticketCounters = newTicketCounters;
    }

    List<TicketCounter> getTicketCounters(){
        List<TicketCounter> ticketCounterList = new ArrayList<>();
        int count = 0;
        while ( count < 3 ){
            ticketCounterList.add(ticketCounters[count]);
            count++;
        }
        return  ticketCounterList;
    }
}
