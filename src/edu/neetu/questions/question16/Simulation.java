package edu.neetu.questions.question16;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/13/13
 * Time: 2:18 PM
 */
public class Simulation {
    public static int TOTAL_NUMBER_OF_PPL = 100, PERCENT_PPL_BUYING_SINGLE_TICKET = 31, PERCENT_PPL_BUYING_GROUP_TICKET = 47;
    public void run() {

        List<Person> personList = generatePersonList();
        Theater theater = new Theater();

        for (Person person : personList) {
            person.gotoTheater(theater);
        }

        TicketType ticketType1, ticketType2, ticketType3;

        List<TicketCounter> ticketCounters = theater.getTicketCounters();
        Person person1 = ticketCounters.get(0).getPersonAtCounter();
        Person person2 = ticketCounters.get(1).getPersonAtCounter();
        Person person3 = ticketCounters.get(2).getPersonAtCounter();

        ticketType1 = person1.getType();
        ticketType2 = person2.getType();
        ticketType3 = person3.getType();

        int firstPersonWaitTime = ticketType1.getProcessingTime();
        int secondPersonWaitTime = ticketType2.getProcessingTime();
        int thirdPersonWaitTime = ticketType3.getProcessingTime();

        int totalTimeElapsed = 0;
        while (theater.hasPersonWaiting()) {
             //first person in the first counter purchasing the ticket.
            if (firstPersonWaitTime > 0) {
                firstPersonWaitTime--;
            }
            if (firstPersonWaitTime == 0 && ticketCounters.get(0).hasPeopleWaiting()) {
                ticketCounters.get(0).sell();
                if (ticketCounters.get(0).sizeOfQueue() != 0) {
                    firstPersonWaitTime = ticketCounters.get(0).getNextPersonsWaitingTime();
                }
            }

            //first person in the second counter purchasing the ticket.
            if (secondPersonWaitTime > 0) {
                secondPersonWaitTime--;
            }
            if (secondPersonWaitTime == 0 && ticketCounters.get(1).hasPeopleWaiting()) {
                ticketCounters.get(1).sell();
                if (ticketCounters.get(1).sizeOfQueue() != 0) {
                    secondPersonWaitTime = ticketCounters.get(1).getNextPersonsWaitingTime();
                }
            }

            //first person in the third counter purchasing the ticket.
            if (thirdPersonWaitTime > 0) {
                thirdPersonWaitTime--;
            }
            if (thirdPersonWaitTime == 0 && ticketCounters.get(2).hasPeopleWaiting()) {
                ticketCounters.get(2).sell();
                if (ticketCounters.get(2).sizeOfQueue() != 0) {
                    thirdPersonWaitTime = ticketCounters.get(2).getNextPersonsWaitingTime();
                }
            }

            totalTimeElapsed++;
        }

        System.out.println("Total time taken by all the people to purchase tickets: " + totalTimeElapsed);
        System.out.println("Number of People serviced by Counter 1: " + ticketCounters.get(0).getNumberOfTicketsSold());
        System.out.println("Number of People serviced by Counter 2: " + ticketCounters.get(1).getNumberOfTicketsSold());
        System.out.println("Number of People serviced by Counter 3: " + ticketCounters.get(2).getNumberOfTicketsSold());
    }
    //GeneratePersonList function generates a list of people having ticket type Single, Group or Internet in a random order.
    protected List<Person> generatePersonList() {
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
