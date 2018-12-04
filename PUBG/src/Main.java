import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static {
        System.out.println("              ________    __      __     __________    ___________ ");
        System.out.println("             |   __   |  |  |    |  |   |   ____   |  |   ________|");
        System.out.println("             |  |  |  |  |  |    |  |   |  |   |   |  |  |");
        System.out.println("             |  |__|  |  |  |    |  |   |  |__ /  /   |  |    ____");
        System.out.println("             |   _____|  |  |    |  |   |   __   |    |  |   |__  |");
        System.out.println("             |  |        |  |    |  |   |  |   \\  \\   |  |     |  |");
        System.out.println("             |  |        |  |____|  |   |  |____|  |  |  |_____|  |");
        System.out.println("             |__|        |__________|   |__________|  |___________|");
    }

    public static void main(String[] args) {
        PUBG pubg = new PUBG();
        pubg.setGameObject(pubg);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        pubg.game();
        try {
            System.out.println("\n\t\t\t\tPlease wait while game is loading.\n");
            System.out.print("\t\t\t\t");
            for (int i = 0; i < 45; i++) {
                Thread.sleep(100);
                System.out.print("|");
            }
        } catch (InterruptedException ignored) {

        }
        System.out.println("\n\n\t\t\t\tGame is Staring.");
        System.out.println("\n\n Total squad and players information before game.......\n");
        pubg.display();


        do {
            try {
                executor.execute(pubg);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (pubg.getGameStatus());
        executor.shutdown();
        while (!executor.isTerminated()) {
            //   executor.shutdown();
        }
        System.out.println("\n\n Total squad and players information before game.......\n");
        pubg.display();
        System.out.println("\n\n\n\n Winner Winner Chicken Dinner.......\n\n");
        pubg.finalWinner();
    }
}
