class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
                if (this.amount > amount) {
                    this.amount -= amount;
                    System.out.println("withdraw completed..." + amount);
                }
            } catch (Exception e) {
            }
        }

    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed... " + amount);
        notifyAll();
    }
}

class Test {
    public static void main(String args[]) {
        final Customer c = new Customer();
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();

        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            public void run() {
                c.deposit(10000);
            }
        }.start();
//        new Thread(){
//            public void run(){c.deposit(10000);}
//        }.start();
//        new Thread(){
//            public void run(){c.deposit(20000);}
//        }.start();
    }
}