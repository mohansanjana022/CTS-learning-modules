import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class CallableExecutorDemo {
    public static void main(String[] args) {
        // Create a fixed thread pool of size 4
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // List to hold Future results
        List<Future<String>> futures = new ArrayList<>();

        // Submit 5 Callable tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            Callable<String> task = () -> {
                // Simulate some work
                Thread.sleep(1000);
                return "Result from Task " + taskId;
            };
            Future<String> future = executor.submit(task);
            futures.add(future);
        }

        // Collect results
        for (Future<String> future : futures) {
            try {
                // get() blocks until the result is available
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown executor service
        executor.shutdown();
    }
}

