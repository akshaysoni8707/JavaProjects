import java.util.Scanner;

public class Board {
    final int height = 10;
    final int width = 20;
    String board[][] = new String[height][width];

    public static void main(String[] args) {
        Board b = new Board();
        b.init();
        b.displayBoard();
    }

    void init() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = " ";
            }
            System.out.println();
        }
    }

    void displayBoard() {
        Scanner sc = new Scanner(System.in);

        try {
            sc.next();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < (width); i++) {
            if (i == 0) {
                System.out.print(" ");
            }
            System.out.print("/");
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }
        for (int i = 0; i < (width); i++) {
            if (i == 0) {
                System.out.print(" ");
            }
            System.out.print("\\");
        }
        System.out.println();
    }
}
