import java.util.Random;
import java.util.Scanner;

public class GuessAlphabets extends Game {
    int highScore = 0;
    String userInput;
    char randomAlphabet;
    public int getRandomChar() {
        Random rand = new Random();
        randomAlphabet = (char) (rand.nextInt(26) + 'a');
        return randomAlphabet;
    }

    @Override
    public boolean isCorrectGuess() {
        // length of the user input is one character and the character is less than the random alphabet
        if (this.userInput.length() == 1 && this.userInput.charAt(0) == this.randomAlphabet) {
            System.out.println(this.userInput + " is a correct guess! YOU WIN");
            this.highScore++;
            return true;
        } else if (this.userInput.length() == 1 && this.userInput.charAt(0) < this.randomAlphabet) {
            if (isHint) {
                System.out.println(this.userInput + " is too low!");
            }
            this.noOfGuesses--;}
        else{
            if (isHint) {
                System.out.println(this.userInput + " Is too high!");
            }
            this.noOfGuesses--;
        }
        return false;
    }

    @Override
    public void setup() {
        this.randomAlphabet = (char) getRandomChar();
        System.out.println(this.randomAlphabet);
        this.playGame();
    }

    @Override
    public void getUserInput() {
        Scanner input = new Scanner(System.in);
        this.userInput = input.next();
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

}
