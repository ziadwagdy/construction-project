import java.util.Random;
import java.util.Scanner;

public class GuessAlphabets extends Game {
    private String userInput;
    private char randomAlphabet;
    private int bound;


    public void setBound(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }

    public int getRandomChar() {
        Random rand = new Random();
        randomAlphabet = (char) (rand.nextInt(getBound()) + 'a');
        return randomAlphabet;
    }

    @Override
    public void generateRandom() {
        this.randomAlphabet = (char) getRandomChar();
        System.out.println(this.randomAlphabet);
    }

    @Override
    public void play() {
        if (getPlayer().tries != 0) {
            getPlayer().setAlphabetsScore(getPlayer().tries);
        }
        getPlayer().tries = 0;
        this.playGame();
    }

    public void levelOne() {
        this.setNoOfGuesses(5);
        this.setHint(true);
        this.setBound(10);
        this.getRange(String.valueOf(GAME_TYPE.Alphabets), getBound(), getNoOfGuesses());

        System.out.println(
                this.getInstructions(String.valueOf(GAME_TYPE.Alphabets),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Easy))
        );
    }

    @Override
    public void levelTwo() {
        this.setNoOfGuesses(4);
        this.setHint(false);
        this.setBound(17);
        this.getRange(String.valueOf(GAME_TYPE.Alphabets), getBound(), getNoOfGuesses());

        System.out.println(
                this.getInstructions(String.valueOf(GAME_TYPE.Alphabets),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Medium))
        );
    }

    @Override
    public void levelThree() {
        this.setNoOfGuesses(3);
        this.setHint(false);
        this.setBound(26);
        this.getRange(String.valueOf(GAME_TYPE.Alphabets), getBound(), getNoOfGuesses());

        System.out.println(
                this.getInstructions(String.valueOf(GAME_TYPE.Alphabets),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Hard))
        );
    }

    @Override
    public void getUserInput() {
        Scanner input = new Scanner(System.in);
        this.userInput = input.next();
    }


    //    @Override
    public boolean isCorrectGuess() {
        // length of the user input is one character and the character is less than the random alphabet
        if (this.userInput.length() == 1 && this.userInput.charAt(0) == this.randomAlphabet) {
            System.out.println(this.userInput + " is a correct guess! YOU WIN");
            System.out.println("You won after " + (getPlayer().tries) + " Tries");
            return true;
        } else if (this.userInput.length() == 1 && this.userInput.charAt(0) < this.randomAlphabet) {
            if (this.isHint()) {
                System.out.println(this.userInput + " is too low!");
            }
            this.decreaseNoOfGuesses();
        } else {
            if (this.isHint()) {
                System.out.println(this.userInput + " Is too high!");
            }
            this.decreaseNoOfGuesses();
        }

        if (this.getNoOfGuesses() == 0) {
            System.out.println("You Lose!");
        }
        return false;
    }

}


