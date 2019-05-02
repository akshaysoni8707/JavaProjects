package collectiondemo;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
//        HashSet<Integer> set = new HashSet();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        set.add(5);
//        Iterator<Integer> i = set.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }

        Deque<String> queue = new ArrayDeque<>();
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        System.out.println("head:" + queue.element());
    }
}
