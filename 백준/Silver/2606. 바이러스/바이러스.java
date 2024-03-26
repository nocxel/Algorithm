import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int V, E;
    static boolean[][] graph;
    static boolean[] visited;
    static int count = 0;
    
    static void dfs(int i) {
        //System.out.println("dfs 실행 i = " + i);
        visited[i] = true;
        for (int j = 1; j < V+1; j++) {
            if (graph[i][j] && !visited[j]) {
                count++;
                dfs(j);
            }
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        graph = new boolean[V+1][V+1];
        visited = new boolean[V+1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true;
            graph[end][start] = true;
        }
        dfs(1);

        System.out.println(count);
        
        




    }
}