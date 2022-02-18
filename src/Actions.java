import java.util.Scanner;

public class Actions {

    //Instance variables
    private String[][] square;
    private int moves;

    //public constructor
    public Actions(String [][] square, int moves)
    {

        //Making object's variable square or moves equal to the user's square or moves
        this.square = square;
        this.moves = moves;
    }

    //makeSquare method that creates the square
    public void makeSquare()
    {

        //nested for loop that creates square one element at a time
        for (int i = 0; i < this.square.length; i++) {
            for (int j = 0; j < this.square[i].length; j++) {
                System.out.print(this.square[i][j]);
            }
            System.out.println();
        }
    }

    //checkSlot method
    public boolean checkSlot(int row1, int column1)
    {

        //if statement that increments column1 value if original value is on line
        if (this.square[row1][column1].equals("|")) {
            column1++;
        }

        //if statement that checks if slot is empty and returns true if so
        if (this.square[row1][column1].equals(" ")) {
            return true;
        }
        return false;
    }

    //putX method that puts the user's move on the square
    public void putX(String x, int row1, int column1)
    {

        //region Scanner
        Scanner sc = new Scanner(System.in);

        //if statement checks if value is true
        if (checkSlot(row1, column1)){

            if (this.square[row1][column1].equals("|")) {
                column1++;
                this.square[row1][column1] = x;
            }
            else{
                //sets slot to x
                this.square[row1][column1] = x;
            }
        }

        //checks if value is false
        else {
            System.out.println("Slot is already full. Please input new coordinates.");

            //asks user to input new coordinates
            row1 = sc.nextInt();
            column1 = sc.nextInt();
            putX(x, row1, column1);
        }
    }

    //putO method that accounts for the robot's move
    public void putO(String o, int row1, int column1)
    {
        
        //if statement checks if value is true
        if (checkSlot(row1, column1)){

            if (this.square[row1][column1].equals("|")) {
                column1++;
                this.square[row1][column1] = o;
            }
            else{
                //sets slot to x
                this.square[row1][column1] = o;
            }
        }

        //checks if value is false
        else {

            //while loop checks for empty spot
            while (!checkSlot(row1, column1)) {
                //asks user to input new coordinates
                row1 = (int) (Math.random() * 2);
                column1 = (int) (Math.random() * 4);
            }

            //recalls method
                putO(o, row1, column1);
        }
    }

    //method that verifies user's win
    public boolean checkWinner(int moves) {

        //creating user object
        Actions user = new Actions(this.square, moves);

        //nested for loop: row winner
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {

                //if statement that checks for a row line
                if (square[i][0].equals("X") && square[i][2].equals("X") &&
                        square[i][4].equals("X")) {

                    //prints win message
                    System.out.println("Congratulations, you have won the game.");
                    return true;
                }
            }
        }

        //if statements that check if user wins by column line, or diagonals
        if (square[0][0].equals("X") && square[1][0].equals("X") &&
                square[2][0].equals("X")) {
            System.out.println("Congratulations, you have won the game.");
            return true;
        }
        else if (square[0][1].equals("X") && square[1][1].equals("X") && square[2][1].equals("X")) {
            System.out.println("Congratulations, you have won the game.");
            return true;
        }
        else if (square[0][2].equals("X") && square[1][2].equals("X") && square[2][2].equals("X")) {
            System.out.println("Congratulations, you have won the game.");
            return true;
        }
        else if (square[0][0].equals("X") && square[1][2].equals("X") &&
                square[2][4].equals("X")) {
            System.out.println("Congratulations, you have won the game.");
            return true;
        }
        else if (square[2][0].equals("X") && square[1][2].equals("X") &&
                square[0][4].equals("X")) {
            System.out.println("Congratulations, you have won the game.");
            return true;
        }

        //else: loser
        else {

            //nested for loop: row loser
            for (int i = 0; i < square.length; i++) {
                for (int j = 0; j < square[i].length; j++) {

                    //if statement that checks robot's row line
                    if (square[i][0].equals("O") && square[i][2].equals("O") &&
                            square[i][4].equals("O")) {

                        //prints loser message
                        System.out.println("Unfortunately, you have lost the game");
                        return true;
                    }
                }
            }

            //if statements that check if user loses by column line, or diagonals
            if (square[0][0].equals("O") && square[1][0].equals("O") && square[2][0].equals("O")) {
                System.out.println("Unfortunately, you have lost the game");
                return true;
            }
            else if (square[0][1].equals("O") && square[1][1].equals("O") && square[2][1].equals("O")) {
                System.out.println("Unfortunately, you have lost the game");
                return true;
            }
            else if (square[0][2].equals("O") && square[1][2].equals("O") && square[2][2].equals("O")) {
                System.out.println("Unfortunately, you have lost the game");
                return true;
            }
            else if (square[0][0].equals("O") && square[1][2].equals("O") &&
                    square[2][4].equals("O")) {
                System.out.println("Unfortunately, you have lost the game");
                return true;
            }
            else if (square[2][0].equals("O") && square[1][2].equals("O") &&
                    square[0][4].equals("O")) {
                System.out.println("Unfortunately, you have lost the game");
                return true;
            }
            else if (moves == 5) {

                //tie game because no player won
                user.tie(moves);
                return true;
            }
        }
        return false;
    }

    //tie method that makes a new square
    public void tie(int moves){
        System.out.println("Congratulations for completing the game. You have tied with the robot.");

        //calls makeSquare method to make a new square
        makeSquare();

        //moves equals zero again
        moves = 0;
    }
}