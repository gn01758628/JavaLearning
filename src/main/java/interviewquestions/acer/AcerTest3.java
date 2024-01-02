package interviewquestions.acer;

import java.util.Scanner;

public class AcerTest3 {
    public static void printSomething(int n) {
        if (n <= 0) System.out.println("n must be greater than 0");
        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder(String.format("(%d). ", i));
            int num = (int) Math.pow(2, i - 1);
            for (int j = 1; j <= i; j++) {
                if (j != i) {
                    builder.append(num).append("+");
                } else {
                    builder.append(num).append("=").append(num * j);
                }
            }
            System.out.println(builder);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("請輸入一個正整數n：");
            n = scanner.nextInt();
            printSomething(n);

        } while (n <= 0);
        scanner.close();
    }
}
