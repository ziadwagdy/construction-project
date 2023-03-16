import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println(
                    """
                            Welcome, play the game!
                            Enter 1 for Alphabets
                            Enter 2 for numbers
                            Enter 3 for getting the high score
                            Enter 4 for Credits
                            Enter 5 to Exit"""
            );
            int choice = input.nextInt();
            if (choice == 5){
                break;
            }

            switch (choice) {
                case 1 -> {
                    GuessAlphabets alphabets = new GuessAlphabets();
                    alphabets.setup();
                }
                case 2 -> {
                    GuessNumbers numbers = new GuessNumbers();
                    numbers.setup();
                }
            }
        }
    }
}