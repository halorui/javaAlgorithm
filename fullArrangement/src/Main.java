import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符(以字符串形式):");
        char[] arr = scanner.next().toCharArray();
        System.out.print("请输入排列个数:");
        int num = scanner.nextInt();
        List<List<Character>> res = new ArrayList<>();
        System.out.format("P(%d,%d) = {",arr.length,num);
        dfs(arr,new boolean[arr.length],num,new ArrayList<>(),res);
        //打印输出结果
        for (int i = 0;i < res.size();i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(res.get(i).get(j));
            }
            if (i != res.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}");
    }

    //全排列问题
    public static void dfs(char[] arr, boolean[] used, int depth, List<Character> curr,List<List<Character>> res) {
        if (depth == 0) {  //如果当前深度到达最深深度，打印输出结果，结束递归
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0;i < arr.length;i++) {
            if (!used[i]) {  //如果当前元素还没有被使用
                curr.add(arr[i]);  //添加该元素
                used[i] = true;  //该元素使用状态置真
                dfs(arr,used,depth - 1,curr,res);  //进入该元素下的分支，进行递归
                used[i] = false;  //该元素使用状态置假
                curr.remove(curr.size() - 1);  //移除该元素，进入另外的分支
            }
        }
    }
}