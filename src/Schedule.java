import java.util.ArrayList;
import java.util.Scanner;

public class Schedule {

    //instance variables
    private ArrayList<String> schedule;

    //public constructor
    public Schedule(ArrayList<String> schedule)
    {

        //makes object's schedule equal to schedule in parameter
        this.schedule = schedule;
    }

    //addTask method
    public ArrayList<String> addTask(Scanner sc)
    {

        //while loop that allows user to add a task in their schedule
        while (this.schedule.size() < 10) {
            System.out.println("Please add a task:");
            String input = sc.nextLine();
            this.schedule.add(input);
        }

        //returns updated schedule
        return this.schedule;
    }
}