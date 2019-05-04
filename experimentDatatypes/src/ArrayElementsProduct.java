import java.util.Arrays;

public class ArrayElementsProduct {
    private int[] originalArray = {3, 1, 2, 1, 4};
    private int[] productsArray = {1, 1, 1, 1, 1};
    private int j = 0; // j is used to recursion the method product() only uptill the last element in productArray


    public static void main(String[] args) {
        new ArrayElementsProduct().product();//created an anonymous object of ArrayElementsProduct and calling method product() through it.
    }

    private void product() {
        for (int i = 0; i < originalArray.length; i++) {
            if (j != i) {
                productsArray[j] *= originalArray[i];//multiplying the originalArray elements and storing them in productArray
            }
        }
        j++;
        if (j < productsArray.length) {
            product();  //recursing the method product
        } else {
            System.out.println(Arrays.toString(productsArray));
        }
    }
}
