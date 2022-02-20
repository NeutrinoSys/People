import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionTests {
    public static void main(String[] args) {
        try {
            Files.lines(Path.of("blahblahblah"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("We were unable to open the file.");
        } finally {
            System.out.println("Make sure this runs no matter what...");
        }
    }











    private static void doSecondLevel(int num) {
        String[] array = {"one", "two", "three"};
//        try {
            if (num != 0) {
                System.out.println(array.length / num);
            }
        int index = 2;
        if (index < array.length) {
            System.out.println(array[index]);
        }
//        } catch (ArrayIndexOutOfBoundsException | ArithmeticException exception) {
//            System.out.printf("Exception type: %s. Message: %s%n", exception.getClass(), exception.getMessage());
//            exception.printStackTrace();
//        }
    }

}
