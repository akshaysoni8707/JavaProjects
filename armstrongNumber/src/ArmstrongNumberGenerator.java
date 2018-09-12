import java.util.Random;

public class ArmstrongNumberGenerator {
    public static void main(String[] args) {
        /*Random random = new Random();

        Integer number = random.nextInt(500)+1;
        int lastNumber = random.nextInt(500)+1;
        if(lastNumber<number){
            int temp = number;
            number = lastNumber;
            lastNumber = temp;
        }*/
        Integer number = 1;
        int lastNumber = 1000;
        int sum = 0;
        do {
            String s = number.toString();
            char[] c = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                sum = ( int ) (sum + Math.pow((c[i] - 48), 3));
            }

            if (sum == number) {
                System.out.println("Number " + number + " is Armstrong");
            }
            ++number;

            sum = 0;
        } while (number < lastNumber);
    }
}