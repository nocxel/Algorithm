import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, K;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];



    // -1 or +1 or *2
    static int bfs(int start) {
        queue.add(start);
        visited[start] = true;
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                start = queue.poll();
                if (start == K) {
                    return depth;
                }
                for (int next : new int[]{start + 1, start - 1, start * 2}) {
                    if (isValid(next) && !visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            depth++;

        }
        return -1;

    }
    static boolean isValid(int x) {
        return x >= 0 && x <= 100000;
    }


    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));


        
        




    }
}

