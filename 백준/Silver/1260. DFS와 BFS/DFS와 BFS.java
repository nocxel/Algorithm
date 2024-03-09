import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // Q. DFS 와 BFS 구현하기
    // N : 정점 개수, M : 간선 개수, V : 탐색을 시작할 번호
    // 간선은 양방향이다.
    // 배열이나 연결리스트로 필드를 구현한다.
    static int N, M, V;

    // matrix[start][end] = start에서 end로 가는 간선이 있으면 true
    // 양방향이므로 matrix[end][start] 값도 true
    static boolean[][] matrix;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    static StringBuilder sb;

    static void dfs(int V) {
//        System.out.println("dfs 실행 V : " + V);
        visited[V-1] = true;
        sb.append(V).append(" ");
        for (int i = 0; i < N; i++) {
            if (matrix[V - 1][i] && !visited[i]) {
                dfs(i + 1);
            }
        }
    }
    
    static void bfs(int V) {
//        System.out.println("bfs 실행 V : " + V);
        queue.add(V);
        visited[V-1] = true;

        while(!queue.isEmpty()) {
            V = queue.poll();
            sb.append(V).append(" ");
            for (int i = 0; i < N; i++) {
                if (matrix[V-1][i] && !visited[i]) {
                    queue.add(i+1);
                    visited[i] = true;
            }
        }

        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        matrix = new boolean[N][N];
        visited = new boolean[N];

        sb = new StringBuilder();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            matrix[start][end] = true;
            matrix[end][start] = true;
        }

        dfs(V);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        visited = new boolean[N];
        bfs(V);
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());

    }
}
