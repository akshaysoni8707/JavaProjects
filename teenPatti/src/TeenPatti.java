import java.util.Random;

class RandomCardGenerator {
    int card1 = 0;
    int card2 = 0;
    int card3 = 0;
    int card4 = 0;
    int card5 = 0;
    int card6 = 0;
    int[] cardType = {0, 0, 0, 0, 0, 0, 0};
    int[] cardNumber = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    char cardType1, cardType2, cardType3, cardType4, cardType5, cardType6;
    String cardNum1, cardNum2, cardNum3, cardNum4, cardNum5, cardNum6;
    char spade = '\u2660', diamond = '\u2666', heart = '\u2665', clubs = '\u2663';
    static long start, end;
    void CardGenerator() {

        Random random = new Random();

        while (card2 == card1 || card3 == card2 || card3 == card1 || card4 == card3 || card4 == card2 || card4 == card1 || card5 == card4 || card5 == card3 || card5 == card2 || card5 == card1 || card6 == card5 || card6 == card4 || card6 == card3 || card6 == card2 || card6 == card1) {
            card1 = random.nextInt(52) + 1;
            card2 = random.nextInt(52) + 1;
            card3 = random.nextInt(52) + 1;
            card4 = random.nextInt(52) + 1;
            card5 = random.nextInt(52) + 1;
            card6 = random.nextInt(52) + 1;
        }
    }
}

class TypeAndNumber extends RandomCardGenerator {

    void typeNumber(int giveRandomCard, int giveCardNumber) {
        CardGenerator();
        if (giveRandomCard <= 13) {
            cardNumber[giveCardNumber] = giveRandomCard;
            cardType[giveCardNumber] = 0;
        } else if (giveRandomCard <= 26) {
            if (giveRandomCard < 26) {
                cardNumber[giveCardNumber] = giveRandomCard % 13;
                cardType[giveCardNumber] = 1;
            } else {
                cardNumber[giveCardNumber] = 13;
                cardType[giveCardNumber] = 1;
            }
        } else if (giveRandomCard <= 39) {
            if (giveRandomCard < 39) {
                cardNumber[giveCardNumber] = giveRandomCard % 13;
                cardType[giveCardNumber] = 2;
            } else {
                cardNumber[giveCardNumber] = 13;
                cardType[giveCardNumber] = 2;
            }
        } else if (giveRandomCard <= 52) {
            if (giveRandomCard < 52) {
                cardNumber[giveCardNumber] = giveRandomCard % 13;
                cardType[giveCardNumber] = 3;
            } else {
                cardNumber[giveCardNumber] = 13;
                cardType[giveCardNumber] = 3;
            }
        }
    }
}

class ToSymbol extends TypeAndNumber {
    void symbolizing() {
        int x = 0, y = 0;
        CardGenerator();
        typeNumber(card1, 0);
        typeNumber(card2, 1);
        typeNumber(card3, 2);
        typeNumber(card4, 3);
        typeNumber(card5, 4);
        typeNumber(card6, 5);
        do {
            switch (cardType[x]) {
                case 3:
                    if (x == 0) cardType1 = spade;
                    if (x == 1) cardType2 = spade;
                    if (x == 2) cardType3 = spade;
                    if (x == 3) cardType4 = spade;
                    if (x == 4) cardType5 = spade;
                    if (x == 5) cardType6 = spade;
                    break;
                case 2:
                    if (x == 0) cardType1 = heart;
                    if (x == 1) cardType2 = heart;
                    if (x == 2) cardType3 = heart;
                    if (x == 3) cardType4 = heart;
                    if (x == 4) cardType5 = heart;
                    if (x == 5) cardType6 = heart;
                    break;
                case 1:
                    if (x == 0) cardType1 = diamond;
                    if (x == 1) cardType2 = diamond;
                    if (x == 2) cardType3 = diamond;
                    if (x == 3) cardType4 = diamond;
                    if (x == 4) cardType5 = diamond;
                    if (x == 5) cardType6 = diamond;
                    break;
                case 0:
                    if (x == 0) cardType1 = clubs;
                    if (x == 1) cardType2 = clubs;
                    if (x == 2) cardType3 = clubs;
                    if (x == 3) cardType4 = clubs;
                    if (x == 4) cardType5 = clubs;
                    if (x == 5) cardType6 = clubs;
                    break;
            }
            x++;
        } while (x < 6);
        do {
            switch (cardNumber[y]) {
                case 13:
                    if (y == 0) cardNum1 = " A";
                    if (y == 1) cardNum2 = " A";
                    if (y == 2) cardNum3 = " A";
                    if (y == 3) cardNum4 = " A";
                    if (y == 4) cardNum5 = " A";
                    if (y == 5) cardNum6 = " A";
                    break;
                case 12:
                    if (y == 0) cardNum1 = " K";
                    if (y == 1) cardNum2 = " K";
                    if (y == 2) cardNum3 = " K";
                    if (y == 3) cardNum4 = " K";
                    if (y == 4) cardNum5 = " K";
                    if (y == 5) cardNum6 = " K";
                    break;
                case 11:
                    if (y == 0) cardNum1 = " Q";
                    if (y == 1) cardNum2 = " Q";
                    if (y == 2) cardNum3 = " Q";
                    if (y == 3) cardNum4 = " Q";
                    if (y == 4) cardNum5 = " Q";
                    if (y == 5) cardNum6 = " Q";
                    break;
                case 10:
                    if (y == 0) cardNum1 = " J";
                    if (y == 1) cardNum2 = " J";
                    if (y == 2) cardNum3 = " J";
                    if (y == 3) cardNum4 = " J";
                    if (y == 4) cardNum5 = " J";
                    if (y == 5) cardNum6 = " J";
                    break;
                case 9:
                    if (y == 0) cardNum1 = "10";
                    if (y == 1) cardNum2 = "10";
                    if (y == 2) cardNum3 = "10";
                    if (y == 3) cardNum4 = "10";
                    if (y == 4) cardNum5 = "10";
                    if (y == 5) cardNum6 = "10";
                    break;
                case 8:
                    if (y == 0) cardNum1 = " 9";
                    if (y == 1) cardNum2 = " 9";
                    if (y == 2) cardNum3 = " 9";
                    if (y == 3) cardNum4 = " 9";
                    if (y == 4) cardNum5 = " 9";
                    if (y == 5) cardNum6 = " 9";
                    break;
                case 7:
                    if (y == 0) cardNum1 = " 8";
                    if (y == 1) cardNum2 = " 8";
                    if (y == 2) cardNum3 = " 8";
                    if (y == 3) cardNum4 = " 8";
                    if (y == 4) cardNum5 = " 8";
                    if (y == 5) cardNum6 = " 8";
                    break;
                case 6:
                    if (y == 0) cardNum1 = " 7";
                    if (y == 1) cardNum2 = " 7";
                    if (y == 2) cardNum3 = " 7";
                    if (y == 3) cardNum4 = " 7";
                    if (y == 4) cardNum5 = " 7";
                    if (y == 5) cardNum6 = " 7";
                    break;
                case 5:
                    if (y == 0) cardNum1 = " 6";
                    if (y == 1) cardNum2 = " 6";
                    if (y == 2) cardNum3 = " 6";
                    if (y == 3) cardNum4 = " 6";
                    if (y == 4) cardNum5 = " 6";
                    if (y == 5) cardNum6 = " 6";
                    break;
                case 4:
                    if (y == 0) cardNum1 = " 5";
                    if (y == 1) cardNum2 = " 5";
                    if (y == 2) cardNum3 = " 5";
                    if (y == 3) cardNum4 = " 5";
                    if (y == 4) cardNum5 = " 5";
                    if (y == 5) cardNum6 = " 5";
                    break;
                case 3:
                    if (y == 0) cardNum1 = " 4";
                    if (y == 1) cardNum2 = " 4";
                    if (y == 2) cardNum3 = " 4";
                    if (y == 3) cardNum4 = " 4";
                    if (y == 4) cardNum5 = " 4";
                    if (y == 5) cardNum6 = " 4";
                    break;
                case 2:
                    if (y == 0) cardNum1 = " 3";
                    if (y == 1) cardNum2 = " 3";
                    if (y == 2) cardNum3 = " 3";
                    if (y == 3) cardNum4 = " 3";
                    if (y == 4) cardNum5 = " 3";
                    if (y == 5) cardNum6 = " 3";
                    break;
                case 1:
                    if (y == 0) cardNum1 = " 2";
                    if (y == 1) cardNum2 = " 2";
                    if (y == 2) cardNum3 = " 2";
                    if (y == 3) cardNum4 = " 2";
                    if (y == 4) cardNum5 = " 2";
                    if (y == 5) cardNum6 = " 2";
                    break;
            }
            y++;
        }
        while (y < 6);
    }
}

class GameLogic extends ToSymbol {


    private void display() {
        symbolizing();
        System.out.println(" _____\t _____ \t _____");
        System.out.println("|" + cardNum1 + "   |\t" + "|" + cardNum2 + "   |\t" + "|" + cardNum3 + "   " + "|");
        System.out.println("|     |\t|     |\t|     |    NAME");
        System.out.println("|  " + cardType1 + "  |\t" + "|  " + cardType2 + "  |\t" + "|  " + cardType3 + "  |");
        System.out.println("|     |\t|     |\t|     |");
        System.out.println("|_____|\t|_____|\t|_____|");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println(" _____\t _____ \t _____");
        System.out.println("|" + cardNum4 + "   |\t" + "|" + cardNum5 + "   |\t" + "|" + cardNum6 + "   " + "|");
        System.out.println("|     |\t|     |\t|     |    COMPUTER");
        System.out.println("|  " + cardType4 + "  |\t" + "|  " + cardType5 + "  |\t" + "|  " + cardType6 + "  |");
        System.out.println("|     |\t|     |\t|     |");
        System.out.println("|_____|\t|_____|\t|_____|");
        System.out.println("\n\n");
    }

    void check() {
        symbolizing();
        int amtPlayer = 10000, amtComputer = 10000, totalbet = 0;
        int maxCardPlayer = 0, maxCardComputer = 3;
        if (cardNumber[0] > cardType[maxCardPlayer]) maxCardPlayer = 0;
        if (cardNumber[0] == cardNumber[maxCardPlayer] && cardType[0] > cardType[maxCardPlayer]) maxCardPlayer = 0;
        if (cardNumber[1] > cardNumber[maxCardPlayer]) maxCardPlayer = 1;
        if (cardNumber[1] == cardNumber[maxCardPlayer] && cardType[1] > cardType[maxCardPlayer]) maxCardPlayer = 1;
        if (cardNumber[2] > cardNumber[maxCardPlayer]) maxCardPlayer = 2;
        if (cardNumber[2] == cardNumber[maxCardPlayer] && cardType[2] > cardType[maxCardPlayer]) maxCardPlayer = 2;
        if (cardNumber[3] > cardNumber[maxCardComputer]) maxCardComputer = 3;
        if (cardNumber[3] == cardNumber[maxCardComputer] && cardType[3] > cardType[maxCardComputer])
            maxCardComputer = 3;
        if (cardNumber[4] > cardNumber[maxCardComputer]) maxCardComputer = 4;
        if (cardNumber[4] == cardNumber[maxCardComputer] && cardType[4] > cardType[maxCardComputer])
            maxCardComputer = 4;
        if (cardNumber[5] > cardNumber[maxCardComputer]) maxCardComputer = 5;
        if (cardNumber[5] == cardNumber[maxCardComputer] && cardType[5] > cardType[maxCardComputer])
            maxCardComputer = 5;
        //same Number
        if (cardNumber[0] == cardNumber[1] && cardNumber[1] == cardNumber[2]) {
            if (cardNumber[3] == cardNumber[4] && cardNumber[4] == cardNumber[5]) {
                if (cardNumber[0] > cardNumber[3]) {
                    //     amtPlayer = amtPlayer + (totalbet * 2);
                    display();
                    System.out.println("Name wins SameNumber");
                } else {
                    //   amtComputer = amtComputer + (totalbet * 2);
                    display();
                    System.out.println("Computer wins SameNumber");
                }
            } else {
                //    amtPlayer = amtPlayer + (totalbet * 2);
                display();
                System.out.println("Name wins SameNumber");
            }
        } else if (cardNumber[3] == cardNumber[4] && cardNumber[4] == cardNumber[5]) {
            //   amtComputer = amtComputer + (totalbet * 2);
            display();
            System.out.println("Computer wins SameNumber");
        }
        ///same cardType ,number in sequence.
        else if ((cardType[0] == cardType[1] && cardType[1] == cardType[2]) && ((cardNumber[0] == cardNumber[1] + 1 && cardNumber[1] == cardNumber[2] + 1) || (cardNumber[0] == cardNumber[2] + 1 && cardNumber[2] == cardNumber[1] + 1) || (cardNumber[2] == cardNumber[0] + 1 && cardNumber[0] == cardNumber[1] + 1) || (cardNumber[1] == cardNumber[0] + 1 && cardNumber[0] == cardNumber[2] + 1) || (cardNumber[1] == cardNumber[2] + 1 && cardNumber[2] == cardNumber[0] + 1) || (cardNumber[2] == cardNumber[1] + 1 && cardNumber[1] == cardNumber[0] + 1))) {
            if ((cardType[3] == cardType[4] && cardType[4] == cardType[5]) && ((cardNumber[3] == cardNumber[4] + 1 && cardNumber[4] == cardNumber[5] + 1) || (cardNumber[3] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[4] + 1) || (cardNumber[5] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[4] + 1) || (cardNumber[4] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[5] + 1) || (cardNumber[4] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[3] + 1) || (cardNumber[5] == cardNumber[4] + 1 && cardNumber[4] == cardNumber[3] + 1))) {
                if (cardNumber[maxCardComputer] > cardNumber[maxCardPlayer]) {
                    //         amtComputer = amtComputer + (totalbet * 2);
                    display();
                    System.out.println("Computer wins SameType,Number in sequence");
                } else if (cardNumber[maxCardComputer] < cardNumber[maxCardPlayer]) {
                    //         amtPlayer = amtPlayer + (totalbet * 2);
                    display();
                    System.out.println("Name wins SameType,Number in sequence");
                } else if (cardNumber[maxCardComputer] == cardNumber[maxCardPlayer]) {
                    if (cardType[0] > cardType[3]) {
                        //             amtPlayer = amtPlayer + (totalbet * 2);
                        display();
                        System.out.println("Name wins SameType,Number in sequence");
                    } else {
                        //           amtComputer = amtComputer + (totalbet * 2);
                        display();
                        System.out.println("Computer wins SameType,Number in sequence");
                    }
                }
            } else {
                //        amtPlayer = amtPlayer + (totalbet * 2);
                display();
                System.out.println("Name wins SameType,Number in sequence");
            }
        } else if ((cardType[3] == cardType[4] && cardType[4] == cardType[5]) && ((cardNumber[3] == cardNumber[4] + 1 && cardNumber[4] == cardNumber[5] + 1) || (cardNumber[3] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[4] + 1) || (cardNumber[5] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[4] + 1) || (cardNumber[4] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[5] + 1) || (cardNumber[4] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[3] + 1) || (cardNumber[5] == cardNumber[4] + 1 && cardNumber[4] == cardNumber[3] + 1))) {
            //      amtComputer = amtComputer + (totalbet * 2);
            display();
            System.out.println("Computer wins SameType,Number in sequence");
        }
        ///sequence of number.
        else if ((cardNumber[0] == cardNumber[1] + 1 && cardNumber[1] == cardNumber[2] + 1) || (cardNumber[0] == cardNumber[2] + 1 && cardNumber[2] == cardNumber[1] + 1) || (cardNumber[2] == cardNumber[0] + 1 && cardNumber[0] == cardNumber[1] + 1) || (cardNumber[1] == cardNumber[0] + 1 && cardNumber[0] == cardNumber[2] + 1) || (cardNumber[1] == cardNumber[2] + 1 && cardNumber[2] == cardNumber[0] + 1) || (cardNumber[2] == cardNumber[1] + 1 && cardNumber[1] == cardNumber[0] + 1)) {
            if ((cardNumber[3] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[4] + 1) || (cardNumber[5] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[4] + 1) || (cardNumber[4] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[5] + 1) || (cardNumber[4] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[3] + 1) || (cardNumber[5] == cardNumber[4] + 1 && cardNumber[4] == cardNumber[3] + 1)) {
                if (cardNumber[maxCardComputer] > cardNumber[maxCardPlayer]) {
                    //            amtComputer = amtComputer + (totalbet * 2);
                    display();
                    System.out.println("Computer wins Number in sequence");
                } else if (cardNumber[maxCardComputer] < cardNumber[maxCardPlayer]) {
                    //          amtPlayer = amtPlayer + (totalbet * 2);
                    display();
                    System.out.println("Name wins Number in sequence");
                } else if (cardNumber[maxCardComputer] == cardNumber[maxCardPlayer]) {
                    if (cardType[maxCardPlayer] > cardType[maxCardComputer]) {
                        //            amtPlayer = amtPlayer + (totalbet * 2);
                        display();
                        System.out.println("Name wins Number in sequence");
                    } else {
                        //          amtComputer = amtComputer + (totalbet * 2);
                        display();
                        System.out.println("Computer wins Number in sequence");
                    }
                }
            } else {
                //            amtPlayer = amtPlayer + (totalbet * 2);
                display();
                System.out.println("Name wins Number in sequence");
            }
        } else if ((cardNumber[3] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[4] + 1) || (cardNumber[5] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[4] + 1) || (cardNumber[4] == cardNumber[3] + 1 && cardNumber[3] == cardNumber[5] + 1) || (cardNumber[4] == cardNumber[5] + 1 && cardNumber[5] == cardNumber[3] + 1) || (cardNumber[5] == cardNumber[4] + 1 && cardNumber[4] == cardNumber[3] + 1)) {
            //      amtComputer = amtComputer + (totalbet * 2);
            display();
            System.out.println("Computer wins Number in sequence");
        }
        ///all cards same cardType
        else if ((cardType[0] == cardType[1] && cardType[1] == cardType[2] && cardType[2] == cardType[3] && cardType[3] == cardType[4] && cardType[4] == cardType[5])) {
            if (cardNumber[maxCardComputer] > cardNumber[maxCardPlayer]) {
                //        amtComputer = amtComputer + (totalbet * 2);
                display();
                System.out.println("Computer wins ,all cards same type but computer has high card");
            } else {
                //      amtPlayer = amtPlayer + (totalbet * 2);
                display();
                System.out.println("Name wins ,all cards same type but Name has high card");
            }
        }
        ///same cardType
        else if (cardType[0] == cardType[1] && cardType[1] == cardType[2]) {
            if (cardType[3] == cardType[4] && cardType[4] == cardType[5]) {
                if (cardType[0] > cardType[3]) {
                    //        amtPlayer = amtPlayer + (totalbet * 2);
                    display();
                    System.out.println("Name wins ,both have all cards same respective type but Name has high card type");
                } else {
                    //      amtComputer = amtComputer + (totalbet * 2);
                    display();
                    System.out.println("Computer wins ,both have all cards same respective type but Computer has high card type");
                }
            } else {
                //             amtPlayer = amtPlayer + (totalbet * 2);
                display();
                System.out.println("Name wins ,same type of cards");
            }
        } else if (cardType[3] == cardType[4] && cardType[4] == cardType[5]) {
            //       amtComputer = amtComputer + (totalbet * 2);
            display();
            System.out.println("Computer wins ,same type of cards");
        }
        ///high card.
        else {
            if (cardNumber[maxCardComputer] > cardNumber[maxCardPlayer]) {
                //         amtComputer = amtComputer + (totalbet * 2);
                display();
                System.out.println("Computer wins ,high card");
            } else if (cardNumber[maxCardComputer] < cardNumber[maxCardPlayer]) {
                //       amtPlayer = amtPlayer + (totalbet * 2);
                display();
                System.out.println("Name wins ,high card");
            } else if (cardNumber[maxCardComputer] == cardNumber[maxCardPlayer]) {
                if (cardType[maxCardPlayer] > cardType[maxCardComputer]) {
                    //         amtPlayer = amtPlayer + (totalbet * 2);
                    display();
                    System.out.println("Name wins ,high card");
                } else {
                    //       amtComputer = amtComputer + (totalbet * 2);
                    display();
                    System.out.println("Computer wins ,high card");
                }
            }
        }
    }
}

class Game extends GameLogic {
    void play() {
        check();
    }
}

public class TeenPatti extends Game {
    public static void main(String[] args) {
        Game g = new Game();
        start = System.currentTimeMillis();
        g.play();
        end = System.currentTimeMillis();
        System.out.println("start :" + start + " end :" + end + " time taken : " + (end - start));
    }
}

