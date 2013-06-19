package edu.neetu.questions;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/13/13
 * Time: 2:18 PM
 */
public class Simulation {
    public static int TOTAL_NUMBER_OF_PPL = 100, PERCENT_PPL_BUYING_SINGLE_TICKET = 31, PERCENT_PPL_BUYING_GROUP_TICKET = 47;
    void run() {
        Theater theater = new Theater();
        TicketCounter[] ticketCounters = new TicketCounter[3];
        int count = 0;
        List<Person> personList = generatePersonList();
        Queue<Person> personQueue = new LinkedList<>();
        //Initializing each of the ticket counter before any person comes to buy the ticket.
        while (count < 3) {
            ticketCounters[count] = new TicketCounter(count + 1, 0, 0, personQueue);
            count++;
        }
        theater.setTicketCounters(ticketCounters);
        count = 0;
        Person person;
        //100 people with different ticket types goes to the theater.
        while (count < TOTAL_NUMBER_OF_PPL){
            person = new Person(personList.get(count).getId(), personList.get(count).getType());
            person.gotoTheater(theater);
            count++;
        }

        int initialFirstPersonWaitTime = 0, initialSecondPersonWaitTime = 0, initialThirdPersonWaiting = 0, totalTimeElapsed = 0;
        while (theater.hasPersonWaiting()) {
            Person person1 = ticketCounters[0].getPersonAtCounter();
            Person person2 = ticketCounters[1].getPersonAtCounter();
            Person person3 = ticketCounters[2].getPersonAtCounter();
            //first person in the first counter purchasing the ticket.
            int firstPersonWaitTime = person1.getTicketProcessTime(person1);
            if (ticketCounters[0].getNoOfPplInQueue() != 0) {
                while (initialFirstPersonWaitTime < firstPersonWaitTime){
                    firstPersonWaitTime--;
                    totalTimeElapsed++;
                }
                if (firstPersonWaitTime == 0){
                    ticketCounters[0].purchase();
                }
            }
            //first person in the second counter purchasing the ticket.
            int secondPersonWaitTime = person2.getTicketProcessTime(person2);
            if (ticketCounters[1].getNoOfPplInQueue() != 0) {
                while (initialSecondPersonWaitTime < secondPersonWaitTime){
                    secondPersonWaitTime--;
                    totalTimeElapsed++;
                }
                if (secondPersonWaitTime == 0){
                    ticketCounters[1].purchase();
                }
            }
            //first person in the third counter purchasing the ticket.
            int thirdPersonWaiting = person3.getTicketProcessTime(person3);
            if (ticketCounters[2].getNoOfPplInQueue() != 0) {
                while (initialThirdPersonWaiting < thirdPersonWaiting){
                    thirdPersonWaiting--;
                    totalTimeElapsed++;
                }
                if (thirdPersonWaiting == 0){
                    ticketCounters[2].purchase();
                }
            }
        }
        System.out.println("Total time taken by all the people to purchase tickets: " +totalTimeElapsed);
        System.out.println("Number of People serviced by Counter 1: " + ticketCounters[0].getNumberOfTicketsSold());
        System.out.println("Number of People serviced by Counter 2: " + ticketCounters[1].getNumberOfTicketsSold());
        System.out.println("Number of People serviced by Counter 3: " + ticketCounters[2].getNumberOfTicketsSold());
    }
    //GeneratePersonList function generates a list of people having ticket type Single, Group or Internet in a random order.
    List<Person> generatePersonList() {
        List<Person> personList = new ArrayList<>();
        int counter = 1, randomGeneratedNumber;
        Random randomGenerator = new Random();
        while (counter <= TOTAL_NUMBER_OF_PPL) {
            randomGeneratedNumber = randomGenerator.nextInt(TOTAL_NUMBER_OF_PPL);
            if ( randomGeneratedNumber <= PERCENT_PPL_BUYING_SINGLE_TICKET) {
                personList.add(new Person(randomGeneratedNumber, TicketType.SINGLE));
            }
            else if (randomGeneratedNumber >= PERCENT_PPL_BUYING_SINGLE_TICKET + 1 && randomGeneratedNumber <= PERCENT_PPL_BUYING_SINGLE_TICKET + PERCENT_PPL_BUYING_GROUP_TICKET) {
                personList.add(new Person(randomGeneratedNumber, TicketType.GROUP));
            }
            else if (randomGeneratedNumber >= PERCENT_PPL_BUYING_SINGLE_TICKET + PERCENT_PPL_BUYING_GROUP_TICKET + 1 ){
                personList.add(new Person(randomGeneratedNumber, TicketType.INTERNET));
            }
            counter++;
        }
        return personList;
    }
}
