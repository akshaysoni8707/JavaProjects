import java.util.Scanner;

public class ArmstrongNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber;
        int lastNumber;
        int sum = 0;
        try {
            System.out.println("\nYou will haveto enter initial and final number between which all the armstrong numbers you want to generate\n");
            System.out.println("\nEnter the initial number\n");
            firstNumber = scanner.nextInt();
            System.out.println("\nEnter the final number\n");
            lastNumber = scanner.nextInt();
            do {
                String s = Integer.toString(firstNumber);
                char[] c = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    sum = ( int ) (sum + Math.pow((c[i] - 48), 3));
                }

                if (sum == firstNumber) {
                    System.out.println("Number " + firstNumber + " is Armstrong");
                }
                ++firstNumber;

                sum = 0;
            } while (firstNumber < lastNumber);
        } catch (Exception e) {
            System.out.println("invalid data");
        }

    }
}