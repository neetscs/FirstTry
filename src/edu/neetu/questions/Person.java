package edu.neetu.questions;

import java.util.List;
import java.util.Queue;

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
    public int getId() {
        return id;
    }

    public TicketType getType() {
        return type;
    }

    int getTicketProcessTime(Person person){
        return getType().getProcessingTime(person);
    }

    void gotoTheater(Theater theater){
        List<TicketCounter> ticketCounterList ;
        TicketCounter selectedTicketCounter;
        ticketCounterList = theater.getTicketCounters();
        if (ticketCounterList.get(0).getNoOfPplInQueue() == ticketCounterList.get(1).getNoOfPplInQueue() ||
                ticketCounterList.get(0).getNoOfPplInQueue() == ticketCounterList.get(2).getNoOfPplInQueue()) {
            selectedTicketCounter = ticketCounterList.get(0);
        }
        else if (ticketCounterList.get(1).getNoOfPplInQueue() == ticketCounterList.get(2).getNoOfPplInQueue()) {
            selectedTicketCounter = ticketCounterList.get(1);
        }
        else if (ticketCounterList.get(0).getNoOfPplInQueue() < ticketCounterList.get(1).getNoOfPplInQueue() &&
            ticketCounterList.get(0).getNoOfPplInQueue() < ticketCounterList.get(2).getNoOfPplInQueue()) {
            selectedTicketCounter = ticketCounterList.get(0);
        }
         else if (ticketCounterList.get(1).getNoOfPplInQueue() < ticketCounterList.get(2).getNoOfPplInQueue() &&
                ticketCounterList.get(1).getNoOfPplInQueue() < ticketCounterList.get(0).getNoOfPplInQueue()) {
            selectedTicketCounter = ticketCounterList.get(1);
        }
        else
            selectedTicketCounter = ticketCounterList.get(2);

        joinTicketCounter(selectedTicketCounter);
    }

    void joinTicketCounter(TicketCounter counter){
        Queue<Person> personQueue = counter.getPersonQueue();
        personQueue.add(new Person(id, type));
        counter.setPersonQueue(personQueue);
        counter.setNoOfPplInQueue(counter.getNoOfPplInQueue()+1);
    }
}
