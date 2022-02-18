import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Tic-Tac-Toe Square
        String[][] square = {
                {" ", "|", " ", "|", " "},
                {" ", "|", " ", "|", " "},
                {" ", "|", " ", "|", " "}};

        //region Scanner
        Scanner sc = new Scanner(System.in);

        //Automated Message
        System.out.println("""
                SCHEDULE APP:\s            
                Through interacting with this application, users can earn moves to win a
                tic-tac-toe game against a robot through inputting and completing daily tasks in 
                their to-do lists.""");

        //Creating an ArrayList that user can modify for their schedule
        ArrayList<String> schedule = new ArrayList<String>(10);

        //Schedule object
        Schedule user1 = new Schedule(schedule);

        //Variables
        String x = "X";
        String o = "O";
        //Tracking amount of moves user does
        int moves = 0;

        //Creating user object for tic-tac-toe
        Actions user = new Actions(square, moves);

        //Make empty square
        user.makeSquare();

        //while loop to limit amount of available moves
        while (moves <= 6) {

            //Tells user how many moves he or she has left
            System.out.println("Moves left: " + (5 - moves));

            //variables that indicate the coordinates for the robot's move
            int rx = (int) (Math.random() * 2);
            int ry = (int) (Math.random() * 4);

            //Allowing the user to add tasks
            System.out.println(user1.addTask(sc));

            //Telling the user to complete tasks
            System.out.println("Please come back once you have completed your tasks.");

            //for loop
            for (int i = 0; i < schedule.size(); i++) {

                //Asks if user completed certain task in order to delete it from list
                System.out.println("Have you completed " + schedule.get(i) + "?");
                String answer = sc.next().toLowerCase(Locale.ROOT);
                if (answer.equals("yes") || answer.equals("y")) {
                    schedule.remove(schedule.get(i));
                    i--;
                }
            }

            //Outputs current schedule list
            System.out.println(schedule);

            //if statement that occurs when there is no tasks left to complete
            if (schedule.size() == 0) {

                //Message for coordinates
                System.out.println("""
                        Congratulations for completing 10 tasks in one day!\s
                        Choose coordinates to add your move in the square:\s
                        For row-coordinates: (0-2)\s
                        For column-coordinates: (0-4)\s
                        *Inputting coordinates 1 or 3 will place the mark one additional column.""");

                //User can input coordinates
                int row1 = sc.nextInt();
                int column1 = sc.nextInt();

                //checks if row or column are too big, asks user to input new coordinates if so.
                if (row1 > 2) {
                    System.out.println("Error, coordinate too large. Input another: ");
                    row1 = sc.nextInt();
                    if (column1 > 4) {
                        System.out.println("Error, coordinate too large. Input another: ");
                        column1 = sc.nextInt();
                    }
                    }
                else if (column1 > 4) {
                        System.out.println("Error, coordinate too large. Input another: ");
                        column1 = sc.nextInt();
                    }

                    //Prints robot's coordinates
                    System.out.println("Robot's coordinates: " + rx + " " + ry);

                    //call methods to update square
                    user.putX(x, row1, column1);
                    user.putO(o, rx, ry);
                    user.makeSquare();

                    //Increments tracker by one per loop
                    moves++;
                }

                //if statement checks if user won
                if (user.checkWinner(moves))
                {
                    break;
                }
            }
        }
    }