public class PatternMatchingSwitch {

    public static void printObjectType(Object obj) {
        String message = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s -> "It's a String with length: " + s.length();
            case Double d -> "It's a Double with value: " + d;
            case Boolean b -> "It's a Boolean with value: " + b;
            case null -> "The object is null";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(message);
    }

    public static void main(String[] args) {
        printObjectType(42);
        printObjectType("HELLO");
        printObjectType(3.14);
        printObjectType(true);
        printObjectType(null);
        printObjectType(new StringBuilder("Test"));
    }
}
