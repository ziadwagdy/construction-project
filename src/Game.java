import java.util.Scanner;

public abstract class Game {

    // TODO : how will we calculate the high score (NOUR)
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

    public void playGame(){
        int choice;
        System.out.print("Enter level: 1, 2, 3: ");
        choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1 -> levelOne();
            case 2 -> levelTwo();
            case 3 -> levelThree();
        }
        System.out.println("Enter your guess: ");
        while (noOfGuesses != 0) {
            System.out.println("Chance #" + noOfGuesses);
            getUserInput();
            if (this.isCorrectGuess()) {
                break;
            }
        }
        if (noOfGuesses == 0) {
            System.out.println("You Lose!");
        }
    }
}
