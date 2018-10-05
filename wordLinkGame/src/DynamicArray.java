import java.util.Arrays;

public class DynamicArray {
    private String[] question = new String[2];
    private int counter;

    public static void main(String[] args) {
        DynamicArray s = new DynamicArray();
        s.add("akshay");
        s.add("sumit");
        s.add("madhu");
        s.add("kriti");
        s.display();
    }

    private void add(String str) {
        if (question.length >= 2) {
            this.question = Arrays.copyOf(question, question.length + 1);
        }
        question[counter++] = str;
    }

    private void display() {
        for (int i = 0; i < counter; i++) {
            System.out.println(question[i]);
        }
    }
}
