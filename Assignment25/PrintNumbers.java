package Assignment25;

class NumberPrinter extends Thread {

    private final String threadName;

    public NumberPrinter(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " State (RUNNING): Starting execution...");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                // Pause execution briefly to allow context switching
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        
        System.out.println(threadName + " State (TERMINATED): Execution finished.");
    }
}

public class PrintNumbers{
    public static void main(String[] args) {
        // Create thread objects (State: NEW)
        NumberPrinter thread1 = new NumberPrinter("Thread-1");
        NumberPrinter thread2 = new NumberPrinter("Thread-2");

        System.out.println("Thread 1 State after creation: " + thread1.getState());
        System.out.println("Thread 2 State after creation: " + thread2.getState());

        // Start threads (State transitions to RUNNABLE)
        thread1.start();
        thread2.start();

        // Wait for both threads to finish execution
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Thread 1 State after completion: " + thread1.getState());
        System.out.println("Thread 2 State after completion: " + thread2.getState());
        System.out.println("Main thread finished.");
    }
}