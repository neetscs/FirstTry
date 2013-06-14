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
    Queue<Person> noOfPplInCounter;
    int numberOfTicketsSold;
    int noOfPplInQueue;

    public TicketCounter(int counterNumber, int noOfPplInQueue, int numberOfTicketsSold, Queue<Person> newPersonQueue) {
        this.counterNumber = counterNumber;
        this.noOfPplInQueue = noOfPplInQueue;
        this.numberOfTicketsSold = numberOfTicketsSold;
        noOfPplInCounter = newPersonQueue;
    }

    public int getCounterNumber() {
        return counterNumber;
    }
    public Queue<Person> getNoOfPplInCounter() {
        return noOfPplInCounter;
    }

    public int getNoOfPplInQueue() {
        return noOfPplInQueue;
    }

    public void setCounterNumber(int counterNumber) {
        this.counterNumber = counterNumber;
    }

    public void setNoOfPplInCounter(Queue<Person> noOfPplInCounter) {
        this.noOfPplInCounter = noOfPplInCounter;
    }

    public void setNoOfPplInQueue(int getNoOfPplInQueue) {
        this.noOfPplInQueue = getNoOfPplInQueue;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }

    public void setNumberOfTicketsSold(int numberOfTicketsSold) {
        this.numberOfTicketsSold = numberOfTicketsSold;
    }

    void purchase(TicketType ticketType, Person person){
        int time = ticketType.getProcessingTime(person);
        if (time == 1){
            noOfPplInCounter.remove();
            numberOfTicketsSold++;
            noOfPplInQueue--;
        }
        else
            time--;
    }
}