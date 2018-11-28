import java.time.YearMonth;
import java.util.Arrays;

class Experiments {
    static int add(int a, int b) {
        return a + b;
    }

    static char add(long a, long b) {
        return ( char ) (a + b);
    }

    static int add(long a, int b) {
        return Math.toIntExact(a * b);
    }

    public static void main(String[] args) {
        Integer a = 100;
        System.out.println(a.toString() + 313333);
        String b = "102aBc";
        int x = b.hashCode();
        System.out.println(x);
        System.out.println(b);
        System.out.println(Arrays.toString(b.split(String.valueOf(2), 5)));
        System.out.println(Arrays.toString(b.split(String.valueOf(3))));
        System.out.println(b.intern());
        System.out.println(a.floatValue());
        int c = 'a';
        System.out.println(c);

        Integer[] ab = {12, 3, 4, 6, 4, 9, 8, 7, 9, 6, 3, 1};
        int[] abc = {1, 5, 3, 9, 4, 3, 55};
        System.out.println(ab[6]);
        System.out.println(Arrays.toString(ab));
        // Arrays.sort(abc);
        // System.out.println(Arrays.toString(abc));
        Arrays.sort(abc, 0, 3);
        System.out.println(Arrays.toString(abc));
        System.out.println(abc[1]);
        System.out.println(a.equals(100));
        System.err.println("\u2660");
        for (int i1 : abc) {
            System.out.println(i1);
        }
        System.out.println(abc[abc.length - 1]);
        System.out.println(Experiments.add(1L, 13));
        System.out.println(Experiments.add(2, 4));
        System.out.println(Experiments.add(122222222L, 548624865L));
        System.out.println(Experiments.add('a', 'b'));
        System.out.println(Experiments.add('m', 'n'));
        System.out.println(YearMonth.now().atDay(23));

    }
}
