import java.util.Random;

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
}
