import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Combat extends Player implements Runnable {
    public static void main(String[] args) {
        Player c = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        c.setGameObject(c);
        c.game();
        try {
            System.out.println("Initializing Game Please wait...");
            Thread.sleep(1000);
            System.out.println("Players are ready for the battle...");
            Thread.sleep(1000);
            System.out.println("Please, wait for searching the opponent...");
            Thread.sleep(2000);
            System.out.println("Opponent is ready for the battle...");
            Thread.sleep(1000);
            System.out.println("Lets Play...");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.err.println("error" + e.getMessage());
        }
        do {
            try {
                executor.execute(c);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (c.getGameStatus());
        c.display();
        executor.shutdown();
        while (!executor.isTerminated()) {
            executor.shutdown();
        }
        System.out.println("Finished all threads");
    }
}
