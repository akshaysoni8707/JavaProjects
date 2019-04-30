class TestInterruptingThread2 extends Thread {
    public static void main(String args[]) {
        TestInterruptingThread2 t1 = new TestInterruptingThread2();
        t1.start();
        if (t1.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.interrupt();
        }


    }

    public void run() {
        try {
            Thread.sleep(90);
            System.out.println("task");
        } catch (InterruptedException e) {
            System.out.println("Exception handled " + e);
        }
        System.out.println("thread is running...");
    }
}
