public class Main {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,5,6,8,7};
        quickSort(arr,0,arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr,int lo,int hi) {
        if (lo >= hi) return;
        int x = arr[lo];
        int l = lo - 1;
        int r = hi + 1;
        while (l < r) {
            do l++; while (arr[l] < x);
            do r--; while (arr[r] > x);
            if (l < r) {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }
        quickSort(arr,lo,r);
        quickSort(arr, r + 1,hi);
    }
}
