package collectiondemo;

import java.io.*;
import java.util.*;

public class CollectonDemo {

    public static void main(String[] args) {
//        Account account = new Account();
        ArrayList sumit = new ArrayList();
        Vector v = new Vector();

        Vector<User> users = new Vector<>();

        MyJavaElement<User> userMyJavaElement = new MyJavaElement<>();
        userMyJavaElement.show();

        //MyJavaElement<CollectonDemo> collectonDemoMyJavaElement = new MyJavaElement<CollectonDemo>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            users.add(user);
            user.setId(0);
            user.setName("sumit");
            System.out.println(users.get(i).getId());
            users.remove(0);
        }
        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        //Traversing list through Iterator
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


        ListIterator<String> list1 = list.listIterator(list.size());
        while (list1.hasPrevious()) {
            String str = list1.previous();
            System.out.println(str);
        }

        //Here, we are using lambda expression
        list.forEach(System.out::println);


        Iterator<String> itr2 = list.iterator();
        itr2.hasNext();
        itr.forEachRemaining(a -> //Here, we are using lambda expression
        {
            System.out.println(a);
        });

//        v.add(55);
//        v.add(new Integer(23).floatValue());
//        System.out.println(v.get(1));
//        sumit.add(55);
//        sumit.add("akshay");
//        System.out.println(sumit.get(0).getClass());
//        System.out.println(sumit);
//        Integer a = ( Integer ) sumit.get(0);

    }
}

class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class DynamicArray implements List {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}


class MyJavaElement<T extends User> {
    void show() {
        System.out.println("display");
    }
}

class Pair<T extends String, E extends String> {

}