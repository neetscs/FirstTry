package edu.neetu.questions.question16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/11/13
 * Time: 2:34 PM
 */
public class TicketCounter {
    int counterNumber;
    Queue<Person> personQueue;
    int numberOfTicketsSold;

    public TicketCounter(int newCounterNumber) {
        counterNumber = newCounterNumber;
        numberOfTicketsSold = 0;
        personQueue = new LinkedList<>();
    }

    public Queue<Person> getPersonQueue() {
        return personQueue;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }

    protected Person getPersonAtCounter(){
        return getPersonQueue().element();
    }

    public void addPersonToQueue(Person person)
    {
        personQueue.add(person);
    }

    public int sizeOfQueue(){
        return personQueue.size();
    }

    public void sell(){
        //After purchasing a ticket, the person is removed from the Queue and the number of tickets sold in that counter is incremented
        personQueue.remove();
        numberOfTicketsSold++;
    }

    public int getNextPersonsWaitingTime() {
        return personQueue.element().getType().getProcessingTime();
    }

    public boolean hasPeopleWaiting() {
        return personQueue.size() > 0;
    }
}