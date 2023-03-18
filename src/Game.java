import java.util.Scanner;

public abstract class Game {
    private static final Player player = new Player();
    private int noOfGuesses;
    private boolean isHint;

    enum GAME_TYPE {
        Numbers,
        Alphabets,
    }

    enum LEVEL {
        Easy,
        Medium,
        Hard,
    }

    public static Player getPlayer() {
        return player;
    }

    private String rangeMessage;

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

    public void decreaseNoOfGuesses() {
        this.noOfGuesses--;
    }

    public abstract boolean isCorrectGuess();

    public abstract void play();

    public abstract void getUserInput();

    public abstract void levelOne();

    public abstract void levelTwo();

    public abstract void levelThree();

    public void increaseTries() {
        player.tries++;
    }

    public abstract void generateRandom();

    public void playGame() {
        this.noOfGuesses = 0;
        int choice;
        System.out.print("""
                Start Menu
                -----------
                Select a difficulty level
                1. Easy
                2. Medium
                3. Hard
                4. Return to main menu
                ===>""");
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
                this.play();
            }
        }
        generateRandom();
        System.out.println("Enter your guess: ");
        while (this.getNoOfGuesses() != 0) {
            System.out.println("Chance #" + this.getNoOfGuesses());
            getUserInput();
            increaseTries();
            if (this.isCorrectGuess()) {
                this.play();
            }
        }
    }


    private void setRangeMessage(String range) {
        this.rangeMessage = range;
    }

    private String getRangeMessage() {
        return this.rangeMessage;
    }

    public void getRange(String type, int bound, int chances) {
        String range = "Enter " + type + " in range 1 to" + bound +
                " " + chances + " Chances left";
        this.setRangeMessage(range);
    }

    public String getInstructions(String type, int chances, String level) {
        String instruction = """
                Guess the\s""" + type + """ 
                s
                 --- Instructions---
                1. Guess the\s""" + type + """
                 based on the given range.
                2. You are allowed to make one guess at a time. 😈
                3. Each game has\s""" + chances + """  
                 chances to guess the correct number.
                4. Once you have used up all your chances, you lose the game.
                Good Luck!
                """ + level + """
                :""";

        String range = getRangeMessage();

        return instruction + range;
    }
}
