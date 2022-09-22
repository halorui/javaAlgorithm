import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度:");
        int len = scanner.nextInt();
        int[] arr = new int[len];
        System.out.print("请输入待排列数组:");
        for (int i = 0;i < len;i++) {
            arr[i] = scanner.nextInt();
        }
        //程序开始记录时间
        long startTime = System.currentTimeMillis();
        quickSort(arr,0,arr.length - 1);
        System.out.println("最终结果:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        //程序结束记录时间
        long endTime = System.currentTimeMillis();
        //总消耗时间
        long TotalTime = (endTime - startTime);
        System.out.println("排序总消耗时间:" + TotalTime + "ms");
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left < right) {
            int partitionIndex = Partition(arr,left,right);
            quickSort(arr,left,partitionIndex - 1);
            quickSort(arr,partitionIndex + 1,right);
        }
    }


    public static int Partition(int[] arr, int left, int right) {
        int index = left + 1;
        for (int i = index;i <= right;i++) {
            if (arr[i] < arr[left]) {
                swap(arr,i,index);
                index++;
                System.out.println("数组进行交换:");
                for (int k : arr) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }
        }
        swap(arr,index - 1,left);
        return index - 1;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
