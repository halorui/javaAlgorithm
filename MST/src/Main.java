import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入带权无向图的定点数和边数:");
        int pointNum = scanner.nextInt();
        int edgeNum = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < edgeNum; i++) {
            int point1 = scanner.nextInt(),point2 = scanner.nextInt();
            maxLen = Math.max(Math.max(maxLen,point1),point2);
            edges.add(new Edge(point1,point2,scanner.nextInt()));
        }
        edges.sort(Comparator.comparingInt(edge -> edge.len)); //以边数权值升序排序
        DisjointSetUnion dsu = new DisjointSetUnion(maxLen);
        int res = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y,len)) {
                res += len;
                num++;
                if (num == pointNum) {
                    break;
                }
            }
        }
        if (num < pointNum) {
            System.out.println("不存在最小生成树！");
        } else {
            System.out.println("最小生成树的花费为:" + res);
        }
    }
}

//集合定义
class DisjointSetUnion {
    int[][] graph;

    public DisjointSetUnion(int maxLen) {
        this.graph = new int[maxLen + 1][maxLen + 1];
    }

    //BFS寻找没有被连接的边
    public boolean find(int x,int y) {
        if (x == y) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] used = new boolean[graph.length];
        for (int i = 0;i < graph.length;i++) {
            if (graph[x][i] > 0) {
                queue.offer(new int[] {x,i});
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (!used[temp[0]]) {
                if (temp[0] == y || temp[1] == y) {
                    return false;
                }
                for (int i = 0;i < graph.length;i++) {
                    if (graph[temp[1]][i] > 0) {
                        queue.offer(new int[] {temp[1],i});
                    }
                }
            }

            used[temp[0]] = true;
        }
        return true;
    }

    public boolean unionSet(int x, int y,int len) {
        if (find(x,y)) {
            graph[x][y] = graph[y][x] = len;
            return true;
        }
        return false;
    }
}

//边定义
class Edge {
    int len, x, y;

    public Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}
