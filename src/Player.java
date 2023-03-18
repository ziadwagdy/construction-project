import java.util.ArrayList;
import java.util.Collections;

public class Player {
    int tries;
    int numbersHighScore;
    int alphabetsHighScore;

    ArrayList<Integer> numbersScore = new ArrayList<>();
    ArrayList<Integer> alphabetsScore = new ArrayList<>();

    public Player() {
        this.numbersHighScore = 0;
        this.alphabetsHighScore = 0;
    }

    public int getNumbersHighScore() {
        return numbersHighScore;
    }

    public void setNumbersHighScore() {
        this.numbersHighScore = Collections.min(getNumbersScore());
    }

    public int getAlphabetsHighScore() {
        return alphabetsHighScore;
    }

    public void setAlphabetsHighScore() {
        this.alphabetsHighScore = Collections.min(getAlphabetsScore());
    }

    public ArrayList<Integer> getNumbersScore() {
        return numbersScore;
    }
    public void setNumbersScore(int score) {
        this.numbersScore.add(score);
        setNumbersHighScore();
    }

    public ArrayList<Integer> getAlphabetsScore() {
        return alphabetsScore;
    }
    public void setAlphabetsScore(int score) {
        this.alphabetsScore.add(score);
        this.setAlphabetsHighScore();
    }
}
