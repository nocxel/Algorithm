
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans = 0; // N: 세로, M: 가로  4 <= N, M <= 500
    static int[][] matrix; // matrix[N][M];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;


    // 테트로미노가 놓인 칸에 쓰인 수들의 합의 최대값을 출력하라.
    // 테트로미노? 4칸이 이어져 있는 모양
    // 한 점에서 탐색 => 다음점으로 이동 (중복방지는 어떻게 해야할까?)
    // 최대 2500칸이라

    // 1번째 방법: 모양별로 시작점을 정해놓고 탐색한다
    // 일자형 (2개), 2*2정사각형 (1개), ㄱ모양 (8개), ㄱㄴ모양 (4개), ㅗ모양 (4개)
    // 19가지 모양 한 점마다 19가지 모양이 가능하면 체크하기
    // 이렇게 하면 중복은 없음 (대신 좀 작성을 많이 해야함)

    // 2번째 방법: dfs + ㅗ모양 따로 계산하기
    // 중복이 있어 비효율적? dfs라서 각 점에서 depth 4까지 탐색하는데 영역이 같은 칸들을 체크할 수있음


    // dfs 작성
    static void dfs(int x, int y, int depth, int sum) {
        sum += matrix[y][x];
        visited[y][x] = true;
        if (depth == 3) {
            ans = Math.max(sum, ans);
            visited[y][x] = false;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (!visited[ny][nx]) {
                    dfs(nx, ny, depth+1, sum);
                }
            }
        }
        visited[y][x] = false;
    }

    // ㅗ모양 체크 구현
    // 가운데를 기준으로 잡고 상하좌우 4칸의 값과 합친 후 최솟값을 뺀 값?
    // 모서리나 테두리를 잘 고려해야한다

    static void TShape(int x, int y) {
        int sum = matrix[y][x];
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                cnt += 1;
                sum += matrix[ny][nx];
                min = Math.min(min, matrix[ny][nx]);
            }
        }
        if (cnt == 4) { // 4방향 모두 있을 경우, 최소값을 빼줌
            sum -= min;
        }
        if (cnt < 3) { // 3방향 보다 작을 경우 sum을 0으로 만들어 ans에 반영안되게 하기
            sum = 0;
        }

        ans = Math.max(sum, ans);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[500][500];
        visited = new boolean[500][500];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i,j,0,0);
                TShape(i,j);
            }
        }


        System.out.println(ans);



    }
}
