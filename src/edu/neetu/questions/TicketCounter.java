package edu.neetu.questions;

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
    int noOfPplInQueue;

    public TicketCounter(int counterNumber, int noOfPplInQueue, int numberOfTicketsSold, Queue<Person> newPersonQueue) {
        this.counterNumber = counterNumber;
        this.noOfPplInQueue = noOfPplInQueue;
        this.numberOfTicketsSold = numberOfTicketsSold;
        personQueue = newPersonQueue;
    }

    public Queue<Person> getPersonQueue() {
        return personQueue;
    }

    public int getNoOfPplInQueue() {
        return noOfPplInQueue;
    }


    public void setPersonQueue(Queue<Person> personQueue) {
        this.personQueue = personQueue;
    }

    public void setNoOfPplInQueue(int getNoOfPplInQueue) {
        this.noOfPplInQueue = getNoOfPplInQueue;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }


    Person getPersonAtCounter(){
        return getPersonQueue().element();
    }

    void purchase(){
        //After purchasing a ticket, the person is removed from the Queue and the number of tickets sold in that counter is incremented
            personQueue.remove();
            numberOfTicketsSold++;
            noOfPplInQueue--;
    }
}