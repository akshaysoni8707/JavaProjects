public class SudokuGenerator {
    private char board[][] = new char[9][9];
    //   private int[] randomizeSudoku = new int[9];
    private char seed[][] = new char[][]{{'1', '2', '3', '4', '5', '6', '7', '8', '9'},
            {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
            {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
            {'2', '3', '1', '5', '6', '4', '8', '9', '7'},
            {'5', '6', '4', '8', '9', '7', '2', '3', '1'},
            {'8', '9', '7', '2', '3', '1', '5', '6', '4'},
            {'3', '1', '2', '6', '4', '5', '9', '7', '8'},
            {'6', '4', '5', '9', '7', '8', '3', '1', '2'},
            {'9', '7', '8', '3', '1', '2', '6', '4', '5'},
    };

    public static void main(String[] args) {
        SudokuGenerator s = new SudokuGenerator();
        s.shuffle();
        s.display();
    }

    private void shuffle() {
        for (int x = 0; x < 9; x++) {
            board[0][x] = seed[1][x];
            board[1][x] = seed[0][x];
            board[2][x] = seed[2][x];
            board[3][x] = seed[3][x];
            board[4][x] = seed[5][x];
            board[5][x] = seed[4][x];
            board[6][x] = seed[8][x];
            board[7][x] = seed[6][x];
            board[8][x] = seed[7][x];
        }
        for (int x = 0; x < 9; x++) {
            swapping(board, x, 1, 0);
            swapping(board, x, 2, 0);
            swapping(board, x, 5, 4);
            swapping(board, x, 5, 3);
            swapping(board, x, 8, 6);
        }
    }

    private void swapping(char a[][], int commonIndex, int first, int second) {
        char swap = a[commonIndex][first];
        a[commonIndex][first] = a[commonIndex][second];
        board[commonIndex][second] = swap;
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
                System.out.println("\tcolumns   1   2   3    4   5   6    7   8   9  \n\n\n");
            }
        }
    }
}
