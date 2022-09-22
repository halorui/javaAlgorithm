import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个字符串:");
        String text1 = scanner.next();
        System.out.print("请输入第二个字符串:");
        String text2 = scanner.next();
        System.out.println("两个字符串的最长公共子序列长度为:" + longestCommonSubsequence(text1,text2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1;i <= len1;i++) {
            for (int j = 1;j <= len2;j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
