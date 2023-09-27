import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int in = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (distance(a, b) <= 1000.0) {
                in++;
            }
        }
        System.out.printf("%.6f", (double) (4.0 * in / n));
    }

    public static double distance(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }
}
