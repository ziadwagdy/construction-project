import java.util.Random;
import java.util.Scanner;

/**
 * GuessNumbers Class
 * This is a class named GuessNumbers(), which extends the Game class.
 * It has several fields, methods, and overrides the methods of the parent class.
 */
public class GuessNumbers extends Game {
    /**
     * userInput field stores the user's guess.
     */
    private int userInput;
    /**
     * randomNumber field stores the randomly generated number.
     */
    private int randomNumber;
    /**
     * bound field represents the upper bound for the random number generation.
     */
    private int bound = 1;

    /**
     * setBound()
     * sets the upper bound for the random number generation.
     *
     * @param bound can be a number(10, 25, 40)
     */
    public void setBound(int bound) {
        this.bound = bound;
    }

    /**
     * getBound()
     * returns the upper bound for the random number generation.
     *
     * @return bound
     */
    public int getBound() {
        return bound;
    }

    /**
     * getRandomNumber()
     * generates a random number between 1
     * and the upper bound using the 'Random' class.
     *
     * @return int randomNumber
     */
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(getBound()) + 1;
    }

    /**
     * generateRandom()
     * sets the randomNumber instance variable
     * to a new random number generated by
     * calling the getRandomNumber() method, and prints the value of the
     * randomNumber variable to the console.
     */
    @Override
    public void generateRandom() {
        this.randomNumber = getRandomNumber();
    }

    /**
     * play()
     * It checks if the player has any previous tries,
     * and if so, updates their score.
     * It then resets the tries variable to zero
     * and calls the playGame() method,
     * which is defined in the Game class.
     */
    @Override
    public void play() {
        if (getPlayer().tries != 0) {
            getPlayer().setNumbersScore(getPlayer().tries);
        }
        getPlayer().tries = 0;
    }

    /**
     * isCorrectGuess()
     * It checks if the user's input matches the randomNumber variable, and if so,
     * prints a message to the console indicating that the user won and returns true.
     * If the user's input is higher than the randomNumber, it decreases the number
     * of guesses remaining and prints a message indicating that the input is higher.
     * If the input is lower, it does the same but prints a message indicating that the input is low
     * @return boolean (true, false)
     */
    @Override
    public boolean isCorrectGuess() {
        if (this.userInput == this.randomNumber) {
            System.out.println(this.userInput + " Is a correct guess, YOU WIN ✅");
            System.out.println("You won after " + (getPlayer().tries) + " Tries 🥳");
            Game.getPlayer().setLoserNumber(false);
            return true;
        } else if (this.userInput > this.randomNumber) {
            if (this.isHint()) {
                System.out.println("wrong! " + this.userInput + " Is higher ❌");
            }
            this.decreaseNoOfGuesses();
        } else {
            if (this.isHint()) {
                System.out.println("wrong! " + this.userInput + " Is Lower ❌");
            }
            this.decreaseNoOfGuesses();
        }
        if (this.getNoOfGuesses() == 0) {
            Game.getPlayer().setLoserNumber(true);
            System.out.println("You Lose! 🥲");
        }
        return false;
    }

    /**
     * levelOne()
     * sets the game parameters for level, including the number of guesses,
     * hint availability, and the upper bound of the range.
     * It then prints game instructions to the console.
     */
    public void levelOne() {
        this.setNoOfGuesses(5);
        this.setHint(true);
        this.setBound(15);
        this.getRange(String.valueOf(GAME_TYPE.Numbers), getBound(), getNoOfGuesses());
        System.out.println(
                this.getInstructions(String.valueOf(GAME_TYPE.Numbers),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Easy))
        );
    }

    /**
     * levelTwo()
     * sets the game parameters for level, including the number of guesses,
     * hint availability, and the upper bound of the range.
     * It then prints game instructions to the console.
     */
    @Override
    public void levelTwo() {
        this.setNoOfGuesses(4);
        this.setHint(false);
        this.setBound(25);
        this.getRange(String.valueOf(GAME_TYPE.Numbers), getBound(), getNoOfGuesses());
        System.out.println(
                this.getInstructions(String.valueOf(GAME_TYPE.Numbers),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Medium))
        );
    }

    /**
     * levelThree()
     * sets the game parameters for level, including the number of guesses,
     * hint availability, and the upper bound of the range.
     * It then prints game instructions to the console.
     */
    @Override
    public void levelThree() {
        this.setNoOfGuesses(3);
        this.setHint(false);
        this.setBound(40);
        this.getRange(String.valueOf(GAME_TYPE.Numbers), getBound(), getNoOfGuesses());
        System.out.println(
                this.getInstructions(String.valueOf(GAME_TYPE.Numbers),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Hard))
        );
    }

    /**
     * getUserInput()
     * overrides the getUserInput() method in the Game class,
     * prompts the user to input a number,
     * and sets the userInput instance variable to the user's input.
     */
    @Override
    public boolean getUserInput() {
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            this.userInput = input.nextInt();
            return true;
        } else {
            System.out.println("Invalid Input!");
            return false;
        }
    }

    /**
     * printHighScoreStatus()
     * A function to get report of highScore for each model game,
     * and prints a message.
     */
    public void printHighScoreStatus() {
        if (Game.getPlayer().getNumbersHighScore() == 0) {
            System.out.println("Guessing Numbers is not played yet");
        } else if (Game.getPlayer().isLoserNumber() &&
                Game.getPlayer().getNumbersHighScore() == 0) {
            System.out.println("You played but you lost");
        } else if (
                Game.getPlayer().isLoserNumber() &&
                        Game.getPlayer().getNumbersHighScore() != 0
        ) {
            System.out.println("Your High Score in Numbers "
                    + Game.getPlayer().getNumbersHighScore());
        } else {
            System.out.println("Your High Score in Numbers "
                    + Game.getPlayer().getNumbersHighScore());
        }


    }
}


