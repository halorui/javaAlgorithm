import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] dp = new int[row][col];
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                dp[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i][0] + Math.max(dp[i - 1][0],dp[i - 1][1]);
            for (int j = 1; j < col - 1; j++) {
                dp[i][j] = dp[i][j] + Math.max(Math.max(dp[i - 1][j - 1],dp[i - 1][j]),dp[i - 1][j + 1]);
            }
            dp[i][col - 1] = dp[i][col - 1] + Math.max(dp[i - 1][col - 1],dp[i - 1][col - 2]);
        }
        System.out.println("结果为:" + Math.max(Math.max(dp[row - 1][col / 2 - 1],dp[row - 1][col / 2]),dp[row - 1][col / 2 + 1]));
    }
}

