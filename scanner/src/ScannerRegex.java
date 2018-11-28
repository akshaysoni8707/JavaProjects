import java.util.Arrays;
import java.util.Scanner;

public class ScannerRegex {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str;
        str = s.nextLine();
        System.out.println(str.matches("[a-e][1-8]\\b\\sto\\s\\b[a-e][1-8]"));
        //Create scanner with the specified String Object
        s.close();
        if (str.matches("[a-e][1-8]\\b\\sto\\s\\b[a-e][1-8]")) {
            String data[] = str.split(" to ");
            System.out.println(Arrays.toString(data));
            System.out.println(getIndexOfCol(data[0].charAt(0)) + " -- " + data[0].charAt(1));
            System.out.println(data[1].charAt(0) + " -- " + (data[1].charAt(1) - 49));
        }
    }

    private static int getIndexOfCol(char c) {
        switch (c) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            default:
                return -1;
        }
    }
}

