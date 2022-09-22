import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3,6,8,7};
        for (int i = 0;i < arr.length;i++) {
            for (int j = i + 1;j < arr.length;j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> it = set.iterator();

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}