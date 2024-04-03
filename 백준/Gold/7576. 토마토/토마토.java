import java.io.*;
import java.util.*;

public class Main {

    // 토마토 익을 때 까지 걸리는 시간 출력
    static int col, row;
    static int[][] tomatoesGrid;
    static int depth = -1;

    static boolean[][] visited;
    static Queue<Coordinate> queue = new LinkedList<>();

    static int[] dc = {-1, 0, 0, 1};
    static int[] dr = {0, -1, 1, 0};

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
            return col >= 0 && row >= 0 && col < tomatoesGrid.length && row < tomatoesGrid[0].length;
        }
    }

    static boolean isAllRipe() {
        for (int i = 0; i < tomatoesGrid.length; i++) {
            for (int j = 0; j < tomatoesGrid[0].length; j++) {
                if (tomatoesGrid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void bfs() {

        // 익은 토마토를 먼저 큐에 넣어줍니다.
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (tomatoesGrid[i][j] == 1) {
                    Coordinate coordinate = new Coordinate(i,j);
                    queue.add(coordinate);
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            // queue의 사이즈만큼 큐에서 꺼내 좌표 이동 후 visited체크, -1인지 확인 후 queue에 넣는다
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();
                col = coordinate.getCol();
                row = coordinate.getRow();

//                System.out.println("bfs실행 col: "+ col +" row: " + row);


                // 큐에 들어온 좌표들은 이미 visited = true처리 되어있으므로 재방문 하지 않게되니
                // matrix값을 변형해도 추후의 연산에 지장을 주지 않습니다.
                // 따라서 큐에 들어온 좌표의 토마토들을 익은 상태로 바꿔줍니다.
                tomatoesGrid[col][row] = 1;
                for (int j = 0; j < 4; j++) {
                    int nextCol = col + dc[j];
                    int nextRow = row + dr[j];
                    Coordinate nextCoordinate = new Coordinate(nextCol, nextRow);

                    if (nextCoordinate.isValid() && !visited[nextCol][nextRow] && tomatoesGrid[nextCol][nextRow]!= -1) {
                        queue.add(nextCoordinate);
                        visited[nextCol][nextRow] = true;
                    }
                }


            }
            depth++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        tomatoesGrid = new int[col][row];
        visited = new boolean[col][row];

        // grid 입력
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                int val = Integer.parseInt(st.nextToken());
                tomatoesGrid[i][j] = val;
            }
        }


        bfs();

        if (isAllRipe()) {
            System.out.println(depth);
        } else System.out.println(-1);





    }
}
