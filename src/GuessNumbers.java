import java.util.Random;
import java.util.Scanner;

public class GuessNumbers extends Game {
    int highScore = 0;
    int userInput;
    int randomNumber;

    public GuessNumbers() {
        Random random = new Random();
        this.randomNumber = random.nextInt(15);
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(15);
    }

    @Override
    public boolean isCorrectGuess() {
        if (this.userInput == this.randomNumber) {
            System.out.println(this.userInput + " Is a correct guess, YOU WIN");
            this.highScore++;
            return true;
        } else if (this.userInput > this.randomNumber) {
            if (isHint) {
                System.out.println(this.userInput + " Is higher");
            }
            this.noOfGuesses--;
        } else {
            if (isHint) {
                System.out.println(this.userInput + " Is Lower");
            }
            this.noOfGuesses--;
        }
        return false;
    }

    @Override
    public void setup() {
        this.randomNumber = getRandomNumber();
        int choice;
        System.out.print("Enter level: 1, 2, 3: ");
        choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1 -> levelOne();
            case 2 -> levelTwo();
            case 3 -> levelThree();
        }

        System.out.println(this.randomNumber);
        System.out.println("Enter your guess: ");
        while (noOfGuesses != 0) {
            System.out.println("Chance #" + noOfGuesses);
            getUserInput();
            if (isCorrectGuess()) {
                break;
            }
        }

        if (noOfGuesses == 0) {
            System.out.println("You Lose!");
        }
    }

    public void levelOne() {
        this.setNoOfGuesses(5);
        this.setHint(true);
    }

    @Override
    public void levelTwo() {
        this.setNoOfGuesses(4);
        this.setHint(false);
    }

    @Override
    public void levelThree() {
        this.setNoOfGuesses(3);
        this.setHint(false);
    }

    @Override
    public void getUserInput() {
        Scanner input = new Scanner(System.in);
        this.userInput = input.nextInt();
    }

}
