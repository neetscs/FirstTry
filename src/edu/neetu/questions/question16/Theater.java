package edu.neetu.questions.question16;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 6/13/13
 * Time: 2:17 PM
 */
public class Theater {
    TicketCounter[] ticketCounters;

    public Theater() {
        ticketCounters = new TicketCounter[3];
        int count = 0;
        while (count < 3) {
            //Initializing each of the ticket counter before any person comes to buy the ticket.
            ticketCounters[count] = new TicketCounter(count + 1);
            count++;
        }
    }

    List<TicketCounter> getTicketCounters(){
        return Arrays.asList(ticketCounters);
    }

    //Check if there are any people waiting in the Queue to buy tickets
    public boolean hasPersonWaiting(){
        return ticketCounters[0].sizeOfQueue() > 0 ||
                ticketCounters[1].sizeOfQueue() > 0 ||
                ticketCounters[2].sizeOfQueue() > 0;
    }
}
