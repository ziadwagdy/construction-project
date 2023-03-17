import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuessAlphabets alphabets = new GuessAlphabets();
        while (true) {
            System.out.println(
                    """
                            Welcome, play the game!
                            Enter 1 for Alphabets
                            Enter 2 for numbers
                            Enter 3 for getting the high score
                            Enter 4 for Credits
                            Enter 5 to Exit"""
            );
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 5) {
                break;
            } else {
                switch (choice) {
                    case 1 -> {
                        alphabets.setup();
                    }
                    case 2 -> {
//                      numbers.setup();
                        newGuessNumbers guessNumbers = new newGuessNumbers();
                        guessNumbers.setup();
                    }
                    case 3 -> {
                        if (alphabets.getHighScore() == 0) {
                            System.out.println("Play first please!");
                        } else {
                            System.out.println("Your High Score is " + alphabets.getHighScore());
                        }
                    }
                }
            }
        }
    }
}
