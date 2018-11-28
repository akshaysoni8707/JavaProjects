import java.util.Arrays;
import java.util.Random;

public class sudoku {
    private char board[][] = new char[9][9];
    private int randomSudokuNumbers[] = new int[9];
    private Random random = new Random();

    public static void main(String[] args) {
        sudoku a = new sudoku();
        a.setBoard();
        a.display();
    }

    private boolean checkWrong() {
        int z;
        for (z = 0; z < 9; z++) {
            for (int y = 0; y < 9; y++) {
                for (int x = 1; x < 9; x++) {
                    if (y == x) {
                        continue;
                    }
                    if (board[y][z] == board[x][z] && board[x][z] != ' ') {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private void initialBoard() {
        for (int u = 0; u < 9; u++) {
            for (int v = 0; v < 9; v++) {
                board[u][v] = ' ';
            }
        }
    }

    private void setBoard() {
        initialBoard();
        for (int k = 0; k < 9; ++k) {
            randomSudokuGenerator();
            System.out.println(Arrays.toString(randomSudokuNumbers) + "  " + k);
            for (int l = 0; l < 9; l++) {
                board[k][l] = ( char ) (randomSudokuNumbers[l] + 48);
                if (k == 0) {
                    board[k][l] = ( char ) (randomSudokuNumbers[l] + 48);
                } else {
                    if (checkWrong()) {
                        board[k][l] = ( char ) (randomSudokuNumbers[l] + 48);
                    } else {
                        --k;
                        break;
                    }
                }
            }
        }
    }

    private void randomSudokuGenerator() {
        int i = 0;
        for (; i < randomSudokuNumbers.length; ++i) {
            int r = random.nextInt(9) + 1;
            for (int i1 = 0; i1 < i; ++i1) {
                int x = randomSudokuNumbers[i1];
                if (x == r) {
                    r = random.nextInt(9) + 1;
                    i1 = -1;
                }
            }
            randomSudokuNumbers[i] = r;
        }
    }

    private void display() {
        int i, j;
        for (i = 0; i <= 8; ++i) {
            if (i == 0) {
                System.out.print("\t\t\t_______________________________________\n\t row " + (i + 1) + "\t");
            } else {
                System.out.print("\t\t\t|---|---|---||---|---|---||---|---|---|\n\t row " + (i + 1) + "\t");
            }
            for (j = 0; j <= 8; ++j) {
                if (j == 3) {
                    System.out.print("|");
                }
                if (j == 6) {
                    System.out.print("|");
                }
                if (j == 8) {
                    System.out.println("| " + board[i][j] + " |");
                } else {
                    System.out.print("| " + board[i][j] + " ");
                }
            }
            if (i == 2) {
                System.out.println("\t\t\t|---|---|---||---|---|---||---|---|---|");
            }
            if (i == 5) {
                System.out.println("\t\t\t|---|---|---||---|---|---||---|---|---|");
            }
            if (i == 8) {
                System.out.println("\t\t\t---------------------------------------");
                System.out.println("\t\tcolumns   1   2   3    4   5   6    7   8   9  \n\n\n");
            }
        }
    }
}
