import java.math.BigDecimal;

public class GenericsTest {
    static class Stats<T extends Number> {
        T[] nums;
        Stats(T[] nums) {
            this.nums = nums;
        }

        double average() {
            Double sum = 0d;
            for (T num : nums) {
                sum+= num.doubleValue();
            }
            return sum/nums.length;
        }

        static <T extends Number> double average(T[] nums) {
            return new Stats<T>(nums).average();
        }

        boolean sameAvg(Stats<? extends Number> otherStats) {
            return this.average() == otherStats.average();
        }

    }

    public static void main(String[] args) {
        Stats<Long> longs = new Stats<>(new Long[]{1l, 2l, 3l, 4l});
        Stats<Double> doubles = new Stats<>(new Double[]{1d,2d,3d,4d});
        System.out.println(longs.average());
        System.out.println(doubles.average());
        System.out.println(longs.sameAvg(
                new Stats<>(
                        new BigDecimal[]{
                                BigDecimal.valueOf(1),
                                BigDecimal.valueOf(2),
                                BigDecimal.valueOf(3),
                                BigDecimal.valueOf(4)})));
        Stats.average(new Integer[]{5,4,3,2,1});
    }

}
