package Lab1;

public class Exercise5 {

    static int sumArray(int[] arr) {
        int sum = 0;
        for (int ele : arr)
            sum += ele;
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 9, 0};
        System.out.println(sumArray(arr));
    }
}
