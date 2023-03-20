import java.util.ArrayList;
import java.util.Collections;

public class Player {
    int tries;/**variable that keeps track of the number of tries the player has made.*/
    int numbersHighScore;/**variable that keeps track of the number of tries the player has made.*/
    int alphabetsHighScore;



    /**variable that keeps track of the player's high score for guessing alphabets.*/
    private boolean isLoserNumber;
    private boolean isLoserAlphabet;

    /**ArrayList of integers that keeps track of the player's scores for guessing numbers.*/
    ArrayList<Integer> numbersScore = new ArrayList<>();
    /**An ArrayList of integers that keeps track of the player's scores for guessing alphabets.*/
    ArrayList<Integer> alphabetsScore = new ArrayList<>();

    /**Player()
     * A constructor method that initializes the 'numbersHighScore' and 'alphabetsHighScore' variables to zero.
     */
    public Player() {
        this.numbersHighScore = 0;
        this.alphabetsHighScore = 0;
    }

    /**getNumbersHighScore()
     * A method that returns the player's high score for guessing numbers.
     * @return numbersHighScore
     */
    public int getNumbersHighScore() {
        return numbersHighScore;
    }

    /**setNumbersHighScore()
     * A method that sets the numbersHighScore variable to the minimum score in the numbersScore ArrayList.
     */
    public void setNumbersHighScore() {
        this.numbersHighScore = Collections.min(getNumbersScore());
    }

    /**getAlphabetsHighScore()
     * A method that returns the player's high score for guessing alphabets.
     * @return alphabetsHighScore
     */
    public int getAlphabetsHighScore() {
        return alphabetsHighScore;
    }

    /**setAlphabetsHighScore()
     * A method that sets the alphabetsHighScore variable to the minimum score in the alphabetsScore ArrayList.
     */
    public void setAlphabetsHighScore() {
        this.alphabetsHighScore = Collections.min(getAlphabetsScore());
    }

    /**getNumbersScore()
     * A method that returns the numbersScore ArrayList.
     * @return numbersScore
     */
    public ArrayList<Integer> getNumbersScore() {
        return numbersScore;
    }

    /**setNumbersScore()
     * A method that adds a score to the numbersScore ArrayList and sets the
     * 'numbersHighScore' variable to the minimum score in the ArrayList.
     */
    public void setNumbersScore(int score) {
        this.numbersScore.add(score);
        setNumbersHighScore();
    }

    /**getAlphabetsScore()
     * A method that returns the alphabetsScore ArrayList.
     * */
    public ArrayList<Integer> getAlphabetsScore() {
        return alphabetsScore;
    }

    /**setAlphabetsScore()
     * A method that adds a score to the alphabetsScore ArrayList and sets the
     * alphabetsHighScore variable to the minimum score in the ArrayList.
     */
    public void setAlphabetsScore(int score) {
        this.alphabetsScore.add(score);
        this.setAlphabetsHighScore();
    }

    public boolean isLoserNumber() {
        return isLoserNumber;
    }

    public void setLoserNumber(boolean loserNumber) {
        isLoserNumber = loserNumber;
    }


    public boolean isLoserAlphabet() {
        return isLoserAlphabet;
    }

    public void setLoserAlphabet(boolean loserAlphabet) {
        isLoserAlphabet = loserAlphabet;
    }

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
