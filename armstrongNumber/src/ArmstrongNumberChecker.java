public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        int number = 370;
        int sum = 0;
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
    }
}
