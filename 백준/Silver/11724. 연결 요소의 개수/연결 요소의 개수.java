import java.io.*;
import java.util.*;

public class Main {
    static int V, E, ans;

    // 연결체가 몇 개인지 세면 된다
    static boolean[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();


    static void dfs(int start) {
        visited[start] = true;

        for (int end = 0; end < V; end++) {
            if (graph[start][end] && !visited[end]) {
                dfs(end);
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new boolean[V][V];
        visited = new boolean[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            graph[start][end] = true;
            graph[end][start] = true;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);







    }
}
