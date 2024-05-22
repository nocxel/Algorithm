import java.io.*;
import java.util.*;


public class Main {
    static boolean[][] visited;
    static boolean[][] visitedColorWeak;
    static char[][] matrix;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int ansNormal = 0, ansColorWeak = 0;


    static class Coordinate {
        int row;
        int col;
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
        public boolean isValidCoordinate() {
            return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
        }

    }

    static void dfsNormal(Coordinate coordinate, char color) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            Coordinate nextCoordinate = new Coordinate(nextRow, nextCol);
            if (nextCoordinate.isValidCoordinate() && !visited[nextRow][nextCol] && matrix[nextRow][nextCol] == color) {
                dfsNormal(nextCoordinate,color);
            }
        }
    }
    static void dfsColorWeak(Coordinate coordinate, char color) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        visitedColorWeak[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            Coordinate nextCoordinate = new Coordinate(nextRow, nextCol);
            if (!nextCoordinate.isValidCoordinate()) continue;
            
            char nextColor = matrix[nextRow][nextCol];
            if (color == 'B') {
                if (!visitedColorWeak[nextRow][nextCol] && nextColor == color) {
                    dfsColorWeak(nextCoordinate,color);
                }
            } else {
                if (!visitedColorWeak[nextRow][nextCol] && nextColor != 'B') {
                    dfsColorWeak(nextCoordinate, color);
                }
            }
        }

    }



    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        matrix = new char[L][L];
        visited = new boolean[L][L];
        visitedColorWeak = new boolean[L][L];

        // matrix 채우기
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            for (int j = 0; j < L; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }


        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (!visited[i][j]) {
                    dfsNormal(new Coordinate(i, j), matrix[i][j]);
                    ansNormal++;
                }
                if (!visitedColorWeak[i][j]) {
                    dfsColorWeak(new Coordinate(i,j), matrix[i][j]);
                    ansColorWeak++;
                }
            }
        }

        System.out.println(ansNormal + " " + ansColorWeak);


    }
}