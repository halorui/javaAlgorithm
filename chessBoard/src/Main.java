import java.util.Scanner;

public class Main {
    private static int tile = 1;
        public static void main(String[] args) {
            int x,y,size;
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入棋盘规模：");
            size = scanner.nextInt();
            System.out.print("输入特定方格横坐标：");
            x = scanner.nextInt();
            System.out.print("输入特定方格纵坐标：");
            y = scanner.nextInt();
            if (size % 2 != 0 || x >= size || y >= size) { //错误输入判断
                System.out.println("错误的输入数!");
                return;
            }
            int[][] board = new int[size][size];
            chessBoard(size, x, y, 0,0, board);
            //打印输出结果
            for (int i = size - 1;i >= 0;i--) {
                for (int j = 0;j < size;j++) {
                    System.out.print(" " + board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void chessBoard(int size, int x, int y, int bx, int by, int[][] board) { //规定bx,by始终为左下角方格
        if (size == 1) {  //结束递归条件
            return;
        }
        int t = tile++;  //L型骨牌号
        size = size / 2;  //分割棋盘
        //覆盖左上角棋盘
        if (x < bx + size && y >= by + size) {
            chessBoard(size, x, y, bx,by + size, board);  //特殊方格在此棋盘中
        }else {  //特殊方格不在此棋盘中
            board[by + size][bx + size - 1] = t;  //用t号L型骨牌覆盖右下角
            chessBoard(size, bx + size - 1 ,by + size, bx, by + size, board);  //覆盖其余方格
        }
        //覆盖右上角棋盘
        if (x >= bx + size && y >= by + size) {
            chessBoard(size, x, y, bx + size,by + size, board);
        }else {
            board[by + size][bx + size] = t;  //用t号L型骨牌覆盖左下角
            chessBoard(size, bx + size, by + size, bx + size,by + size, board);
        }
        //覆盖左下角棋盘
        if (x < bx + size && y < by + size) {
            chessBoard(size, x, y, bx , by, board);
        }else {
            board[by + size - 1][bx + size - 1] = t;  //用t号L型骨牌覆盖右上角
            chessBoard(size, bx + size - 1, by + size - 1, bx, by, board);
        }
        //覆盖右下角棋盘
        if (x >= bx + size && y < by + size) {
            chessBoard(size, x ,y, bx + size, by, board);
        }else {
            board[by + size - 1][bx + size] = t;  //用t号L型骨牌覆盖左上角
            chessBoard(size, bx + size ,by + size - 1, bx + size, by, board);
        }
    }
}

