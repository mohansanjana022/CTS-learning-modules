import java.util.List;
import java.util.stream.Collectors;

public class RecordExample {
    public static record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 22);
        Person p3 = new Person("Charlie", 25);
        Person p4 = new Person("Diana", 19);

        System.out.println(p1);
        System.out.println(p2);

        List<Person> people = List.of(p1, p2, p3, p4);

        List<Person> adults = people.stream()
            .filter(person -> person.age() >= 21)
            .collect(Collectors.toList());

        adults.forEach(System.out::println);
    }
}
