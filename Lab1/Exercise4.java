package Lab1;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the triangle please : ");
        int sz = scanner.nextInt();
        for (int i = 0; i < sz; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++)
                System.out.print("* ");
        }
        System.out.println();
    }
}
