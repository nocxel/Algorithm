import java.io.*;
import java.util.*;

public class Main {
    // 케빈 베이컨
    // 모든 관계는 연결되어 있음 (고립된 연결은 존재하지 않는다)
    // 모든 정점에서 다른 정점까지의 최단거리를 구하기 위해 플로이드 워셜 알고리즘을 이용한다

    // Floyd-Warshall 알고리즘
    // 모든 노드를 중간 지점으로 삼아서 더 짧은 구간이 있으면 그것으로 교체


    static int V, E, ans; // V: 정점 수, E: 간선  ans: 케빈 베이컨이 가장 작은 노드번호
    static int[][] graph;

    static void floydWarshall() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        // Check if there's a shorter path through vertex k
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[V][V];

        // 그래프 채우기
        // 자기자신만 0 나머지는 max;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i!=j) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 간선 입력받아서 채우기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        floydWarshall();

        // 케빈 베이컨 최소인 사람 구하기 1번노드부터 돌아가니까 같은 값일때 자동으로 노드가 작은번호로 됩니다.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            int sum = 0;
            for (int j = 0; j < V; j++) {
                sum += graph[i][j];
            }
            if (min > sum) {
                min = sum;
                ans = i + 1;
            }
        }
        System.out.println(ans);
    }
}
