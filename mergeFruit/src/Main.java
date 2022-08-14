import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入数组大小:");
        int len = scanner.nextInt();
        int inArr[] = new int[len];
        System.out.print("输入数组:");
        for (int i = 0;i < len;i++) {
            inArr[i] = scanner.nextInt();
        }//输入数组
        quickSort(inArr,0, inArr.length - 1);  //进行排序
        int index = 0;  //定义起始下标
        int res = 0;  //定义结果
        for (;index < inArr.length - 1;index++) {
            res += inArr[index] + inArr[index + 1];
            inArr[index + 1] = inArr[index] + inArr[index + 1];
            inArr[index] = 0;
            for (int i = index + 2; i < inArr.length; ++i) {  //冒泡排序，维持数组顺序
                if (inArr[i] > inArr[i - 1]) {
                    break;
                }
                int temp = inArr[i];
                inArr[i] = inArr[i - 1];
                inArr[i - 1] = temp;
            }
        }
        System.out.println("结果为:" + res);  //输出结果
    }
    public static void quickSort(int ints[],int left,int right) {
        if (left < right) {
            int partitionIndex = partition(ints,left,right);
            quickSort(ints,left,partitionIndex - 1);
            quickSort(ints,partitionIndex + 1,right);
        }
    }

    public static int partition(int ints[],int left,int right) {
        int p = left + 1;
        for (int i = p; i <= right; ++i) {
            if (ints[i] < ints[left]) {
                int temp = ints[i];
                ints[i] = ints[p];
                ints[p] = temp;
                p++;
            }
        }
        int temp = ints[left];
        ints[left] = ints[p - 1];
        ints[p - 1] = temp;
        return p - 1;
    }
}
