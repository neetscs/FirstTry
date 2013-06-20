package edu.neetu.questions.question16;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/11/13
 * Time: 2:29 PM
 */
public class Person {
    int id;
    TicketType type;
    public Person(int newId, TicketType newType) {
        id = newId;
        type = newType;
    }

    public TicketType getType() {
        return type;
    }

//    int getTicketProcessTime(Person person){
//        return getType().getProcessingTime(TicketType type);
//    }
    //The person checks for the smallest Queue amongst the ticket counters and joins it.
    public void gotoTheater(Theater theater){
        List<TicketCounter> ticketCounterList;
        TicketCounter selectedTicketCounter;
        ticketCounterList = theater.getTicketCounters();

        Collections.sort(ticketCounterList, new Comparator<TicketCounter>() {
            @Override
            public int compare(TicketCounter o1, TicketCounter o2) {
                return new Integer(o1.sizeOfQueue()).compareTo(o2.sizeOfQueue());
            }
        });

        selectedTicketCounter = ticketCounterList.get(0);
        joinTicketCounter(selectedTicketCounter);
    }
    //Person joins the selected Queue.
    public void joinTicketCounter(TicketCounter counter){
        counter.addPersonToQueue(this);
    }
}
