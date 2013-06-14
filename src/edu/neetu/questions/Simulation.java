package edu.neetu.questions;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/13/13
 * Time: 2:18 PM
 */
public class Simulation {
    List<Person> generatePersonList() {
        List<Person> personList = new ArrayList<>();
        int counter = 1, randomGeneratedNumber;
        Random randomGenerator = new Random();
        while (counter <= 100) {
            randomGeneratedNumber = randomGenerator.nextInt(100);
            if ( randomGeneratedNumber <= 31) {
                personList.add(new Person(randomGeneratedNumber, TicketType.SINGLE));
            }
            else if (randomGeneratedNumber >= 32 && randomGeneratedNumber <= 78) {
                personList.add(new Person(randomGeneratedNumber, TicketType.GROUP));
            }
            else if (randomGeneratedNumber >= 79 ){
                personList.add(new Person(randomGeneratedNumber, TicketType.INTERNET));
            }
            counter++;
        }
    return personList;
    }

    void run() {
        Theater theater = new Theater();

        TicketCounter[] ticketCounters = new TicketCounter[3];
        int count = 0, eachMinElapsed = 1, totalMins = 0;

        List<Person> personList = generatePersonList();
        Queue<Person> personQueue = new LinkedList<>();

        while (count < 3) {
            ticketCounters[count] = new TicketCounter(count + 1, 0, 0, personQueue);
            count++;
        }
        theater.setTicketCounters(ticketCounters);
        Person person;
        count = 0;
        while (count < 100) {
            person = personList.get(count);
            TicketType type = person.getType();
            int timeTaken = type.getProcessingTime(person);
            while (timeTaken != 0) {
                person.gotoTheater(theater);
                totalMins += eachMinElapsed * type.getProcessingTime(person);
                count++;
                timeTaken--;
            }
        }
        System.out.println("Total time taken by all the people to purchase tickets: " +totalMins);
        System.out.println("Number of People serviced by Counter 1: " + ticketCounters[0].getNumberOfTicketsSold());
        System.out.println("Number of People serviced by Counter 2: " + ticketCounters[1].getNumberOfTicketsSold());
        System.out.println("Number of People serviced by Counter 3: " + ticketCounters[2].getNumberOfTicketsSold());
    }
}
