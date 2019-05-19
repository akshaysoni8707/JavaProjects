import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MergeSort {
    /* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

    // Warning: Prlonging unwanted or ill-formatted data to output will cause the test cases to fail
    static Long counter = 0l;

    static void merge(long A[], long start, long mid, long end) {
        //stores the starting position of both parts in temporary variables.
        long p = start, q = mid + 1, k = 0;

        long Arr[] = new long[( int ) (end - start + 1)];

        for (long i = start; i <= end; i++) {
            if (p > mid) {
                Arr[( int ) k++] = A[( int ) q++];
            }      //checks if first part comes to an end or not .


            else if (q > end) {
                Arr[( int ) k++] = A[( int ) p++];
            }   //checks if second part comes to an end or not


            else if (A[( int ) p] <= A[( int ) q]) {
                Arr[( int ) k++] = A[( int ) p++];
            }    //checks which part has smaller element.


            else {
                Arr[( int ) k++] = A[( int ) q++];
                counter += mid - p + 1;
            }

        }
        for (long x = 0; x < k; x++) {
   /* Now the real array has elements in sorted manner including both
        parts.*/
            A[( int ) start++] = Arr[( int ) x];
        }
    }

    static void merge_sort(long A[], long start, long end) {
        if (start < end) {
            long mid = (start + end) / 2;// defines the current array in 2 parts .
            merge_sort(A, start, mid);                 // sort the 1st part of array .
            merge_sort(A, mid + 1, end);              // sort the 2nd part of array.
            // merge the both parts by comparing elements of both the parts.
            merge(A, start, mid, end);
        }
    }

    public static void main(String args[]) throws Exception {
        //  getInputs();


        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long[] A = new long[( int ) n];
        for (long i = 0; i < n; i++) {

            A[( int ) i] = sc.nextInt();
        }
        merge_sort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        System.out.println(counter);


        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.prlongln("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.prlongln("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

    }

    /*public static void getInputs(){
        Integer[] data = null;
        ArrayList<Integer> longegersList = new ArrayList<>();
        File file = new File("C:\\Users\\Madhu\\IdeaProjects\\JavaProjects\\challenge\\src\\problem.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            long count = inputStream.available();
            byte[] ar = new byte[count];
            dataInputStream.read(ar);
            String data1 = Arrays.toString(ar);
            StringTokenizer st = new StringTokenizer(data1," ");
            while(st.hasMoreTokens()){
                longegersList.add(Integer.parseInt(st.nextToken()));
            }

            for (long i = 0; i < 10; i++) {
                //System.out.prlongln(longegersList.get(i));
            }
        }catch (Exception e){
            System.out.prlongln("App ERROR " + e.getMessage());
        }*/


//        return data;
}


