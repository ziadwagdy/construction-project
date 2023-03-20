import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuessAlphabets alphabets = new GuessAlphabets();
        GuessNumbers numbers = new GuessNumbers();
        while (true) {
            System.out.print("""
                    _____________________________________________________________________
                    Welcome to ZAN (the best guessing game in the world),play the game :
                    -----
                    Enter 1 for numbers
                    Enter 2 for Alphabets
                    Enter 3 for getting the high score
                    Enter 4 for Credits
                    Enter 5 to Exit
                                        
                    Enter you choose :  """
            );
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> numbers.handleChoice();

                case 2 -> alphabets.handleChoice();
                case 3 -> {
                    // getting highScore status message

                    numbers.printHighScoreStatus();
                    alphabets.printHighScoreStatus();
                }
                case 4 -> {
                    System.out.println("Printing Credits here");
                    return;
                }
                case 5 -> {
                    System.out.println("Thank you for playing the game, Goodbye <3");
                    return;
                }
                default -> {
                    System.out.println("Invalid Option\n");
                }
            }
        }
    }

//    public static String credits(){
//        return "Zeyad Wagdy Abdelfattah Mohamed "+
//                "Abullah Hatemoğlu " +
//                "Noureldien Soltan";
//    }

    /* TODOO :
        Check all the printed messages
        update instructions (main menu)
        add credits
        add comments on not clear methods
     */
}
