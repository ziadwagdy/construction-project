import java.util.Scanner;

public abstract class Game {
    /**
     *  creates a Player object named player that is static and final.
     */
    private static final Player player = new Player();
    /**
     * noOfGuesses field is an int field that tracks the number of guesses the player has left.
     */
    private int noOfGuesses;
    /**
     * isHint field is a boolean field that indicates whether the level has a hint.
     */
    private boolean isHint;

    /**
     * The 'GAME_TYPE' enum represents two possible values: 'Numbers' and 'Alphabets'.
     * This enum is used to indicate which type of guessing game the user wants to play.
     */
    enum GAME_TYPE {
        Numbers,
        Alphabets,
    }

    /**
     * The LEVEL enum represents the levels of each type in the game.
     * This enum is used to indicate the difficulty level of the game: 'Easy', 'Medium', and 'Hard'.
     */
    enum LEVEL {
        Easy,
        Medium,
        Hard,
    }

    /**
     * getPlayer()
     * is a static method that returns the player object.
     *
     * @return player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * rangeMessage field is a String that holds a message
     * about the range of valid input values.
     */
    private String rangeMessage;

    /**
     * isHint()
     * method that get the isHint field.
     *
     * @return isHint
     */
    public boolean isHint() {
        return isHint;
    }

    /**
     * setHint()
     * method that set the isHint field.
     *
     * @param hint can be a boolean(true, false)
     */
    public void setHint(boolean hint) {
        isHint = hint;
    }

    /**
     * getNoOfGuesses()
     * method that set the noOfGuesses field. can be a number(5, 4, 3)
     *
     * @return noOfGuesses
     */
    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    /**
     * setNoOfGuesses()
     * methods that set the noOfGuesses field.
     *
     * @param noOfGuesses can be a number(5, 4, 3)
     */
    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    /**
     * decreaseNoOfGuesses()
     * is a method that decrements the noOfGuesses field by 1.
     */
    public void decreaseNoOfGuesses() {
        this.noOfGuesses--;
    }

    /**
     * isCorrectGuess()
     * is an abstract method that checks whether the player's guess is correct.
     */
    public abstract boolean isCorrectGuess();

    public abstract void play();

    public abstract boolean getUserInput();

    public abstract void levelOne();

    public abstract void levelTwo();

    public abstract void levelThree();

    public void increaseTries() {
        player.tries++;
    }

    public abstract void generateRandom();

    /**
     * handleChoice()
     * A method that runs the game. It displays a menu to the player,
     * reads the player's choice, and then calls the appropriate method based on the choice.
     */
    public void handleChoice() {
        while (true) {
            this.noOfGuesses = 0;
            System.out.print("""
                    Start Menu :
                    -----------
                    Select a difficulty level
                    1. Easy
                    2. Medium
                    3. Hard
                    4. Return to main menu
                    ===>\s""");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1 -> {
                    levelOne();
                    generateRandom();
                    playGame();
                }
                case 2 -> {
                    levelTwo();
                    generateRandom();
                    playGame();
                }
                case 3 -> {
                    levelThree();
                    generateRandom();
                    playGame();
                }
                case 4 -> {
                    return;
                }
                default -> {
                    // invalid option choose level again
                    System.out.println("Invalid option");
                }
            }
        }
    }

    /**
     * playGame()
     * A method that checks whether the chances are used all or not.
     * If the chances are not done, the player is prompted to guess again
     * until the 'noOfGuesses' field reaches 0.
     */
    public void playGame() {
        while (true) {
            if (this.getNoOfGuesses() != 0) {
                System.out.println("Chance #" + this.getNoOfGuesses());
                System.out.print("Enter your guess: ");
                if (getUserInput()) {
                    increaseTries();
                    if (this.isCorrectGuess()) {
                        this.play();
                        // in case user won, and there is still chances
                        break; // return to choose difficulty level
                    }
                }
            } else if (this.getNoOfGuesses() == 0) {
                this.play();
                // User lost, and number of chances are 0
                break; // return to choose difficulty level
            }
        }
    }

    /**
     * setRangeMessage()
     * methods that set the rangeMessage field.
     *
     * @param range can be a number(15, 25, 40)
     */
    private void setRangeMessage(String range) {
        this.rangeMessage = range;
    }

    /**
     * getRangeMessage()
     * methods that get the rangeMessage field.
     *
     * @return rangeMessage
     */
    private String getRangeMessage() {
        return this.rangeMessage;
    }

    /**
     * getRange()
     * creates a message about the range of valid input
     * values and sets it to the rangeMessage field
     *
     * @param type    can be (Alphabets or Numbers)
     * @param bound   can be an integer from (15, 25, 40)
     * @param chances can be (5, 4, 3)
     **/
    public void getRange(String type, int bound, int chances) {
        String range = "Enter guess " + type + " from 1 to " + bound +
                ". " + chances + " Chances left";
        this.setRangeMessage(range);
    }

    /**
     * getRangeAlphabet()
     * creates a message about alphabet range of valid input
     * values and sets it to the rangeMessage field
     *
     * @param type    can be (Alphabets)
     * @param bound   can be a character from (a, j)
     * @param chances can be an integer from (5, 4, 3)
     **/
    public void getRangeAlphabet(String type, int bound, int chances) {
        char letter = (char) ('a' + bound);
        String range = "Enter " + type + " in range from 'a' to '" + (char) (letter-1) +
                "' " + chances + " Chances left";
        this.setRangeMessage(range);
    }

    /**
     * getInstructions()
     * creates a message that gives instructions to the player about how to play the game.
     * It uses the getRangeMessage() method to include information about the range of valid input values.
     *
     * @param type    can be String (Numbers, Alphabets)
     * @param chances can be an integer from (5, 4, 3)
     * @param level   can be a String (easy, medium, hard)
     * @return sum of instruction + range
     **/
    public String getInstructions(String type, int chances, String level) {
        String instruction = """
                                
                Guess the\s""" + type + """ 
                 : 
                ------------------------------------------
                Instructions:
                1. Guess the\s""" + type + """
                 based on the given range.
                2. You are allowed to make one guess at a time.
                3. Each game has\s""" + chances + """ 
                 chances to guess the correct number.
                4. Once you have used all your chances, you lose the game.
                                
                Good Luck!
                """ + level + """
                :
                """;

        String range = getRangeMessage();

        return instruction + range;
    }
}
