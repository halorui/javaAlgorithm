import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入台阶级数:");
        int n = scanner.nextInt();
        if (n < 3) { //判断台阶级数是否大于3
            System.out.println("一共有" + n + "种跳法");
            return;
        }
        System.out.println("一共有" + frogJump(n) + "种跳法");
    }
    public static int frogJump(int n) {
        int[] dp = new int[n];
        dp[0] = 1; //赋予初始台阶跳法次数
        dp[1] = 2; //赋予初始台阶跳法次数
        for (int i = 2; i < n; i++)
        {
            dp[i] = dp[i - 2] + dp[i - 1];
            //将上级与再上一级的台阶跳法次数现加得到当前台阶跳法次数
        }
        return dp[n - 1];
    }
}

