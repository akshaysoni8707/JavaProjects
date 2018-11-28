import java.util.Random;

public class Calc extends Thread {
    public int counter = 0;

    public static void main(String[] args) {
        Calc obj[] = new Calc[3];
        Calc obj1[] = new Calc[3];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = new Calc();
            obj1[i] = new Calc();
        }
        for (int i = 0; i < obj.length; i++) {
            obj[i].start();
            obj1[i].start();
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public void run() {
        Random random = new Random();
        int a = random.nextInt(10), b = random.nextInt(10);
        try {
            if (this.add(a, b) % 3 == 0 || this.add(a, b) % 2 == 0) {
                this.counter++;
                if (this.counter == 3) {
                    System.out.println("object over " + a + " " + b);
                } else {
                    run();
                }
            } else {
                System.out.println("hello " + a + " " + b);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
