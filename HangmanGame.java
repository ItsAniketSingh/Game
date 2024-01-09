import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = {"programming", "java", "hangman", "computer", "developer"};
        String selectedWord = words[(int) (Math.random() * words.length)];
        char[] guessedWord = new char[selectedWord.length()];
        boolean[] guessedLetters = new boolean[26];
        int attempts = 6; 

       
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        while (attempts > 0) {
            // Display the current state of the word
            System.out.print("Word: ");
            for (char letter : guessedWord) {
                System.out.print(letter + " ");
            }

            System.out.println("\nAttempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (guessedLetters[guess - 'a']) {
                System.out.println("You've already guessed that letter. Try again.");
                continue;
            }

            guessedLetters[guess - 'a'] = true;

            if (selectedWord.contains(String.valueOf(guess))) {
                for (int i = 0; i < selectedWord.length(); i++) {
                    if (selectedWord.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                System.out.println("Incorrect guess!");
                attempts--;
            }

            // Check if the player has guessed the entire word
            if (String.valueOf(guessedWord).equals(selectedWord)) {
                System.out.println("Congratulations! You've guessed the word: " + selectedWord);
                break;
            }
        }

        if (attempts == 0) {
            System.out.println("Sorry, you're out of attempts. The word was: " + selectedWord);
        }

        scanner.close();
    }
}
