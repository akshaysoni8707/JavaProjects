import java.util.Arrays;
import java.util.Random;

public class Card {
    char type[] = {'\u2660', '\u2665', '\u2666', '\u2663'}, singleCard;
    int numbers[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, singleNumber;
    int randomCheck[] = new int[9];
    String name = "Player";
    Random random = new Random();
    Card totalCard[] = new Card[9], computerCard[] = new Card[3], userCard[] = new Card[3], akkiCard[] = new Card[3];

    public Card() {
    }

    public Card(char type, int numbers, String name) {
        this.singleCard = type;
        this.singleNumber = numbers;
        this.name = name;
    }

    public Card(char type, int numbers) {
        this.singleCard = type;
        this.singleNumber = numbers;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
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
        card.checkWin(card.computerCard, card.userCard);
        card.checkWin(card.akkiCard, card.userCard);
        long end = System.currentTimeMillis();
        System.out.println("start :" + start + " end :" + end + " time taken : " + (end - start));
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
        randomCheck[0] = 0;
        randomCheck[1] = 1;
        randomCheck[2] = 2;
        for (; i < randomCheck.length; i++) {
            int r = random.nextInt(51);
            for (int x : randomCheck) {
                if (r == x)
                    r = random.nextInt(51);
            }

            if (i > 2) randomCheck[i] = r;
            else r = randomCheck[i];

            totalCard[i] = new Card(typeCapture(r), getNumber(r));
            if (i < 3) {
                totalCard[i].setName("computercard");
                computerCard[i] = totalCard[i];
            } else if (i < 6) {
                totalCard[i].setName("usercard");
                userCard[i - 3] = totalCard[i];
            } else {
                totalCard[i].setName("Akkicard");
                akkiCard[i - 6] = totalCard[i];
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        //  System.out.println(Arrays.toString(newCards));
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

    void checkWin(Card card1[], Card[] card2) {
        ///Same number
        if (sameNumber(card1)) {
            if (sameNumber(card2)) {
                if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                    System.out.println(card1[0].getName() + " wins ,Same numbers ");
                } else {
                    System.out.println(card2[0].getName() + " wins ,Same numbers ");
                }
            } else {
                System.out.println(card1[0].getName() + " wins ,Same numbers ");
            }
        } else if (sameNumber(card2)) {
            System.out.println(card2[0].getName() + " wins ,Same numbers ");
        }
        ///Same Card Type and Numbers in Sequence
        else if (sameType(card1) && sequenceChecker(card1)) {
            if (sameType(card2) && sequenceChecker(card2)) {
                if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                    System.out.println(card1[0].getName() + " wins Same Card Type and Numbers in Sequence");
                } else if (maxCard(card1).singleNumber < maxCard(card2).singleNumber) {
                    System.out.println(card2[0].getName() + " wins Same Card Type and Numbers in Sequence");
                } else {
                    if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                        System.out.println(card1[0].getName() + " wins Same Card Type and Numbers in Sequence");
                    } else {
                        System.out.println(card2[0].getName() + " wins Same Card Type and Numbers in Sequence");
                    }
                }
            } else {
                System.out.println(card1[0].getName() + " wins Same Card Type and Numbers in Sequence");
            }
        } else if (sameType(card2) && sequenceChecker(card2)) {
            System.out.println(card2[0].getName() + " wins Same Card Type and Numbers in Sequence");
        }
        ///Sequence of Numbers
        else if (sequenceChecker(card1)) {
            if (sequenceChecker(card2)) {
                if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                    System.out.println(card1[0].getName() + " wins Sequence of numbers");
                } else if (maxCard(card1).singleNumber < maxCard(card2).singleNumber) {
                    System.out.println(card2[0].getName() + " wins Sequence of numbers");
                } else {
                    if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                        System.out.println(card1[0].getName() + " wins Sequence of numbers");
                    } else {
                        System.out.println(card2[0].getName() + " wins Sequence of numbers");
                    }
                }
            } else {
                System.out.println(card1[0].getName() + " wins Sequence of numbers");
            }
        } else if (sequenceChecker(card2)) {
            System.out.println(card2[0].getName() + " wins Sequence of numbers");
        }
        ///All Cards Same type
        else if (sameType(card1) && sameType(card2) && maxCard(card1).singleCard == maxCard(card2).singleCard) {
            if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                System.out.println(card1[0].getName() + " wins high card number,all cards are same");
            } else {
                System.out.println(card2[0].getName() + " wins high card number,all cards are same");
            }
        }
        ///Same Card type
        else if (sameType(card1)) {
            if (sameType(card2)) {
                if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                    System.out.println(card1[0].getName() + " wins Same cards");
                } else {
                    System.out.println(card2[0].getName() + " wins Same cards");
                }
            } else {
                System.out.println(card1[0].getName() + " wins Same cards");
            }
        } else if (sameType(card2)) {
            System.out.println(card2[0].getName() + " wins Same cards");
        }
        ///High card
        else {
            if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                System.out.println(card1[0].getName() + " wins by high card");
            } else if (maxCard(card1).singleNumber < maxCard(card2).singleNumber) {
                System.out.println(card2[0].getName() + " wins by high card");
            } else {
                if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                    System.out.println(card1[0].getName() + " wins by high card");
                } else {
                    System.out.println(card2[0].getName() + " wins by high card");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                " " + singleCard +
                " " + singleNumber +
                '}';
    }
}
