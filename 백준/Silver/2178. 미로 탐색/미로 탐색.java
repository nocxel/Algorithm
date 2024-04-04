import java.io.*;
import java.util.*;

public class Main {
    // 미로 탐색
    // (1,1) 에서 (N,M)까지 최소 몇 칸 움직여야 하는지 출력

    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dc = {-1, 0, 0, 1};
    static int[] dr = {0, -1, 1, 0};
    static Queue<Coordinate>  queue = new LinkedList<>();

    static class Coordinate {
        int col;
        int row;

        public Coordinate(int col, int row) {
            this.col = col;
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        boolean isValid() {
            if (col >=0 && col < N && row >= 0 && row < M) return true;
            return false;
        }
    }

    static int bfs() {
        Coordinate start = new Coordinate(0,0);
        queue.add(start);
        visited[0][0] = true;
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                start = queue.poll();
                int col = start.getCol();
                int row = start.getRow();
                // System.out.println("bfs 실행 col " + col + " row " + row);

                // (N,M)이 탐색범위에 들어오면 큐를 비우고 for문 탈출
                if (col == N-1 && row == M-1) {
                    queue.clear();
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nextCol = col + dc[j];
                    int nextRow = row + dr[j];
                    Coordinate nextCoordinate = new Coordinate(nextCol, nextRow);

                    if (nextCoordinate.isValid() && matrix[nextCol][nextRow] > 0 && !visited[nextCol][nextRow]) {
                        queue.add(nextCoordinate);
                        visited[nextCol][nextRow] = true;
                    }

                }
            }
            depth++;
        }
        return depth;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int col = 0; col < N; col++) {
            String str = br.readLine();
            for (int row = 0; row < M; row++) {
                matrix[col][row] = Character.getNumericValue(str.charAt(row));
            }
        }

        System.out.println(bfs());


    }
}
