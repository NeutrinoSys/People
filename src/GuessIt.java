import java.io.Console;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

public class GuessIt {

    public static final int MAX_ALLOWED_TRIED = 4;

    public static void main(String[] args) {
        int randomNum = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNum);
        String guessedNumText = null;
        int wrongGuessCount = 1;
        for (; wrongGuessCount <= MAX_ALLOWED_TRIED; wrongGuessCount++) {
            guessedNumText = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumText.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumText);
                if (guessedNum == randomNum) {
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    System.out.printf("The random number was %d. You got it in %d %s!%n", randomNum, wrongGuessCount, tryText);
                    break;
                } else {
                    if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                        System.out.printf("You didn't get it!%n");
                        continue;
                    }
                }
            }
        }
        if (wrongGuessCount >= MAX_ALLOWED_TRIED) {
            System.out.printf("You've had %d incorrect guesses. The random number is %d. Ending program now.%n", wrongGuessCount-1, randomNum);
        }
        System.out.println("Program ended...");
    }
}
