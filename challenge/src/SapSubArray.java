import java.util.ArrayList;
import java.util.Scanner;

public class SapSubArray {
    public static Long counter = 0L;

    public static void MillyAndSpecial(Long arr[]) {
        counter = 0L;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].equals(arr[i])) {
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                    counter++;
                } else {
                    break;
                }
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        Long max, min;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len;
        ArrayList<Long> Array = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            len = scanner.nextInt();
            for (int j = 0; j < len; j++) {
                Array.add(scanner.nextLong());
            }
            Long[] arr = new Long[Array.size()];
            MillyAndSpecial(Array.toArray(arr));
            Array.clear();
        }
    }
}
