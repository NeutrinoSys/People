public class PatternMatching {
    public static void main(String[] args) throws InterruptedException {
        record Person(String firstName, String lastName, int age){}
        String var1 = "Hello World";
        Integer var2 = 34;
        String[] var3 = {"hello", "world"};
        Person var4 = new Person("Jake", "Johnson", 40);
        Person var5 = new Person("Abe", "Johnson", 40);
        for (int x=0; x <100; x++) {
            System.out.println(x);
            Thread.sleep(100);
        }

        Object obj = 35d;
        switch (obj) {
            case String msg -> System.out.println(msg);
            case Integer num -> System.out.println("Your number is: " + num);
            case Person p && p.firstName().length() > 3 -> System.out.println("Looks like Jake");
            case String[] arr -> System.out.printf("Looks like an array with %d elements.", arr.length);
            case null -> System.out.println("It's null");
            default -> System.out.println("Have no idea");
        }
    }
}
