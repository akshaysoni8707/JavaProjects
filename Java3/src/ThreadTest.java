import java.util.Random;

public class ThreadTest implements Runnable {
    public static void main(String[] args) {
        ThreadTest t[] = new ThreadTest[10];
        Thread thread[] = new Thread[10], thread2[] = new Thread[10];
        ThreadTest threadTest = new ThreadTest(), threadTest2 = new ThreadTest();
        for (int i = 0; i < t.length; i++) {
            thread[i] = new Thread(threadTest, String.valueOf(i));
            thread2[i] = new Thread(threadTest2, String.valueOf(i + 10));
        }
        for (int i = 0; i < t.length; i++) {
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            thread[i].start();
            thread2[i].start();
        }

//        for (int i = 0; i <t.length ; i++) {
//            t[i] = new ThreadTest();
//            thread[i] = new Thread(t[i]);
//        }
//        for (int i = 0; i <t.length ; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            thread[i].run();
//        }
    }

    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ((Integer.parseInt(Thread.currentThread().getName()) >= 0 && Integer.parseInt(Thread.currentThread().getName()) <= 2) || Integer.parseInt(Thread.currentThread().getName()) >= 10 && Integer.parseInt(Thread.currentThread().getName()) <= 12) {
            System.out.println(Thread.currentThread().getName() + " " + new Calc().add(random.nextInt(20), random.nextInt(10)));
        } else if ((Integer.parseInt(Thread.currentThread().getName()) >= 3 && Integer.parseInt(Thread.currentThread().getName()) <= 6) || Integer.parseInt(Thread.currentThread().getName()) >= 13 && Integer.parseInt(Thread.currentThread().getName()) <= 17) {
            System.out.println(Thread.currentThread().getName() + " " + new Calc().mul(random.nextInt(20), random.nextInt(10)));
        }
    }
}
