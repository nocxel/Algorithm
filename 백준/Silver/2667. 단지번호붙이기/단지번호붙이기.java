import java.io.*;
import java.util.*;

public class Main {
    // 단지 번호 붙이기
    static int N, count= 0, num = 0;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, -1, 0, 1};
    static ArrayList<Integer> complex = new ArrayList<>();

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

        public boolean isValid() {
            return col >= 0 && col < N && row >= 0 && row < N;
        }
    }

    static void dfs(Coordinate start) {
        int col = start.getCol();
        int row = start.getRow();
        visited[col][row] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextCol = col + dc[i];
            int nextRow = row + dr[i];
            Coordinate nextCoordinate = new Coordinate(nextCol, nextRow);

            if (nextCoordinate.isValid() && !visited[nextCol][nextRow] && matrix[nextCol][nextRow] != 0) {
                dfs(nextCoordinate);

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int col = 0; col < N; col++) {
            String str = br.readLine();
            for (int row = 0; row < N; row++) {
                matrix[col][row] = Character.getNumericValue(str.charAt(row));
            }
        }

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                if (!visited[col][row] && matrix[col][row] != 0) {
                    Coordinate coordinate = new Coordinate(col, row);
                    dfs(coordinate);
                    num++;
                    complex.add(count);
                    count = 0;
                }
            }
        }
        complex.sort(Integer::compareTo);
        System.out.println(num);
        for (int i = 0; i < complex.size(); i++) {
            System.out.println(complex.get(i));
        }




    }
}
