import java.util.Random;
import java.util.Scanner;

/**
 * GuessAlphabets{}
 * This is a class named GuessAlphabets(), which extends the Game class.
 * It has several fields, methods, and overrides the methods of the parent class.
 */
public class GuessAlphabets extends Game {
    /**
     * This field stores the user's guess.
     */
    private String userInput;

    /**
     * randomAlphabet field stores the randomly generated number.
     */
    private char randomAlphabet;

    /**
     * bound field represents the upper bound for the random number generation.
     * */
    private int bound = 1;

    /**
     * setBound()
     * sets the upper bound for the random alphabet generation.
     *
     * @param bound can be a character(j, q, z)
     */
    public void setBound(int bound) {
        this.bound = bound;
    }

    /**
     * getBound()
     * returns the upper bound for the random alphabet generation.
     *
     * @return bound
     */
    public int getBound() {
        return bound;
    }

    /**
     * getRandomChar()
     * generates a random character between a and the upper bound using the 'Random' class.
     *
     * @return int randomAlphabet (which will be referred to a char)
     */
    public int getRandomChar() {
        Random rand = new Random();
        randomAlphabet = (char) (rand.nextInt(getBound()) + 'a');
        return randomAlphabet;
    }

    /**
     * generateRandom()
     * sets the randomAlphabet instance variable to a new random char generated by
     * calling the getRandomChar() method, and prints the value of the
     * randomAlphabet variable to the console.
     */
    @Override
    public void generateRandom() {
        this.randomAlphabet = (char) getRandomChar();
    }

    /**
     * play()
     * It checks if the player has any previous tries, and if so, updates their score.
     * It then resets the tries variable to zero and calls the playGame() method,
     * which is defined in the Game class.
     */
    @Override
    public void play() {
        if (getPlayer().tries != 0) {
            getPlayer().setAlphabetsScore(getPlayer().tries);
        }
        getPlayer().tries = 0;
    }

    /**
     * isCorrectGuess()
     * It checks if the user's input matches the randomAlphabet variable, and if so,
     * prints a message to the console indicating that the user won and returns true.
     * If the user's input is higher than the randomAlphabet, it decreases the number
     * of guesses remaining and prints a message indicating that the input is higher.
     * If the input is lower, it does the same but prints a message indicating that the input is lower
     *
     * @return boolean (true, false)
     */
    @Override
    public boolean isCorrectGuess() {
        // length of the user input is one character and the character is less than the random alphabet
        if (this.userInput.length() == 1 && this.userInput.charAt(0) == this.randomAlphabet) {
            System.out.println(this.userInput + " Is a correct guess, YOU WIN ✅");
            System.out.println("You won after " + (getPlayer().tries) + " Tries 🥳");
            Game.getPlayer().setLoserAlphabet(false);
            return true;
        } else if (this.userInput.length() == 1 && this.userInput.charAt(0) < this.randomAlphabet) {
            if (this.isHint()) {
                System.out.println("wrong! " + this.userInput + " Is Lower ❌");
            }
            this.decreaseNoOfGuesses();
        } else {
            if (this.isHint()) {
                System.out.println("wrong! " + this.userInput + " Is higher ❌");
            }
            this.decreaseNoOfGuesses();
        }

        if (this.getNoOfGuesses() == 0) {
            Game.getPlayer().setLoserAlphabet(true);
            System.out.println("You Lose! 🥲");
            return false;
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
        this.setBound(10);
        this.getRangeAlphabet(
                String.valueOf(GAME_TYPE.Alphabets),
                getBound(),
                getNoOfGuesses()
        );

        System.out.println(
                this.getInstructions(
                        String.valueOf(GAME_TYPE.Alphabets),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Easy)
                )
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
        this.setBound(17);
        this.getRangeAlphabet(
                String.valueOf(GAME_TYPE.Alphabets),
                getBound(),
                getNoOfGuesses()
        );

        System.out.println(
                this.getInstructions(
                        String.valueOf(GAME_TYPE.Alphabets),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Medium)
                )
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
        this.setBound(25);
        this.getRangeAlphabet(String.valueOf(GAME_TYPE.Alphabets),
                getBound(),
                getNoOfGuesses()
        );

        System.out.println(
                this.getInstructions(
                        String.valueOf(GAME_TYPE.Alphabets),
                        getNoOfGuesses(),
                        String.valueOf(LEVEL.Hard)
                )
        );
    }

    /**
     * getUserInput()
     * overrides the getUserInput() method in the Game class, prompts the user to
     * input a character, and sets the userInput instance variable to the user's input.
     */
    @Override
    public boolean getUserInput() {
        Scanner input = new Scanner(System.in);

        if (input.hasNextInt()) {
            System.out.println("Invalid Input!");
            return false;
        } else {
            this.userInput = input.next().toLowerCase();
            return true;
        }
    }

    /**
     * printHighScoreStatus()
     * A function to get report of highScore for each model game,
     * and prints a message.
     */
    public void printHighScoreStatus(){
        if (Game.getPlayer().getAlphabetsHighScore() == 0) {
            System.out.println("Guessing Alphabets is not played yet");
        } else if (
                Game.getPlayer().isLoserAlphabet() &&
                        Game.getPlayer().getAlphabetsHighScore() != 0
        ) {
            System.out.println("You played but you lost");
        } else {
            System.out.println("Your High Score in Alphabets "
                    + Game.getPlayer().getAlphabetsHighScore());
        }
    }
}


