import java.util.Scanner;





public class RockPaperScissorsWith2Players {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Rock, Paper, Scissors! Player 1, enter your move (r for Rock, p for Paper, s for Scissors):");
            String player1Move = scanner.nextLine();
            // Validate Player 1's move
            if (!player1Move.equals("r") && !player1Move.equals("p") && !player1Move.equals("s")) {
                System.out.println("Invalid move! Please enter r, p, or s.");
                return;
            }
            System.out.println("Player 2, enter your move (r for Rock, p for Paper, s for Scissors):");
            String player2Move = scanner.nextLine();
            // Validate Player 2's move
            if (!player2Move.equals("r") && !player2Move.equals("p") && !player2Move.equals("s")) {
                System.out.println("Invalid move! Please enter r, p, or s.");
                return;
            }
            System.out.println("Player 1's move: " + player1Move);
            System.out.println("Player 2's move: " + player2Move);
            if (player1Move.equals(player2Move)) {

                System.out.println("It's a tie!");
            } else if ((player1Move.equals("r") && player2Move.equals("s")) ||
                    (player1Move.equals("p") && player2Move.equals("r")) ||
                    (player1Move.equals("s") && player2Move.equals("p"))) {

                System.out.println("Player 1 wins!");
            } else {
                System.out.println("Player 2 wins!");
            }
        }
    }


