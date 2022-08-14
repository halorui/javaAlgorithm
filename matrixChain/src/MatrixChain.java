import java.util.Scanner;

public class MatrixChain {
    public static void main(String[] args) {
        MatrixChain mc = new MatrixChain();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入矩阵乘积个数:");
        int n = scanner.nextInt();
        int[] p = new int[n];
        System.out.print("请输入矩阵乘积:");
        for (int i = 0;i < n;i++) {
            p[i] = scanner.nextInt();
        }
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];
        mc.matrixChain(p, m, s);
        System.out.println("m[i][j]");
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("s[i][j]");
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(s[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("乘法的最优次序：");
        mc.traceback(s, 1, 4);
        System.out.println("结果为:" + m[1][m.length - 1]);
    }

    public void matrixChain(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public void traceback(int[][] s, int i, int j) {
        if (i == j) {
            return;
        }
        traceback(s, i, s[i][j]);
        traceback(s, s[i][j] + 1, j);
        System.out.println("A" + i + "," + s[i][j] + "and A"
                + (s[i][j] + 1) + "," + j);
    }
}
