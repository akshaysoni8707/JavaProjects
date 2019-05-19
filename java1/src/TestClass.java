import java.util.Scanner;

class TestClass {
    //    static double ts(double l, double r)
//    {
//        for(int i=0; i<58; i++) {
//            double l1 = (l*2+r)/3;
//            double l2 = (l+2*r)/3;
//            if((2*l2*l2-12*l2) > (2*l1*l1-12*l1)) r = l2; else l = l1;
//        }
//        return (2*l*l-12*l+7);
//    }
//   c
//
//        Scanner s = new Scanner(System.in);
//        long n = s.nextLong();
//        for (int i = 0; i < n ; i++) {
//            System.out.println(Math.round(ts(s.nextDouble(),s.nextDouble())));
//        }
//    }
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {

            A[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(A));
        int temp, counter = 0;
        for (int k = 0; k < n - 1; k++) {
            // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
            for (int i = 0; i < n - k - 1; i++) {
                if (A[i] > A[i + 1]) {
                    // here swapping of positions is being done.
                    counter++;
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
        System.out.println(counter);
    }
}