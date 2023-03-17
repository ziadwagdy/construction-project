import java.util.Scanner;

public abstract class Game {

    int noOfGuesses;

    boolean isHint;

    public boolean isHint() {
        return isHint;
    }

    public void setHint(boolean hint) {
        isHint = hint;
    }

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    public abstract boolean isCorrectGuess();

    public abstract void setup();

    public abstract void getUserInput();

    public abstract void levelOne();

    public abstract void levelTwo();

    public abstract void levelThree();

    public abstract int getHighScore();

    public abstract int increaseTries();

    public void playGame() {

        this.noOfGuesses = 0;
        int choice;
        System.out.print("\nStart Menu"
                + "\n-----------"
                + "\nSelect a difficulty level"
                + "\n1. Easy\n2. Medium\n3. Hard\n4. Return to main menu\n===> ");
        choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1 -> levelOne();
            case 2 -> levelTwo();
            case 3 -> levelThree();
            case 4 -> {
                return;
            }
            default -> {
                // invalid option choose level again
                System.out.println("Invalid option");
                this.setup();
            }
        }
        System.out.println("Enter your guess: ");
        while (noOfGuesses != 0) {
            System.out.println("Chance #" + noOfGuesses);
            getUserInput();
            increaseTries();
            if (this.isCorrectGuess()) {
                this.setup();
            }
        }
    }

}
