
import java.util.Random;
import java.util.Scanner;
public class newGuessNumbers extends Game {
    int highScore = 0; //highScore
    int userInput;     //userInput
    int randomNumber;  //randomNumber
    int tries = 0;     //tries
    int choice;

    public newGuessNumbers() { // Unparameterized Constructor
        //this constructor only generates a random number once, when the object is first created.
        //instance of the Random class
        Random random = new Random();
        //generates a random integer between 1 (inclusive) and 15 (inclusive), and assign it to randomNumber datafield
        this.randomNumber = random.nextInt(15) + 1;
    }

    public int getRandomNumber(int max) { // getter for randomNumber datafield, this method
        // generates a new random number every time it's called.
        Random random = new Random();
        return random.nextInt(max);
    }

    @Override
    public boolean isCorrectGuess() {// this method compares the user's input with the randomly generated number.

        if (this.userInput == this.randomNumber) {
            System.out.println(this.userInput + " Is a correct guess, YOU WIN the game with just " + tries + " tries");
            this.highScore++;
            return true;
        } else if (this.userInput > this.randomNumber) {
            if (isHint) {
                System.out.println(this.userInput + " Is wrong! Your guess was too high\n");
            }
            this.noOfGuesses--;
        } else {
            if (isHint) {
                System.out.println(this.userInput + " Is wrong! Your guess was too low\n");
            }
            this.noOfGuesses--;
        }
        return false;
    }

    @Override
    public void setup() {
        int choice = 1;
        while (choice == 1) {
            int level;
            startMenu();
            //Takes the level input from the user.
            level = new Scanner(System.in).nextInt();
            switch (level) {
                case 1 ->
                        levelOne();
                case 2 ->
                        levelTwo();
                case 3 ->
                        levelThree();
                case 4 -> {
                    levelFour();
                    System.out.print("Enter your choice: ");
                    choice = new Scanner(System.in).nextInt();
                    noOfGuesses = 0;
                }
                default -> {
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
                }
            }
            System.out.println(this.randomNumber);
            tries = 0;
            while (noOfGuesses != 0 && level >= 1 && level <= 4) {
                if (level == 1) {
                    System.out.print("Enter your guess from 1 to 15, ");
                }
                if (level == 2) {
                    System.out.print("Enter your guess from 1 to 20, ");
                }
                if (level == 3) {
                    System.out.print("Enter your guess from 1 to 40, ");
                }
                System.out.println("#" + noOfGuesses + " Chances left.");
                getUserInput();
                tries++;
                if (isCorrectGuess()) {
                    break;
                }
                if (noOfGuesses == 0) {
                    System.out.println("You Lost the game, You are out of chances");
                }
            }

        }
    }

    public void levelOne() {
        instructionsEasy();
        this.setNoOfGuesses(5);
        this.setHint(true);
        this.randomNumber = getRandomNumber(15) + 1;
    }

    @Override
    public void levelTwo() {
        instructionsMedium();
        this.setNoOfGuesses(4);
        this.setHint(false);
        this.randomNumber = getRandomNumber(20) + 1;
    }

    @Override
    public void levelThree() {
        instructionsHard();
        this.setNoOfGuesses(3);
        this.setHint(false);
        this.randomNumber = getRandomNumber(40) + 1;
    }

    @Override
    public int getHighScore() {
        return this.highScore;
    }

    @Override
    public int increaseTries() {
        return 0;
    }


    public void levelFour() {
        menu();
        this.setHint(true);
        if(choice<1 && choice>5)
            System.out.println("Invalid option, please try again.");
    }

    @Override
    public void getUserInput() {
        Scanner input = new Scanner(System.in);
        this.userInput = input.nextInt();
    }

    public static void menu() {
        System.out.println("MENU"
                + "\n---Choose an Option---"
                + "\n1. Guess the Number."
                + "\n2. Guess the Alphapet."
                + "\n3. Hight score."
                + "\n4. Credit."
                + "\n5. Exit.\n");
    }

    public static void startMenu() {
        System.out.print("\nStart Menu"
                + "\n-----------"
                + "\nSelect a difficulty level"
                + "\n1. Easy\n2. Medium\n3. Hard\n4. Return to main menu\n===> ");
    }

    // TODO : make one function for all:
    public static void instructionsEasy() {
        System.out.println("\nGuess the Number "
                + "\n---Instructions---"
                + "\n1. Guess the number based on the given range."
                + "\n2. You are allowed to make one guess at a time."
                + "\n3. Each game has 5 chances to guess the correct number."
                + "\n4. Once you have used up all your chances, you lose the game."
                + "\n\nGood Luck!\n" + "Easy:");
    }

    public static void instructionsMedium() {
        System.out.println("\nGuess the Number "
                + "\n---Instructions---"
                + "\n1. Guess the number based on the given range."
                + "\n2. You are allowed to make one guess at a time."
                + "\n3. Each game has 4 chances to guess the correct number."
                + "\n4. Once you have used up all your chances, you lose the game."
                + "\n\nGood Luck!\n" + "Medium:");
    }

    public static void instructionsHard() {
        System.out.println("\nGuess the Number "
                + "\n---Instructions---"
                + "\n1. Guess the number based on the given range."
                + "\n2. You are allowed to make one guess at a time."
                + "\n3. Each game has 3 chances to guess the correct number."
                + "\n4. Once you have used up all your chances, you lose the game."
                + "\n\nGood Luck!\n" + "Hard:");
    }


    public static void main(String[] args){
        newGuessNumbers numbers = new newGuessNumbers();
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to play(y/n)? ");
        char play = input.nextLine().charAt(0);
        while (play == 'y') {
            menu();
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 1) {
                numbers.setup();
            }
            else {
                System.out.println("Invalid choice, try again");
                break;
            }
        }

        System.out.println("ok");
    }
}
