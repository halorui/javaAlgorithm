import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入模拟次数:");
        long count = scanner.nextLong();
        System.out.print("请输入获胜机制(一局制为0，三局两胜制为1):");
        int flag = scanner.nextInt();
        if (count < 1 || flag > 1 || flag < 0) {
            System.out.println("错误输入！");
            return;
        } //错误输入判断
        System.out.print("徐林老师获胜的概率为:" + badminton(count,flag));
    }

    public static double badminton(long count,int flag) {
        double p = 0.6;  // 徐林老师每一局获胜的概率
        int a = 0, b = 0, sum = 0;
        //a为徐林老师一局的分数，b为我一局的分数，sum为徐林老师获胜的次数
        int t = 0;
        if (flag == 1) {
            while (t < count) {
                int tempSum = 0; //一小局获胜次数
                for (int i = 0;i < 3;i++) {
                    a = b = 0;
                    while (a <= 21 && b <= 21) {
                        if (Math.random() < p) {
                            a += 1;
                        } else {
                            b += 1;
                        }
                    }
                    if (a > b) {
                        tempSum += 1;
                    }
                }
                if (tempSum >= 2) {
                    sum += 1; //获胜次数
                }
                t += 1;
            }
        } else {
            while (t < count) {
                a = b = 0;
                while (a <= 21 && b <= 21) {
                    if (Math.random() < p) {
                        a += 1;
                    } else {
                        b += 1;
                    }
                }
                if (a > b) {
                    sum += 1; //获胜次数
                }
                t += 1;
            }
        }
        return (double) sum / count;
    }
}
