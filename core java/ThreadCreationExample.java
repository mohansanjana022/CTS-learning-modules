class MessageThread extends Thread {
    private String message;
    private int times;

    public MessageThread(String message, int times) {
        this.message = message;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(getName() + ": " + message);
            try {
                Thread.sleep(200); // pause to see thread interleaving clearly
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        MessageThread thread1 = new MessageThread("Message from Thread 1", 5);
        MessageThread thread2 = new MessageThread("Message from Thread 2", 5);

        thread1.start();
        thread2.start();
    }
}
