import java.util.Random;
import java.util.Scanner;

public class GuessNumbers extends Game {
    private int userInput;
    private int randomNumber;

    private int bound;


    public void setBound(int bound) {
        this.bound = bound;
    }


    public int getBound() {
        return bound;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(getBound());
    }

    @Override
    public void generateRandom() {
        this.randomNumber = getRandomNumber();
        System.out.println(this.randomNumber);
    }

    @Override
    public void play() {
        if (getPlayer().tries != 0) {
            getPlayer().setNumbersScore(getPlayer().tries);
        }
        getPlayer().tries = 0;
        this.playGame();
    }

    @Override
    public boolean isCorrectGuess() {
        if (this.userInput == this.randomNumber) {
            System.out.println(this.userInput + " Is a correct guess, YOU WIN");
            System.out.println("You won after " + (getPlayer().tries) + " Tries");
            return true;
        } else if (this.userInput > this.randomNumber) {
            if (this.isHint()) {
                System.out.println(this.userInput + " Is higher");
            }
            this.decreaseNoOfGuesses();
        } else {
            if (this.isHint()) {
                System.out.println(this.userInput + " Is Lower");
            }
            this.decreaseNoOfGuesses();
        }
        if (this.getNoOfGuesses() == 0) {
            System.out.println("You Lose!");
        }
        return false;
    }

    public void levelOne() {
        this.setNoOfGuesses(5);
        this.setHint(true);
        this.setBound(15);
        // TODO : user getInstructions


        // TODO: convert this to a function getRange() in Game class with
        // type, bound, chances parameters
        System.out.println("Enter numbers in range 1 to " + getBound()
                + ". " + this.getNoOfGuesses() + " Chances left");
    }

    @Override
    public void levelTwo() {
        this.setNoOfGuesses(4);
        this.setHint(false);
        this.setBound(25);
        System.out.println("Enter numbers in range 1 to " + getBound()
                + ". " + this.getNoOfGuesses() + " Chances left");
    }

    @Override
    public void levelThree() {
        this.setNoOfGuesses(3);
        this.setHint(false);
        this.setBound(40);
        System.out.println("Enter numbers in range 1 to " + getBound()
                + ". " + this.getNoOfGuesses() + " Chances left");
    }

    @Override
    public void getUserInput() {
        Scanner input = new Scanner(System.in);
        this.userInput = input.nextInt();
    }
}


