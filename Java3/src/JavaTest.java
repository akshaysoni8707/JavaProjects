public class JavaTest {
    public static void main(String[] args) {
        String number = "akka";
        int start = 0, end, mid, i;
        char data[] = number.toCharArray();
        end = data.length;
        --end;
        mid = (end % 2 == 0) ? (end / 2) : (end + 1) / 2;
        for (i = 0; i <= mid; ++i) {
            if (i == mid) {
                System.out.println(number + " is palindrome");
            }
            if (data[i] == data[end - i]) {
                continue;
            } else {
                System.out.println(number + " is not palindrome");
                break;
            }
        }
    }
}
