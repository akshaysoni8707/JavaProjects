import java.util.Arrays;
import java.util.regex.Pattern;

public class wordLink {
    private String[] library;
    private String[] questions = new String[2];
    private char[] lettersChose;
    private int counter;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new wordLink().display();
        long end = System.currentTimeMillis();
        System.out.println("Time take for program to run :" + (end - start));
    }

    private void createLibrary() {
        library = new String[]{"hello", "this", "is", "his", "iiht", "bat", "that", "bot", "boat", "at", "hat", "sat"};
    }

    private void chooseLetter() {
        lettersChose = new char[]{'a', 'b', 't', 's', 't', 'h', 'i'};
    }

    private void setQuestions() {
        createLibrary();
        chooseLetter();
        int i = 0;
        do {
            String tempString;
            tempString = library[i];

            for (char aLettersChose : lettersChose) {
                if (tempString.contains(Character.toString(aLettersChose))) {
                    tempString = tempString.replaceFirst(String.valueOf(aLettersChose), " ");
                }
            }
            if (Pattern.matches("^[\\s]+$", tempString)) add(library[i]);
            i++;
        } while (i < library.length);
    }

    private void add(String str) {
        if (questions.length >= 2) {

            this.questions = Arrays.copyOf(questions, questions.length + 1);
        }
        questions[counter++] = str;
    }

    private void display() {
        setQuestions();
        System.out.println("\t\t\t\t\t\t\t\t\t" + Arrays.toString(lettersChose));
        for (int i1 = 0; i1 < counter; i1++) {
            System.out.print("\t\t\t\t\t\t\t\t\t \t" + questions[i1] + " ");
            System.out.print(" \t");
            for (char ignored : questions[i1].toCharArray()) {
                System.out.print("_ ");
            }
            System.out.println();
        }
    }
}
