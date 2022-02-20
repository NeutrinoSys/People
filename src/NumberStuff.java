import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;

public class NumberStuff {
    public static void main(String[] args) {
        int age = Integer.parseInt(args[0]);
        System.out.printf("You will be %d years of age in 15 years.%n", age + 15);
    }

    /**
     * Takes in any type of data and stores it somewhere generically
     */
    public static void storeData(Object obj) {
        // do something with obj
    }

}
