public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] dp = {
            {13,0,0,0,0},
            {11,8,0,0,0},
            {12,7,26,0,0},
            {6,14,15,8,0},
            {12,7,13,24,11}
        };
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] + dp[i + 1][j] > dp[i][j] + dp[i + 1][j + 1]) {
                    dp[i][j] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j] + dp[i + 1][j + 1];
                }
            }
        }
        System.out.println("最大值为:" + dp[0][0]);
    }
}
