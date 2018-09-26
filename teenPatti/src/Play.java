import java.util.Random;
import java.util.Scanner;

/**
 * This class creates new cards template and helps to manipulate between different cards.
 */
final class Card {
    /**
     * This will store the message of how a player won.
     */
    private String message = "";
    /**
     * This will store the array-object of cards of the winner player .with each card of winner player on its respective index.
     */
    private Card[] winner = new Card[3];
    /*
      type[] - Holds predefined 4 types , any card must be of a type from these 4.
     */
    /**
     * singleCard - holds the type of particular card from predefined type.
     */
    private char type[] = {'\u2660', '\u2665', '\u2666', '\u2663'}, singleCard;
    /*
      number[] - Holds predefined numbers , any card must be of a number from these 13.
     */
    /**
     * singleNumber - holds the number of particular card from predefined numbers.
     */
    private int numbers[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, singleNumber;
    /**
     * Holds all the randomly generated cards ,is used to check if new generated random card is not already used.
     */
    private int randomCheck[] = new int[9];
    /**
     * Holds name of player on his respective card.
     */
    private String name = "Player";
    /**
     * used as first index of 2D array playerCard[][].
     */
    private int index = 0;
    /**
     * object of Random class used to generate new random objects.
     */
    private Random random = new Random();
    /**
     * holds all the random generated cards,with their card number and card type.
     */
    private Card totalCard[] = new Card[9];
    /**
     * At each index it stores a player with 3 cards on its sizeindex.
     */
    private Card playerCard[][];

    /**
     * @param size takes number of players for whom cards are to be generated
     */
    private Card(int size) {
        int SIZE = 3;
        randomCheck = new int[SIZE * size];
        totalCard = new Card[(SIZE * size)];
        playerCard = new Card[size][SIZE];
    }

    /**
     * @param type    takes type of card .
     * @param numbers takes number of a card.
     */
    private Card(char type, int numbers) {
        this.singleCard = type;
        this.singleNumber = numbers;
    }

    /**
     * This is the method that is used in main to play the game.
     */
    static void gamePlay() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers;
        System.out.println("Enter the number of players :");
        numberOfPlayers = scanner.nextInt();
        Card card = new Card(numberOfPlayers);
        card.randomCard();
        for (int y = 0; y < numberOfPlayers; y++) {
            System.out.println("player " + (y + 1) + " Enter your name :");
            card.display(card.playerCard[y], scanner.next());
        }
        card.winner = card.playerCard[0];
        for (int y = 1; y < numberOfPlayers; y++) {
            System.out.print("Between " + card.playerCard[y][0].name + " and " + card.winner[0].name + " ,");
            card.winner = card.checkWin(card.playerCard[y], card.winner);
            System.out.println(card.message + " ,high card of " + card.winner[0].name + " is " + card.maxCard(card.winner) + "\n");
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t\tFinal winner is " + card.winner[0].name + " \n" + card.message + " ," + card.winner[0].name + "'s high card is " + card.maxCard(card.winner));
    }

    /**
     * @param cards takes array of cards containing all cards of that player.
     * @param name takes name of the player.
     */
    private void display(Card[] cards, String name) {
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

    /**
     * This method generates and stores new random cards for given players.
     */
    private void randomCard() {
        int i = 0;
       /* randomCheck[0] = 0;
        randomCheck[1] = 24;
        randomCheck[2] = 49;*/
        for (; i < randomCheck.length; i++) {
            int r = random.nextInt(51);
            for (int i1 = 0; i1 < randomCheck.length; i1++) {
                int x = randomCheck[i1];
                if (r == x) {
                    r = random.nextInt(51);
                    i1 = 0;
                }
            }
            randomCheck[i] = r;
            totalCard[i] = new Card(typeCapture(r), getNumber(r));
        }
        int secondIndex = 0;
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

    /**
     * @param number takes the number(form deck of 52 cards) of a card.
     * @return Its suit type for 4 predefined types.
     */
    private char typeCapture(int number) {
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

    /**
     * @param number takes the number(form deck of 52 cards) of a card.
     * @return Its card number (from 2 to 14).
     */
    private int getNumber(int number) {
        if (number <= 12)
            return numbers[number];
        else if (number < 52)
            return numbers[number % 13];
        else
            return 0;
    }

    /**
     * @param card Takes array of cards of a given player.
     * @return Highest card of that player.
     */
    private Card maxCard(Card card[]) {
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

    /**
     * @param card1 Takes card with Highest card number in cards of player, which clashes with other card of same number.
     * @param card2 Takes card with Highest card number in cards of player, which clashes with other card of same number.
     * @return The card with higher type priorty of the given 2 cards.
     */
    private Card maxTypeCheck(Card card1, Card card2) {
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

    /**
     * @param data Takes the card number of a card(from 2 to14).
     * @return J for 11,Q for 12,K for 13 and A for 14.
     */
    private String numberToString(int data) {
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

    /**
     * @param card Takes array of cards containing all 3 cards of a player .
     * @return If the given cards are of same number or not.
     */
    private boolean sameNumber(Card card[]) {
        return card[0].singleNumber == card[1].singleNumber && card[1].singleNumber == card[2].singleNumber;
    }

    /**
     * @param card Takes array of cards containing all 3 cards of a player .
     * @return If the given cards are of same type or not.
     */
    private boolean sameType(Card card[]) {
        return card[0].singleCard == card[1].singleCard && card[1].singleCard == card[2].singleCard;
    }

    /**
     * @param card Takes array of cards containing all 3 cards of a player .
     * @return If the given cards are in sequence or not.
     */
    private boolean sequenceChecker(Card card[]) {
        Card[] newCards = sortNumbers(card);
        return newCards[0].singleNumber == newCards[1].singleNumber - 1 && newCards[1].singleNumber == newCards[2].singleNumber - 1;
    }

    /**
     * @param card Takes array of cards containing all 3 cards of a player .
     * @return Sorts given cards in accending order based on their number.
     */
    private Card[] sortNumbers(Card card[]) {
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

    /**
     * @param card1 Takes array of cards containing all 3 cards of a player 1.
     * @param card2 Takes array of cards containing all 3 cards of a player 2.
     * @return The winner among both the players and winning reason of a player as a message.
     */
    private Card[] checkWin(Card card1[], Card card2[]) {
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

    /**
     * @return display of singleCard and singleNumber pf a card.
     */
    @Override
    public final String toString() {
        return "Card{" +
                " " + singleCard +
                " " + singleNumber +
                '}';
    }
}

/**
 * This class contains the main method to play the game.
 */
public class Play {

    /**
     * @param args Doesn't takes any runtime argument , only calls the method gamePlay of Card class to play the game.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Card.gamePlay();
        long end = System.currentTimeMillis();
        System.out.println("\n\nstart :" + start + " end :" + end + " time taken : " + (end - start));
    }
}
