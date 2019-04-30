package collectiondemo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class LinkedListdemo {
    private static LinkedListdemo ourInstance = new LinkedListdemo();

    private LinkedListdemo() {
    }

    public static LinkedListdemo getInstance() {
        return ourInstance;
    }

//    public static void main(String[] args) {
//        LinkedList<User> linkedListt = new LinkedList<>();
//        ThreadGroup x =new ThreadGroup("a");
//        Thread a =new Thread(x,"1");
//        ThreadGroup b =new ThreadGroup(x,"2");
//        ThreadGroup c =new ThreadGroup(x,"3");
//        TreeSet<String> al=new TreeSet<>();
//        al.add("Ravi");
//        al.add("Vijay");
//        al.add("Ravi");
//        al.add("Ajay");
//
//        Iterator<String> itr=al.descendingIterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

//    }

    public static void main(String[] args) {
        Set<Book> set = new TreeSet<Book>();
        //Creating Books
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        //Adding Books to TreeSet
        set.add(b1);
        set.add(b2);
        set.add(b3);
        //Traversing TreeSet
        for (Book b : set) {
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }
    }

}

class Book implements Comparable<Book> {
    int id;
    String name, author, publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public int compareTo(Book b) {
        if (id > b.id) {
            return -1;
        } else if (id < b.id) {
            return 1;
        } else {
            return 0;
        }
        //  return b.name.compareTo(name);
    }
}
