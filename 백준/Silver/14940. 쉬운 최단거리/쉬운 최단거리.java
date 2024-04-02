import java.io.*;
import java.util.*;

public class Main {
    // 각 위치에서 타겟까지의 거리를 출력하면된다
    // 타겟까지 가는 방법이 여러가지 있으므로 dfs로 풀면 안된다

    static int row, col, targetR, targetC;
    static int[][] matrix;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dc = {-1, 0, 0, 1};
    static int[] dr = {0, -1, 1, 0};
    static Queue<Coordinate> queue = new LinkedList<>();

    static class Coordinate {
        int col;
        int row;

        Coordinate(int col, int row) {
            this.col = col;
            this.row = row;
        }

        boolean isValid() {
            return col >= 0 && row >= 0 && col < matrix.length && row < matrix[0].length;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }
    }


    static void bfs(int col, int row) {
        // depth에 따라 한번에 처리하는게 좋을 듯
        Coordinate start = new Coordinate(col, row);
        queue.add(start);
        visited[col][row] = true;
        int depth = 0;


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                start = queue.poll();
                col = start.getCol();
                row = start.getRow();

                // 현재 좌표가 0이 아닐때만 더 깊이 탐색해야한다
                if (matrix[col][row] != 0) {
                    dist[col][row] = depth;
                    for (int j = 0; j < 4; j++) {
                        int nextCol = col + dc[j];
                        int nextRow = row + dr[j];
                        Coordinate next = new Coordinate(nextCol, nextRow);
                        if (next.isValid() && !visited[nextCol][nextRow]) {
                            queue.add(next);
                            visited[nextCol][nextRow] = true;
                        }

                    }
                }
            }
            depth++;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        matrix = new int[col][row];
        dist = new int[col][row];
        visited = new boolean[col][row];


        // matrix입력받기
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;
                // 좌표값이 2인 위치 알아두기
                if (value == 2) {
                    targetC = i;
                    targetR = j;
                }
                // dist배열을 좌표값이 0이 아닌부분은 -1로 초기화 (기본적으로 0으로 되어있어서 0은 신경안씀)
                if (value != 0) {
                    dist[i][j] = -1;
                }
            }
        }

        // target좌표로부터 bfs실행
        bfs(targetC, targetR);

        // 출력
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                bw.append(Integer.toString(dist[i][j]));
                
                if (j < row - 1) {
                    bw.append(" ");
                }
            }
            if (i < col - 1) {
                bw.newLine();
            }
        }
        bw.flush();





    }
}
