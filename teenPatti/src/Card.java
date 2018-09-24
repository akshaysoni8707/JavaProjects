import java.util.Random;
import java.util.Scanner;

public class Card {
    final int SIZE = 3;
    String message = "";
    Card[] winner = new Card[3];
    Scanner scanner = new Scanner(System.in);
    char type[] = {'\u2660', '\u2665', '\u2666', '\u2663'}, singleCard;
    int numbers[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, singleNumber;
    int randomCheck[] = new int[9];
    String name = "Player";
    int index = 0;
    Random random = new Random();
    Card totalCard[] = new Card[9];
    Card playerCard[][];

    public Card() {
        randomCheck = new int[SIZE * 2];
        totalCard = new Card[(SIZE * 2)];
        playerCard = new Card[SIZE - 1][SIZE];
    }

    public Card(int size) {
        randomCheck = new int[SIZE * size];
        totalCard = new Card[(SIZE * size)];
        playerCard = new Card[size][SIZE];
    }

    public Card(char type, int numbers) {
        this.singleCard = type;
        this.singleNumber = numbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;
        long start = System.currentTimeMillis();
        System.out.println("Enter the players you want to play with?");
        numberOfPlayers = scanner.nextInt();
        Card card = new Card(numberOfPlayers);
        card.randomCard();
        for (int y = 0; y < numberOfPlayers; y++) {
            System.out.println(" player " + (y + 1) + " Enter your name :");
            card.display(card.playerCard[y], scanner.next());
        }
        card.winner = card.playerCard[0];
        System.out.println(card.winner[0].name);
        for (int y = 1; y < numberOfPlayers; y++) {
            card.winner = card.checkWin(card.playerCard[y], card.winner);
            System.out.println(card.maxCard(card.winner) + " " + card.message);
        }
        System.out.println("Final winner " + card.maxCard(card.winner) + " " + card.message);
        long end = System.currentTimeMillis();
        System.out.println("start :" + start + " end :" + end + " time taken : " + (end - start));
    }

    void display(Card[] cards, String name) {
        int i = 0;
        cards[i].name = name;
        cards[i + 1].name = name;
        cards[i + 2].name = name;
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
        int i = 0, secondIndex = 0;
       /* randomCheck[0] = 0;
        randomCheck[1] = 24;
        randomCheck[2] = 49;*/
        for (; i < randomCheck.length; i++) {
            int r = random.nextInt(51);
            for (int x : randomCheck) {
                if (r == x)
                    r = random.nextInt(51);
            }
            randomCheck[i] = r;
            totalCard[i] = new Card(typeCapture(r), getNumber(r));
        }
        for (int z = 0; z < i; ++z) {
            if (index < playerCard.length) {
                if (z % 3 == 0 && z > 0) {
                    index++;
                    secondIndex = 0;
                    if (index == playerCard.length) break;
                }
                playerCard[index][secondIndex] = totalCard[z];
                secondIndex++;
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

    Card[] checkWin(Card card1[], Card card2[]) {
        ///Same number
        if (sameNumber(card1)) {
            if (sameNumber(card2)) {
                if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                    message = card1[0].name + " wins ,Same numbers ";
                    return card1;
                } else {
                    message = card2[0].name + " wins ,Same numbers ";
                    return card2;
                }
            } else {
                message = card1[0].name + " wins ,Same numbers ";
                return card1;
            }
        } else if (sameNumber(card2)) {
            message = card2[0].name + " wins ,Same numbers ";
            return card2;
        }
        ///Same Card Type and Numbers in Sequence
        else if (sameType(card1) && sequenceChecker(card1)) {
            if (sameType(card2) && sequenceChecker(card2)) {
                if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                    message = card1[0].name + " wins Same Card Type and Numbers in Sequence";
                    return card2;
                } else if (maxCard(card1).singleNumber < maxCard(card2).singleNumber) {
                    message = card2[0].name + " wins Same Card Type and Numbers in Sequence";
                    return card2;
                } else {
                    if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                        message = card1[0].name + " wins Same Card Type and Numbers in Sequence";
                        return card1;
                    } else {
                        message = card2[0].name + " wins Same Card Type and Numbers in Sequence";
                        return card2;
                    }
                }
            } else {
                message = card1[0].name + " wins Same Card Type and Numbers in Sequence";
                return card1;
            }
        } else if (sameType(card2) && sequenceChecker(card2)) {
            message = card2[0].name + " wins Same Card Type and Numbers in Sequence";
            return card2;
        }
        ///Sequence of Numbers
        else if (sequenceChecker(card1)) {
            if (sequenceChecker(card2)) {
                if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                    message = card1[0].name + " wins Sequence of numbers";
                    return card1;
                } else if (maxCard(card1).singleNumber < maxCard(card2).singleNumber) {
                    message = card2[0].name + " wins Sequence of numbers";
                    return card2;
                } else {
                    if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                        message = card1[0].name + " wins Sequence of numbers";
                        return card1;
                    } else {
                        message = card2[0].name + " wins Sequence of numbers";
                        return card2;
                    }
                }
            } else {
                message = card1[0].name + " wins Sequence of numbers";
                return card1;
            }
        } else if (sequenceChecker(card2)) {
            message = card2[0].name + " wins Sequence of numbers";
            return card2;
        }
        ///All Cards Same type
        else if (sameType(card1) && sameType(card2) && maxCard(card1).singleCard == maxCard(card2).singleCard) {
            if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                message = card1[0].name + " wins high card number,all cards are same";
                return card1;
            } else {
                message = card2[0].name + " wins high card number,all cards are same";
                return card2;
            }
        }
        ///Same Card type
        else if (sameType(card1)) {
            if (sameType(card2)) {
                if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                    message = card1[0].name + " wins Same cards";
                    return card1;
                } else {
                    message = card2[0].name + " wins Same cards";
                    return card2;
                }
            } else {
                message = card1[0].name + " wins Same cards";
                return card1;
            }
        } else if (sameType(card2)) {
            message = card2[0].name + " wins Same cards";
            return card2;
        }
        ///High card
        else {
            if (maxCard(card1).singleNumber > maxCard(card2).singleNumber) {
                message = card1[0].name + " wins by high card";
                return card1;
            } else if (maxCard(card1).singleNumber < maxCard(card2).singleNumber) {
                message = card2[0].name + " wins by high card";
                return card2;
            } else {
                if (maxCard(card1) == maxTypeCheck(maxCard(card1), maxCard(card2))) {
                    message = card1[0].name + " wins by high card";
                    return card1;
                } else {
                    message = card2[0].name + " wins by high card";
                    return card2;
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
