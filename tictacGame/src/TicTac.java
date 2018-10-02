import java.util.Random;

public class TicTac {
    private char board[] = new char[9];
    private char turn = 'O';
    private Random random = new Random();

    public static void main(String[] args) {
        TicTac t = new TicTac();
        t.initializeBoard();
        System.out.println(t.turn);
        t.play();
    }

    private void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    private void switchPlayer() {
        if (turn == 'X') {
            turn = 'O';
        } else if (turn == 'O') {
            turn = 'X';
        }
    }

    private boolean win() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = turn;
                if (checkWin()) {
                    return true;
                } else {
                    board[i] = ' ';
                }
            }
        }
        return false;
    }

    private void attack() {
        boolean check = false;
        do {
            int r = random.nextInt(9);
            if (r == 1 || r == 3 || r == 5 || r == 7 || r != 4) {
                r = random.nextInt(9);
                //     System.out.println(r);
            }
            if (board[r] == ' ') {
                board[r] = turn;
                check = true;
            }
        } while (!check);
    }

    private boolean defence() {
        switchPlayer();
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = turn;
                if (checkWin()) {
                    switchPlayer();
                    board[i] = turn;
                    return true;
                } else {
                    board[i] = ' ';
                }
            }
        }
        switchPlayer();
        return false;
    }

    private boolean filled() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    private void play() {
        do {
            if (win()) {
                switchPlayer();
            } else if (defence()) {
                switchPlayer();
            } else {
                attack();
                switchPlayer();
            }
            display();
            System.out.println("\n");
        } while (!filled() && !checkWin());
        if (checkWin()) {
            switchPlayer();
            System.out.println("  CPU vs CPU : CPU playing with ' " + turn + " ' has won");
        } else {
            System.out.println("  CPU vs CPU : game is draw... ");
        }
    }

    private boolean checkWin() {
        return (board[0] == board[1] && board[1] == board[2] && board[0] != ' ' || board[3] == board[4] && board[4] == board[5] && board[3] != ' ' || board[6] == board[7] && board[7] == board[8] && board[6] != ' ' || board[0] == board[4] && board[4] == board[8] && board[0] != ' ' || board[2] == board[4] && board[4] == board[6] && board[2] != ' ' || board[0] == board[3] && board[3] == board[6] && board[0] != ' ' || board[1] == board[4] && board[4] == board[7] && board[1] != ' ' || board[2] == board[5] && board[5] == board[8] && board[2] != ' ');
    }

    private void display() {

        System.out.println("     " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("    ---|---|---");
        System.out.println("     " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("    ---|---|---");
        System.out.println("     " + board[6] + " | " + board[7] + " | " + board[8]);
    }
}
