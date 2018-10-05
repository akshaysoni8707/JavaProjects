import java.util.Arrays;

public class wordLink {
    private String[] library;
    private String[] questions = new String[2];
    private char[] lettersChose;
    private int counter;

    public static void main(String[] args) {
        // wordLink w = new wordLink();
        new wordLink().display();
    }

    private void createLibrary() {
        library = new String[]{"hello", "this", "is", "his", "iiht", "bat", "that", "bot", "boat"};
    }

    private void chooseLetter() {
        lettersChose = new char[]{'a', 'b', 't', 's', 'o', 't', 'h', 'i'};
    }

    private void setQuestions() {
        createLibrary();
        chooseLetter();
        int i = 0;
        do {
            String tempString;
            tempString = library[i];
            // StringBuilder temp=new StringBuilder();

            for (char aLettersChose : lettersChose) {
                if (tempString.contains(Character.toString(aLettersChose))) {
                    //  System.out.println(tempString + " " + aLettersChose);
                    tempString = tempString.replaceFirst(String.valueOf(aLettersChose), " ");
                }
            }
            // System.out.println(tempString);
            char[] charArray = tempString.toCharArray();
            for (int i1 = 0; i1 < charArray.length; i1++) {
                if (charArray[i1] != ' ') {
                    break;
                } else if (i1 == charArray.length - 1) {
                    add(library[i]);
                    break;
                }
            }
            i++;
            //  System.out.println(counter);
        } while (i < library.length);
    }

    private void add(String str) {
        if (questions.length >= 2) {
            this.questions = Arrays.copyOf(questions, questions.length + 1);
            questions[counter++] = str;
        } else {
            questions[counter++] = str;
        }
    }

    private void display() {
        setQuestions();
        System.out.println("\t\t\t\t\t\t\t\t\t" + Arrays.toString(lettersChose));
        for (int i1 = 0; i1 < counter; i1++) {
            System.out.print("\t\t\t\t\t\t\t\t\t\t" + questions[i1] + "  ");
            for (char ignored : questions[i1].toCharArray()) {
                System.out.print("_ ");
            }
            System.out.println();
        }
    }
}
