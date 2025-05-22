public class OperatorPrecedenceExample {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;            // Multiplication first: 5*2=10 -> 10+10=20
        int result2 = (10 + 5) * 2;          // Parentheses first: 10+5=15 -> 15*2=30
        int result3 = 100 / 5 + 3 * 4 - 8;   // 100/5=20, 3*4=12 -> 20+12=32 -> 32-8=24
        int result4 = 20 % 3 + 6 / 2;        // 20%3=2, 6/2=3 -> 2+3=5
        int result5 = 5 + 3 * 2 - 8 / 4;     // 3*2=6, 8/4=2 -> 5+6=11 -> 11-2=9

        System.out.println("Result 1 (10 + 5 * 2): " + result1);
        System.out.println("Result 2 ((10 + 5) * 2): " + result2);
        System.out.println("Result 3 (100 / 5 + 3 * 4 - 8): " + result3);
        System.out.println("Result 4 (20 % 3 + 6 / 2): " + result4);
        System.out.println("Result 5 (5 + 3 * 2 - 8 / 4): " + result5);
    }
}

