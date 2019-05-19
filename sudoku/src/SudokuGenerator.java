import java.util.Random;

public class SudokuGenerator {
    private char[][] board = new char[9][9];
    private int[] randomizeSudoku = new int[9];
    private char[][] transposedSeed = new char[][]{{'8', '2', '7', '1', '5', '4', '3', '9', '6'},
            {'9', '6', '5', '3', '2', '7', '1', '4', '8'},
            {'3', '4', '1', '6', '8', '9', '7', '5', '2'},
            {'5', '9', '3', '4', '6', '8', '2', '7', '1'},
            {'4', '7', '2', '5', '1', '3', '6', '8', '9'},
            {'6', '1', '8', '9', '7', '2', '4', '3', '5'},
            {'7', '8', '6', '2', '3', '5', '9', '1', '4'},
            {'1', '5', '4', '7', '9', '6', '8', '2', '3'},
            {'2', '3', '9', '8', '4', '1', '5', '6', '7'},};
    private char[][] seed = new char[9][9];
    private Random random = new Random();

    private SudokuGenerator() {
        this.transpose();
        this.shuffle();
        this.seedChanger();
    }

    public static void main(String[] args) {
        SudokuGenerator s = new SudokuGenerator();
        s.generate();
    }

    private void generate() {
        System.out.println("\n\n------ New Board --------\n");
        for (int i = 0; i < random.nextInt(5); i++) {
            this.transpose();
            this.shuffle();
            this.seedChanger();
        }
        this.display();
    }

    private void transpose() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                seed[j][i] = transposedSeed[i][j];
            }
        }
    }

    private void seedChanger() {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board[i], 0, transposedSeed[i], 0, board.length);
        }
    }

    private void randomSudokuGenerator() {
        for (int i = 0; i < randomizeSudoku.length; i++) {
            randomizeSudoku[i] = 9;
        }
        for (int i = 0; i < randomizeSudoku.length; ++i) {
            int r = random.nextInt(2);
            for (int i1 = 0; i1 < i; ++i1) {
                int x = randomizeSudoku[i1];
                if (x == r) {
                    if (i < 3) {
                        r = random.nextInt(3);
                    } else if (i < 6) {
                        r = random.nextInt(3) + 3;
                    } else if (i < 9) {
                        r = random.nextInt(3) + 6;
                    }
                    i1 = -1;
                }
            }
            randomizeSudoku[i] = r;
        }
    }

    private void shuffle() {
        randomSudokuGenerator();
        for (int x = 0; x < 9; x++) {
            for (int i = 0; i < 9; i++) {
                board[i][x] = seed[randomizeSudoku[i]][x];
            }
        }
        for (int x = 0; x < 9; x++) {
            if (randomizeSudoku[0] == 0) swapping(board, x, 1, 0);
            if (randomizeSudoku[0] == 1) swapping(board, x, 2, 0);
            if (randomizeSudoku[0] == 0) swapping(board, x, 5, 4);
            if (randomizeSudoku[0] == 1) swapping(board, x, 5, 3);
            if (randomizeSudoku[0] == 2) swapping(board, x, 8, 6);
        }
    }

    private void swapping(char[][] a, int commonIndex, int first, int second) {
        char swap = a[commonIndex][first];
        a[commonIndex][first] = a[commonIndex][second];
        board[commonIndex][second] = swap;
    }

    private void display() {
        int i, j;
        for (i = 0; i < 9; ++i) {
            if (i == 0) {
                System.out.print("\t\t\t_______________________________________\n\t row " + (i + 1) + "\t");
            } else {
                System.out.print("\t\t\t|---|---|---||---|---|---||---|---|---|\n\t row " + (i + 1) + "\t");
            }
            for (j = 0; j < 9; ++j) {
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
                System.out.println("\tcolumns   1   2   3    4   5   6    7   8   9  \n\n\n");
            }
        }
    }
}
