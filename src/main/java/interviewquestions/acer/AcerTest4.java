package interviewquestions.acer;

public class AcerTest4 {

    public static int getLargestProduct(int[] array) {
        int largestProduct = array[0];
        for (int i = 0; i < array.length; i++) {
            int product = array[i];
            for (int j = i + 1; j < array.length; j++) {
                product *= array[j];
                largestProduct = Math.max(largestProduct, product);
            }
        }
        return largestProduct;
    }

    public static void main(String[] args) {
        int[] arr = {7, -4, 0, 2, 3, 2, -6};
        System.out.println(getLargestProduct(arr));
    }
}
