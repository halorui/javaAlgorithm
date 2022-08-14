import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入模拟次数:");
        int n = scanner.nextInt();
        int k = 0;
        for (int i = 0;i <= n;i++) {
            double x = Math.random();
            double y = Math.random();
            if ((x * x + y * y) < 1) {
                k++;
            }
        }
        System.out.println(4 * k / (double)n);
    }
}
