import java.util.Scanner;
public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        int number;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nEnter the number to check if it is armstrong number\n");
            number = scanner.nextInt();
            String s = Integer.toString(number);
            char[] c = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                sum = ( int ) (sum + Math.pow((c[i] - 48), 3));
            }
            if (sum == number) {
                System.out.println("Number " + number + " is Armstrong");
            } else {
                System.out.println("Number " + number + " is not Armstrong");
            }
        } catch (Exception e) {
            System.out.println("Invalid data");
        }
    }
}
