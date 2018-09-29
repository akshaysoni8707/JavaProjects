import java.util.Arrays;

public class StringFormatter {
    private int number;
    private String cardDetail;
    private StringFormatter card[] = new StringFormatter[3];
    private int counter = 0;

    private StringFormatter(int number, String cardDetail) {
        this.number = number;
        this.cardDetail = cardDetail;
    }

    private StringFormatter() {
    }

    public static void main(String[] args) {
        StringFormatter s = new StringFormatter();
        s.add(1, "Akki");
        s.add(2, "Madhu");
        s.add(3, "Monu");
        s.add(4, "Sumit");
        s.add(5, "Kriti");
        System.out.println(s);
    }

    private void add(int number, String cardDetail) {
        if (counter >= 3) {
            this.card = Arrays.copyOf(card, counter + 1);
        }
        card[counter++] = new StringFormatter(number, cardDetail);
    }

    @Override
    public String toString() {
        String message = "";
        int i = 0;
        for (; i < card.length; i++) {
            message = message.concat(card[i].number + " " + card[i].cardDetail + "\n");
        }
        return message;
    }
}
