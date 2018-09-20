import java.util.Arrays;
import java.util.Random;

public class Card {
    char type[] = {'\u2660', '\u2665', '\u2666', '\u2663'}, singleCard;
    int numbers[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, singleNumber;
    int randomCheck[] = new int[9];
    Random random = new Random();
    Card totalCard[] = new Card[9], computerCard[] = new Card[3], userCard[] = new Card[3], akkiCard[] = new Card[3];

    public Card(char type, int numbers) {
        this.singleCard = type;
        this.singleNumber = numbers;
    }

    public Card() {
    }

    public static void main(String[] args) {
        Card card = new Card();
        card.randomCard();
        System.out.println(card.maxCard(card.computerCard).toString());
        System.out.println(card.maxCard(card.userCard).toString());
        System.out.println(card.maxCard(card.akkiCard).toString());
        card.display(card.computerCard, "computer");
        card.display(card.userCard, "user");
        card.display(card.akkiCard, "Akki");
        System.out.println("Same number Comp " + card.sameNumber(card.computerCard));
        System.out.println("Same number user " + card.sameNumber(card.userCard));
        System.out.println("Same number Akki " + card.sameNumber(card.akkiCard));
        System.out.println("Same type Comp " + card.sameType(card.computerCard));
        System.out.println("Same type user " + card.sameType(card.userCard));
        System.out.println("Same type akki " + card.sameType(card.akkiCard));
        System.out.println("Sequence comp " + card.sequenceChecker(card.computerCard));
        System.out.println("Sequence user " + card.sequenceChecker(card.userCard));
        System.out.println("Sequence akki " + card.sequenceChecker(card.akkiCard));
    }

    void display(Card[] cards, String name) {
        int i = 0;
        System.out.println("---------------------------------------");
        System.out.println(" _____\t _____ \t _____");
        System.out.println("|" + numberToString(cards[i].singleNumber) + "   |\t" + "|" + numberToString(cards[i + 1].singleNumber) + "   |\t" + "|" + numberToString(cards[i + 2].singleNumber) + "   " + "|");
        System.out.println("|     |\t|     |\t|     |\t" + name);
        System.out.println("|  " + cards[i].singleCard + "  |\t" + "|  " + cards[i + 1].singleCard + "  |\t" + "|  " + cards[i + 2].singleCard + "  |");
        System.out.println("|     |\t|     |\t|     |");
        System.out.println("|_____|\t|_____|\t|_____|");
        System.out.println();
        System.out.println("---------------------------------------");
    }

    void randomCard() {
        int i = 0;
        for (; i < randomCheck.length; i++) {
            int r = random.nextInt(51);
            for (int x : randomCheck) {
                if (r == x)
                    r = random.nextInt(51);
            }
            randomCheck[i] = r;
            totalCard[i] = new Card(typeCapture(r), getNumber(r));
            if (i < 3) computerCard[i] = totalCard[i];
            else if (i < 6) userCard[i - 3] = totalCard[i];
            else akkiCard[i - 6] = totalCard[i];
        }
    }

    public char typeCapture(int number) {
        if (number >= 0 && number <= 12)
            return type[0];
        else if (number >= 13 && number <= 25)
            return type[1];
        else if (number >= 26 && number <= 38)
            return type[2];
        else if (number >= 39 && number <= 51)
            return type[3];
        else
            return '\0';
    }

    public int getNumber(int number) {
        if (number <= 12)
            return numbers[number];
        else if (number < 52)
            return numbers[number % 13];
        else
            return 0;
    }

    Card maxCard(Card card[]) {
        Card max = card[0];
        for (int i = 1; i < card.length; i++) {
            if (max.singleNumber < card[i].singleNumber) {
                max = card[i];
            } else if (max.singleNumber == card[i].singleNumber) {
                max = maxTypeCheck(max, card[i]);
            }
        }
        return max;
    }

    Card maxTypeCheck(Card card1, Card card2) {
        int max1 = 0, max2 = 0;
        for (int i = 0; i < type.length; i++) {
            if (card1.singleCard == type[i]) max1 = i;
            if (card2.singleCard == type[i]) max2 = i;
        }
        if (max1 < max2)
            return card1;
        else
            return card2;
    }

    String numberToString(int data) {
        String string;
        if (data < 10) {
            string = " " + String.valueOf(data);
            return string;
        } else if (data == 10) {
            string = String.valueOf(data);
            return string;
        } else if (data == 11) {
            string = " J";
            return string;
        } else if (data == 12) {
            string = " Q";
            return string;
        } else if (data == 13) {
            string = " K";
            return string;
        } else if (data == 14) {
            string = " A";
            return string;
        } else
            return null;
    }

    boolean sameNumber(Card card[]) {
        return card[0].singleNumber == card[1].singleNumber && card[1].singleNumber == card[2].singleNumber;
    }

    boolean sameType(Card card[]) {
        return card[0].singleCard == card[1].singleCard && card[1].singleCard == card[2].singleCard;
    }

    boolean sequenceChecker(Card card[]) {
        Card[] newCards = sortNumbers(card);
        System.out.println(Arrays.toString(newCards));
        return newCards[0].singleNumber == newCards[1].singleNumber - 1 && newCards[1].singleNumber == newCards[2].singleNumber - 1;
    }

    Card[] sortNumbers(Card card[]) {
        for (int i = 0; i < card.length; i++) {

            for (int j = 0; j < card.length; j++) {
                if (card[i].singleNumber < card[j].singleNumber) {
                    Card temp = card[i];
                    card[i] = card[j];
                    card[j] = temp;
                }
            }
        }
        return card;
    }

    @Override
    public String toString() {
        return "Card{" +
                " " + singleCard +
                " " + singleNumber +
                '}';
    }
}
