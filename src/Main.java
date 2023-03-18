import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuessAlphabets alphabets = new GuessAlphabets();
        GuessNumbers numbers = new GuessNumbers();
        while (true) {
            System.out.println("""
                    Welcome, play the game!
                    Enter 1 for numbers
                    Enter 2 for Alphabets
                    Enter 3 for getting the high score
                    Enter 4 for Credits
                    Enter 5 to Exit"""
            );
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> numbers.play();
                case 2 -> alphabets.play();
                case 3 -> {
                    if (Game.getPlayer().getNumbersHighScore() == 0) {
                        System.out.println("Guessing Numbers is not played yet");
                    } else {
                        System.out.println("Your High Score in Numbers "
                                + Game.getPlayer().getNumbersHighScore());
                    }

                    if (Game.getPlayer().getAlphabetsHighScore() == 0) {
                        System.out.println("Guessing Alphabets is not played yet");
                    } else {
                        System.out.println("Your High Score in Alphabets "
                                + Game.getPlayer().getAlphabetsHighScore());
                    }
                }
                case 4 -> {
                    System.out.println("Printing Credits here");
                    return;
                }

                case 5 -> {
                    System.out.println("Thank you for playing the game, Goodbye <3");
                    return;
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
