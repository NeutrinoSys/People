package datastore;

import java.time.Year;
import java.util.Optional;

public class OptionalTest {
    record Car(String make, String model, String color, Year year){}
    record Person(Long id, String firstName, String lastName, Optional<Car> car) implements Repository.IDable<Long>, Repository.Saveable {}
    public static void main(String[] args) {
        Repository<Person, Long> repo = new Repository<>();
        Person p1 = new Person(100L, "Tom", "Thumb", Optional.of(new Car("Tesla", "X", "Red", Year.of(2018))));
        Person p2 = new Person(200L, "Jerry", "Thumb", Optional.of(new Car("Tesla", "Y", "White", Year.of(2020))));
        Person p3 = null;
        Person p4 = new Person(200L, "Jake", "Thumb", Optional.of(new Car("Tesla", "3", "Blue", Year.of(2019))));
        Person p5 = new Person(200L, "Johnny", "Thumb", Optional.of(new Car("Tesla", "S", "Black", Year.of(2021))));

        Optional<Person> p11 = Optional.ofNullable(p3);
        p11.stream()
                .map(Person::firstName)
                .forEach(System.out::println);

//        List<Optional<Person>> people = List.of(Optional.of(p1), Optional.of(p2), Optional.ofNullable(p3), Optional.of(p4), Optional.of(p5));
//        people.stream()
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .map(Person::firstName)
//                .forEach(System.out::println);

    }
}
