import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] arr;
    static int[][] map;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new String[N + 1];
        map = new int[N][M];

        // String을 int로 바꿔서 배열에 저장해야한다
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(arr[i].charAt(j));
            }
        }

        // 시작점 설정
        for (int i = 0; i < M; i++) { // row
            for (int j = 0; j < N; j++) { // corumn
                // 시작점 설정
                arithmeticSequenceFromPoint(i,j);
            }
        }
        System.out.println(ans);
    }

    // 시작점 n,m이 주어졌을 때 등차수열들 만들기
    // 5*5 배열일때 (0,0) ~ (4,4) 확인하니 첫 지점 0,0 일때 4,4이상으로 갈필요가없음
    // -4,-3,-2,-1,0,1,2,3,4 만 확인하면 됨 int i = -N+1; i < N; i++
    // N-1까지만 확인하면 됨

    // 기준좌표 row, column으로 받음
    public static void arithmeticSequenceFromPoint(int r, int c) {
        for (int dX = -M; dX < M ; dX++) {
            for (int dY = -N; dY < N ; dY++) {
                if (dX == 0 && dY == 0) continue;

                int x = r;
                int y = c;

                int sqr = 0;
                // x와 y값이 arr 범위안에 있어야함
                while (0<=x && x < M && 0<=y && y < N) {
                    sqr *= 10;
                    sqr += map[y][x]; // 순서 주의 map은 N*M크기로 만들었으니 column이 앞에 row가 뒤에 위치함

                    x += dX;
                    y += dY;

                    if (isSquareNumber(sqr)) {
                        // 최대값을 구해야하므로
                        ans = Math.max(ans, sqr);
                    }
                }

            }
        }
    }
    public static boolean isSquareNumber(int n) {
        return Math.pow((int) Math.sqrt(n), 2) == n;
    }
}
