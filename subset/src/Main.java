import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符(以字符串形式):");
        char[] arr = scanner.next().toCharArray();
        List<List<Character>> res = new ArrayList<>();
        dfs(arr,new boolean[arr.length],0,res);
        System.out.format("C(%d,%d) = " + res,arr.length,2);
    }

    //幂子集问题
    public static void dfs(char[] arr,boolean[] use,int depth,List<List<Character>> res) {
        if (depth == arr.length) {  //如果当前深度到达最深深度，打印输出结果，结束递归
            List<Character> curr = new ArrayList<>();
            for (int i = 0;i < use.length;i++) {
                //根据状态表打印输出结果
                if (use[i]) {
                    curr.add(arr[i]);
                }
            }
            res.add(curr);
            return;
        }
        use[depth] = true;  //该元素对应的使用表位置状态置真
        dfs(arr,use,depth + 1,res);  //进入下一元素的处理，进行递归
        use[depth] = false;  //该元素对应的使用表位置状态置假
        dfs(arr,use,depth + 1,res);  //进入下一元素的处理，进行递归
    }
}