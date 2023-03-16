public class Main {
    public static void main(String[] args) {
        GuessAlphabets numbers = new GuessAlphabets();
        numbers.setup();
        int i = 3;
        while (i > 0) {
            numbers.setup();
            i--;
        }
        System.out.println(numbers.highScore);
    }
}