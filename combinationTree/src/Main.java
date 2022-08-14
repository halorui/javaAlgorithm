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
        System.out.format("C(%d,%d) = ",arr.length,num);
        List<List<Character>> res = new ArrayList<>();
        dfs(arr,0,num,new ArrayList<>(),res);
        //打印输出结果
        System.out.print("{");
        for (int i = 0;i < res.size() - 1;i++) {
            System.out.print("{");
            for (int j = 0; j < num - 1; j++) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.print(res.get(i).get(num - 1) + "},");
        }
        System.out.print("{");
        for (int j = 0; j < num - 1; j++) {
            System.out.print(res.get(res.size() - 1).get(j) + ",");
        }
        System.out.print(res.get(res.size() - 1).get(num - 1) + "}}");
    }

    //组合树问题
    public static void dfs(char[] arr,int depth,int end,List<Character> curr,List<List<Character>> res) {
        if (curr.size() == end) {  //如果当前结果个数到达组合个数，打印输出结果，结束递归
            res.add(new ArrayList<>(curr));
            return;
        }
        if (depth == arr.length) { //如果当前深度到达最深深度，结束递归
            return;
        }
        curr.add(arr[depth]);  //添加该元素
        dfs(arr, depth + 1, end, new ArrayList<>(curr),res);  //进入下一元素的处理，进行递归
        curr.remove(curr.size() - 1);  //不添加该元素
        dfs(arr, depth + 1, end, new ArrayList<>(curr),res);  //进入下一元素的处理，进行递归
    }
}