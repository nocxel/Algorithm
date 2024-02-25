import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K, X, Y;
    static int[][] area;
    static int count;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    // x,y값이 주어지면 주변 한칸에 대해 area
    static void dfs(int y, int x) {
        // System.out.println("dfs실행 y : " + y + " x : " + x);
        visited[y][x] = true;
        int nx, ny;

        if (area[y][x] == 1) {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx > -1 && ny > -1 && nx < M && ny < N && area[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny,nx);
                }
            }
        }


    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            count = 0; // count 초기화

            area = new int[N][M];   // int[세로][가로]

            // 배추 위치 배열에 표시하기
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken()); // 가로 좌표
                Y = Integer.parseInt(st.nextToken()); // 세로 좌표

                area[Y][X] = 1;
            }
//            배열 출력
//            for (int[] ints : area) {
//                for (int anInt : ints) {
//                    System.out.print(anInt);
//                }
//                System.out.println(" ");
//
//            }

            visited = new boolean[N][M];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (area[j][k] == 1 && !visited[j][k]) { // 방문하지 않았던 좌표라면
                        count++; // 카운트를 증가시키고 dfs하면 될듯?
                        dfs(j, k);

                    }
                }
            }

            System.out.println(count);
            

        }




    }
}
