package innertest;

import java.util.Scanner;

public class TestClasses {
    int data = 10;

    public static void main(String[] args) {
        TestClasses ts = new TestClasses();
        ts.data = 1000;
        First f = new TestClasses.First("sumit", ts);
        f.getName();
        f.display();
    }

    static class First {
        String name = "";
        TestClasses ts = null;

        First() {
        }

        public First(String name, TestClasses ts) {
            this.name = name;
            this.ts = ts;
        }

        String getName() {
            System.out.println("\n\t Enter customer name:");
            Scanner sc = new Scanner(System.in);
            sc.reset();
            name = sc.nextLine();
            sc.reset();
            if (name.matches("^[\\w]+$")) {
                return name;
            } else {
                return getName();
            }
        }

        void display() {
            System.out.println("Name :" + name);
            System.out.println("Data :" + ts.data);
        }

    }
}
