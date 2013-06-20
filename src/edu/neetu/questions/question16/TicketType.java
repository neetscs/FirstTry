package edu.neetu.questions.question16;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/11/13
 * Time: 3:03 PM
 */
public enum TicketType {
    SINGLE, GROUP, INTERNET;
    //Get the time for processing each type of ticket
    public int getProcessingTime(){

        int processingTime = 0;

        if (equals(SINGLE)){
          processingTime = 2;
        }
        else if (equals(GROUP)){
          processingTime = 5;
        }
        else if (equals(INTERNET)){
          processingTime = 1;
        }
        return processingTime;
    }
}
