package edu.neetu.questions;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/11/13
 * Time: 3:03 PM
 */
public enum TicketType {
    SINGLE, GROUP, INTERNET;
    //Get the time for processing each type of ticket for a person
    int getProcessingTime(Person person){
        int processingTime = 0;
        if (person.getType().equals(TicketType.SINGLE)){
          processingTime = 2;
        }
        else if (person.getType().equals(TicketType.GROUP)){
          processingTime = 5;
        }
        else if (person.getType().equals(TicketType.INTERNET)){
          processingTime = 1;
        }
        return processingTime;
    }
}
