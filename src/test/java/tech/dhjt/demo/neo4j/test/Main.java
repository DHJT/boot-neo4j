package tech.dhjt.demo.neo4j.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 拓扑排序是有向无环图的一个具体应用。拓扑排序是指将DAG图的顶点排成一个线性的序列。
 * 这个线性的序列是满足一下规则的：如果在DAG图中存在v->u，那么在这个序列中v一定是排在u的前面的
 * @author DHJT 2023-02-12 23:59:36
 *
 */
// 一个存储Graph边的类
class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// 表示Graph对象的类
class Graph {
    // 表示邻接列表的列表列表
    List<List<Integer>> adjList = null;

    // 构造函数
    Graph(List<Edge> edges, int n) {
        // 分配内存
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // 向有向Graph添加边
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            // 添加从源到目标的边
            adjList.get(src).add(dest);
        }
    }
}

public class Main {
    // 对Graph进行DFS，设置所有的出发时间
    // Graph的顶点
    static int DFS(Graph graph, int v, boolean[] discovered, int[] departure, int time) {
        // 将当前节点标记为已发现
        discovered[v] = true;

        // 设置顶点 `v` 的到达时间
        time++;

        // 为每条边 (v, u) 做
        for (int u : graph.adjList.get(v)) {
            // 如果 `u` 还没有被发现
            if (!discovered[u]) {
                time = DFS(graph, u, discovered, departure, time);
            }
        }

        // 准备回溯
        // 设置顶点 `v` 的出发时间
        departure[time] = v;
        time++;

        return time;
    }

    // 对给定 DAG 执行拓扑排序的函数
    public static void doTopologicalSort(Graph graph, int n) {
        // `departure[]` 使用出发时间作为索引存储顶点编号
        int[] departure = new int[2*n];
        Arrays.fill(departure, -1);

        /* 如果我们以相反的方式完成，即填充数组
           以使用顶点数作为索引的出发时间，我们将
           稍后需要排序 */

        // 跟踪是否发现了一个顶点
        boolean[] discovered = new boolean[n];
        int time = 0;

        // 对所有未发现的顶点执行 DFS
        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, departure, time);
            }
        }

        // 按递减顺序打印顶点
        // DFS中的出发时间，即按照拓扑顺序
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (departure[i] != -1) {
                System.out.print(departure[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // 根据上Graph的Graph边列表
        List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6), new Edge(3, 0),
                new Edge(3, 4), new Edge(5, 1), new Edge(7, 0), new Edge(7, 1));

        // Graph中的节点总数(标记为 0 到 7)
        int n = 8;

        // 从给定的边构建一个Graph
        Graph graph = new Graph(edges, n);

        // 进行拓扑排序
        doTopologicalSort(graph, n);
    }
}
