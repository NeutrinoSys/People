import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathStuff {

    private static final MathContext mc = new MathContext(32, RoundingMode.HALF_EVEN);

    public static void main(String[] args) {
//        System.out.println( calcAreaOfCircle(3));
//        System.out.println(calcPathVelocity(0.8, 3));
//        System.out.println(calcCentripetalAccel(1.67, .8));
//        System.out.println(calcCentripetalForce(.2, 3.504));

        System.out.println(calcCentripetalForce(.2, .8, 3));
    }

    /**
     * This method calculates the area of a circle
     * It uses the formula: area = PI * radius^2
     * @param radius
     * @return
     */
    public static double calcAreaOfCircle(double radius) {
        // A = PI * r^2
        return Math.PI * Math.pow(radius, 2);
    }

    private static BigDecimal calcPathVelocity(double radius, double period) {
        BigDecimal circumference = new BigDecimal(2)
                .multiply(new BigDecimal(Math.PI))
                .multiply(new BigDecimal(radius));
        return circumference.divide(new BigDecimal(period), mc);
    }

    private static BigDecimal calcCentripetalAccel(BigDecimal pathVel, double radius) {
        return pathVel.pow(2).divide(new BigDecimal(radius), mc);
    }

    private static BigDecimal calcCentripetalForce(double mass, BigDecimal acc) {
        return new BigDecimal(mass).multiply(acc);
    }

    public static BigDecimal calcCentripetalForce(double mass, double radius, double period) {
        BigDecimal pathVelocity = calcPathVelocity(radius, period);
        BigDecimal centripetalAccel = calcCentripetalAccel(pathVelocity, radius);
        BigDecimal centripetalForce = calcCentripetalForce(mass, centripetalAccel);
        return centripetalForce;
    }
}
