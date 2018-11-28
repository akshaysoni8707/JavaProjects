package innertest;

public class TestAbstract extends Thread {
    public static void main(String[] args) {
        Person person = new Person() {
            @Override
            public void show() {
                System.out.println("hello i am overrided " + this);

            }
        };
        Person.Address address = () -> System.out.println("person address");
        person.show();
        address.display();
        System.out.println(address);
    }
}
