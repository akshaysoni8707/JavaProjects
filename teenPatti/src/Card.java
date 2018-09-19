import java.util.Arrays;
import java.util.Random;

public class Card {
    char type[] = {'\u2660', '\u2665', '\u2666', '\u2663'}, singleCard;
    int numbers[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, singleNumber;
    int rcheck[] = new int[6];
    Random random = new Random();
    Card totalcard[] = new Card[6], compuetrCard[] = new Card[3], userCard[] = new Card[3];

    public Card(char type, int numbers) {
        this.singleCard = type;
        this.singleNumber = numbers;
    }

    public Card() {
    }

    public static void main(String[] args) {
        Card card = new Card();
        card.randomCard();
        System.out.println(Arrays.toString(card.compuetrCard));
        System.out.println(Arrays.toString(card.userCard));
        System.out.println(card.maxCard(card.compuetrCard).toString());
        System.out.println(card.maxCard(card.userCard).toString());
        System.out.println("Same number Comp " + card.sameNumber(card.compuetrCard));
        System.out.println("Same number user " + card.sameNumber(card.userCard));
        System.out.println("Same type Comp " + card.sameType(card.compuetrCard));
        System.out.println("Same type user " + card.sameType(card.userCard));
        System.out.println("Sequence comp " + card.sequenceChecker(card.compuetrCard));
        System.out.println("Sequence user " + card.sequenceChecker(card.userCard));
    }

    void randomCard() {
        int i = 0;
        for (; i < rcheck.length; i++) {
            int r = random.nextInt(51);
            for (int x : rcheck) {
                if (r == x)
                    r = random.nextInt(51);
            }
            rcheck[i] = r;
            totalcard[i] = new Card(typeCapture(r), getNumber(r));
            if (i < 3) compuetrCard[i] = totalcard[i];
            else userCard[i - 3] = totalcard[i];
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
