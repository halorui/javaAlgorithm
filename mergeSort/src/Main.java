import java.io.*;

public class Main{
    private static int[] tArr;  //暂存数组
    public static void main(String[] args) throws IOException{
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        int[] arr = new int[n];
        tArr = new int[n];
        for (int i = 0;i < n;i++) {
            st.nextToken();
            arr[i] = (int)st.nval;
        }
        mergeSort(arr,0,n - 1);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        for (int i = 0;i < n;i++) {
            pw.print(arr[i] + " ");
        }
        pw.flush();
    }

    public static void mergeSort(int[] arr,int lo,int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >> 1;
        mergeSort(arr,lo,mid);
        mergeSort(arr,mid + 1,hi);

        int k = 0;
        int i = lo;
        int j = mid + 1;

        /**
         * 将两部分中数值小的部分按照顺序存进暂存数组
         */
        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) tArr[k++] = arr[i++];
            else tArr[k++] = arr[j++];
        }

        /**
         * 将剩下的数值存进暂存数组
         */
        while (i <= mid) tArr[k++] = arr[i++];
        while (j <= hi) tArr[k++] = arr[j++];

        /**
         * 将排序完的结果放回原数组
         */
        for (i = lo,j = 0;i <= hi;i++,j++) arr[i] = tArr[j];
    }
}