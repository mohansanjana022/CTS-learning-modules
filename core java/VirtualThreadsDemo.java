public class VirtualThreadsDemo {
    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting traditional threads...");
        long startTraditional = System.currentTimeMillis();
        Thread[] traditionalThreads = new Thread[THREAD_COUNT];
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            traditionalThreads[i] = new Thread(() -> {

            });
            traditionalThreads[i].start();
        }
        
        for (Thread t : traditionalThreads) {
            t.join();
        }
        long endTraditional = System.currentTimeMillis();
        System.out.println("Traditional threads took: " + (endTraditional - startTraditional) + " ms");
        
        System.out.println("\nStarting virtual threads...");
        long startVirtual = System.currentTimeMillis();
        Thread[] virtualThreads = new Thread[THREAD_COUNT];
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            virtualThreads[i] = Thread.startVirtualThread(() -> {

            });
        }
        
        for (Thread t : virtualThreads) {
            t.join();
        }
        long endVirtual = System.currentTimeMillis();
        System.out.println("Virtual threads took: " + (endVirtual - startVirtual) + " ms");
    }
}



*/
Output:
C:\Users\cse&student\Documents>javac VirtualThreadsDemo.java

C:\Users\cse&student\Documents>java VirtualThreadsDemo
Starting traditional threads...
Traditional threads took: 53586 ms

Starting virtual threads...
Virtual threads took: 2748 ms
*/

