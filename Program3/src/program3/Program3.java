package program3;

import java.util.Scanner;
import java.util.Random;

public class Program3 {

    static int computerMove = 0;
    static Scanner in = new Scanner(System.in);
    static Random ran;
    static final int ROCK = 0;
    static final int PAPER = 1;
    static final int SCISSORS = 2;
    static int c;
    static int wins;
    static int loses;
    static int ties;
    static int userMove;
    static String result;

    public static void main(String[] args) {
        ran = new Random();
        int c = 0;
        int wins = 0;
        int loses = 0;
        int ties = 0;
        game();

    }

    public static void game() {
        computerMove = ran.nextInt(3);
        System.out.println("(0) Rock\n(1) Paper\n(2) Scissors\n\nChoose a move (0-2): ");
        if (in.hasNextInt()) {
            userMove = in.nextInt();

            System.out.println("computer chose:" + computerMove);
            if (userMove >= 0 && userMove <= 2) {
                if (computerMove == 0 && userMove == 1) {
                    System.out.println("You won\n");
                    wins++;

                } else if (computerMove == 0 && userMove == 2) {
                    System.out.println("Computer won\n");
                    loses++;

                } else if (computerMove == 1 && userMove == 2) {
                    System.out.println("You won\n");
                    wins++;

                } else if (computerMove == 1 && userMove == 0) {
                    System.out.println("Computer won\n");
                    loses++;
                    
                } else if (computerMove == 2 && userMove == 1) {
                    System.out.println("Computer won\n");
                    loses++;

                } else if (computerMove == 2 && userMove == 0) {
                    System.out.println("You won\n");
                    wins++;

                } else if (computerMove == userMove) {
                    System.out.println("It is a tie\n");
                    ties++;

                }
                c++;
                again();

            } else {
                String bad= in.nextLine();
                System.out.println("Wrong Input tio\n");
                again();
            }

        } else {
            String bad= in.nextLine();
            System.out.println("Wrong input\n");
            again();

        }
    }

    public static void again() {
        if (c == 5 || wins==3 || loses==3) {
            System.out.println("You are done");
            showresults();
            System.exit(1);
        } else {

            System.out.println("Do you want to play again?\n(0) play again\n(1) quit\n\nChoose a move (0-1): ");
            if (in.hasNextInt()) {
                int answer = in.nextInt();
                if (answer > 1) {
                    System.out.println("Wrong input tio");
                    again();
                } else {
                    if (answer == 0) {
                        game();
                    }
                    if (answer == 1) {
                        System.out.println("Thanks for playing");
                        System.exit(1);
                    }
                }
            } else {
                String bad= in.nextLine();
                System.out.println("Wrong input tio");
                
                again();
            }
        }
    }
    public static void showresults(){
        double ratio=((wins*1.0)/c)*100;
        System.out.println("The results are: Wins: "+wins+" Loses: "+loses+ " Ties: "+ties+ " Wining ratio: "+ratio);
        c=0;
        wins=0;
        loses=0;
        ties=0;
        again();
    }
    

}


