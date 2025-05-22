import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Mike");
        names.add("Anna");
        names.add("John");
        names.add("Beth");

        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        names.forEach(System.out::println);
    }
}
