import java.util.Random;
import java.util.Scanner;


public class RockPaperScissorsWithComputer {



        public static void main(String[] args) {
            String[] rps = {"r", "p", "s"};

            Random random = new Random();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to Rock, Paper, Scissors! Enter your move (r for Rock, p for Paper, s for Scissors):");
            String userMove = scanner.nextLine();

            // Validate user's move
            if (!userMove.equals("r") && !userMove.equals("p") && !userMove.equals("s")) {
                System.out.println("Invalid move! Please enter r, p, or s.");
                return;
            }

            String computerMove = rps[random.nextInt(rps.length)];


            System.out.println("Computer's move: " + computerMove);

            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((userMove.equals("r") && computerMove.equals("s")) ||
                    (userMove.equals("p") && computerMove.equals("r")) ||
                    (userMove.equals("s") && computerMove.equals("p"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }
    }



