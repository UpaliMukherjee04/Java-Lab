// Task 1: Printing numbers
class NumberTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Number: " + i);
            try {
                Thread.sleep(500); // Pause to allow context switching
            } catch (InterruptedException e) {
                System.out.println("NumberTask interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " completed.");
    }
}

// Task 2: Printing characters
class CharacterTask implements Runnable {
    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'E'; ch++) {
            System.out.println(Thread.currentThread().getName() + " - Letter: " + ch);
            try {
                Thread.sleep(500); // Pause to allow context switching
            } catch (InterruptedException e) {
                System.out.println("CharacterTask interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " completed.");
    }
}

public class TwoTasks {
    public static void main(String[] args) {
        
        Runnable numTask = new NumberTask();
        Runnable charTask = new CharacterTask();

        
        Thread thread1 = new Thread(numTask, "Task-Numbers");
        Thread thread2 = new Thread(charTask, "Task-Letters");

        System.out.println("Starting both tasks simultaneously...\n");

       
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll tasks completed successfully.");
    }
}