public class JavaProgramm2 {
    public static void main(String[] args) {
        Integer number = 122;
        int finalNumber = 1111;
        do {
            String s = number.toString();
            int start = 0, end, mid, i;
            char[] data;
            data = s.toCharArray();
            end = data.length;
            --end;
            mid = (end % 2 == 0) ? (end / 2) : (end + 1) / 2;
            for (i = 0; i <= mid; ++i) {
                if (i == mid) {
                    System.out.println(number);
                }
                if (data[i] == data[end - i]) {
                    continue;
                } else {
                    break;
                }
            }
            number++;
        } while (number < finalNumber);
    }
}