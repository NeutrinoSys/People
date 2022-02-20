import java.security.spec.EncodedKeySpec;
import java.util.function.Function;

public class TestEncoder<T,V> {
    private Function<T,V> algo;

    TestEncoder(Function<T,V> algo) {
        this.algo = algo;
    }

    public static void main(String[] args) {
        TestEncoder<String, Integer> encoder = new TestEncoder<>((msg) -> msg.hashCode());
        TestEncoder<String, String> encoder2 = new TestEncoder<>((msg) -> msg.toUpperCase());

        System.out.println(encoder.encode("Hello World"));
        System.out.println(encoder2.encode("Happy birthday"));
        System.out.println(TestEncoder.<String,String>encode("Happy birthday", (msg) -> msg.toUpperCase()));
    }

    private V encode(T msg) {
        return algo.apply(msg);
    }
    
    static <T,V> V encode(T msg, Function<T,V> algo) {
        return algo.apply(msg);
    }
}
