import java.util.ArrayList;
import java.util.Collections;

public class Player {
    /**
     * tries field that keeps track of the number of tries the player has made.
     * */
    int tries;

    /**
     * numbersHighScore field that keeps track of the number of tries the player has made.
     * */
    int numbersHighScore;

    /**
     * alphabetsHighScore field that keeps track of the number of tries the player has made.
     * */
    int alphabetsHighScore;

    /**
     * isLoserNumber field is a boolean field that indicates whether the user has lost in guessing numbers game.
     */
    private boolean isLoserNumber;

    /**
     * isLoserAlphabet field is a boolean field that indicates whether the user has lost in guessing alphabets game.
     */
    private boolean isLoserAlphabet;

    /**
     * numbersScore is an arrayList object of integers that keeps track of the player's scores for guessing numbers.
     * */
    ArrayList<Integer> numbersScore = new ArrayList<>();

    /**
     * alphabetsScore is an arrayList object of integers that keeps track of the player's scores for guessing alphabets.
     * */
    ArrayList<Integer> alphabetsScore = new ArrayList<>();

    /**
     * Player()
     * A constructor that initializes the
     * 'numbersHighScore' and 'alphabetsHighScore' fields with zero.
     */
    public Player() {
        this.numbersHighScore = 0;
        this.alphabetsHighScore = 0;
    }

    /**
     * getNumbersHighScore()
     * A method that returns the player's high score for guessing numbers.
     *
     * @return numbersHighScore
     */
    public int getNumbersHighScore() {
        return numbersHighScore;
    }

    /**
     * setNumbersHighScore()
     * A method that sets the numbersHighScore variable to the minimum score in the numbersScore ArrayList.
     */
    public void setNumbersHighScore() {
        this.numbersHighScore = Collections.min(getNumbersScore());
    }

    /**
     * getAlphabetsHighScore()
     * A method that returns the player's high score for guessing alphabets.
     *
     * @return alphabetsHighScore
     */
    public int getAlphabetsHighScore() {
        return alphabetsHighScore;
    }

    /**
     * setAlphabetsHighScore()
     * A method that sets the alphabetsHighScore variable to the minimum score in the alphabetsScore ArrayList.
     */
    public void setAlphabetsHighScore() {
        this.alphabetsHighScore = Collections.min(getAlphabetsScore());
    }

    /**
     * getNumbersScore()
     * A method that returns the numbersScore ArrayList.
     *
     * @return numbersScore
     */
    public ArrayList<Integer> getNumbersScore() {
        return numbersScore;
    }

    /**
     * setNumbersScore()
     * A method that adds a score to the numbersScore ArrayList and sets the
     * 'numbersHighScore' variable to the minimum score in the ArrayList.
     */
    public void setNumbersScore(int score) {
        this.numbersScore.add(score);
        setNumbersHighScore();
    }

    /**
     * getAlphabetsScore()
     * A method that returns the alphabetsScore ArrayList.
     * */
    public ArrayList<Integer> getAlphabetsScore() {
        return alphabetsScore;
    }

    /**
     * setAlphabetsScore()
     * A method that adds a score to the alphabetsScore ArrayList and sets the
     * alphabetsHighScore variable to the minimum score in the ArrayList.
     */
    public void setAlphabetsScore(int score) {
        this.alphabetsScore.add(score);
        this.setAlphabetsHighScore();
    }

    /**
     * isLoserNumber()
     * method that get the isLoserNumber field.
     *
     * @return isLoserNumber
     */
    public boolean isLoserNumber() {
        return isLoserNumber;
    }

    /**
     * setLoserNumber()
     * method that set the isHint isLoserNumber.
     *
     * @param loserNumber can be a boolean(true, false)
     */
    public void setLoserNumber(boolean loserNumber) {
        isLoserNumber = loserNumber;
    }

    /**
     * isLoserAlphabet()
     * method that get the isLoserAlphabet field.
     *
     * @return isLoserAlphabet
     */
    public boolean isLoserAlphabet() {
        return isLoserAlphabet;
    }

    /**
     * setLoserAlphabet()
     * method that set the isHint isLoserAlphabet.
     *
     * @param loserAlphabet can be a boolean(true, false)
     */
    public void setLoserAlphabet(boolean loserAlphabet) {
        isLoserAlphabet = loserAlphabet;
    }

    /**
     * printCredits()
     * A method prints the credits
     */
    public void printCredits(){
        System.out.println(
                """
                        Name : Zeyad Wagdy Abdelfattah Mohamed ID : 210209957 Department : SE
                        Name : Abdallah Hatemoğlu ID : 200209992 Department : SE
                        Name : Noureldien Soltan Abdelrahman Ahmed ID : 210209980 Department : SE
                        Name : Khaled Shihadeh ID : 200209396 Department : SE
                        Name : SHAHBELDIN MOKHTAR ID : 190209997 Department : SE
                        Name : Leen Alshouha ID : 210209448 Department : SE
                        Name : Shiza Khan ID : 200209395 Department : SE
                                """
        );
    }
}
