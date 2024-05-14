import javax.crypto.Cipher;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int col, row, height;
    static int[][][] tomatoesGrid;
    static int depth = -1;
    static boolean[][][] visited;
    static Queue<Coordinate> queue = new LinkedList<>();

    // 6가지 방향
    static int[] dc = {-1, 0, 0, 0, 0, 1};
    static int[] dr = {0, -1, 0, 0, 1, 0};
    static int[] dh = {0, 0, -1, 1, 0, 0};

    // 3차원 배열
    // [col][row][height]

    static class Coordinate {
        int col;
        int row;
        int height;

        public Coordinate(int col, int row, int height) {
            this.col = col;
            this.row = row;
            this.height = height;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        public int getHeight() {
            return height;
        }

        boolean isValid() {
            return col >= 0 && row >= 0 && height >= 0 &&
                   col < tomatoesGrid.length && row < tomatoesGrid[0].length && height < tomatoesGrid[0][0].length;
        }
    }
    
    // 토마토가 다 익었으면 true 아니면 false
    static boolean isAllRipe() {
        for (int col = 0; col < tomatoesGrid.length; col++) {
            for (int row = 0; row < tomatoesGrid[0].length; row++) {
                for (int height = 0; height < tomatoesGrid[0][0].length; height++) {
                    if (tomatoesGrid[col][row][height] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void bfs() {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < height; k++) {
                    if (tomatoesGrid[i][j][k] == 1) {
                        Coordinate coordinate = new Coordinate(i, j, k);
                        queue.add(coordinate);
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();
                col = coordinate.getCol();
                row = coordinate.getRow();
                height = coordinate.getHeight();

                //System.out.println("bfs실행 col: "+ col +" row: " + row + " height: " + height);

                tomatoesGrid[col][row][height] = 1;
                for (int j = 0; j < 6; j++) {
                    int nextCol = col + dc[j];
                    int nextRow = row + dr[j];
                    int nextHeight = height + dh[j];
                    Coordinate nextCoordinate = new Coordinate(nextCol, nextRow, nextHeight);

                    if (nextCoordinate.isValid() && !visited[nextCol][nextRow][nextHeight] && tomatoesGrid[nextCol][nextRow][nextHeight] != -1) {
                        queue.add(nextCoordinate);
                        visited[nextCol][nextRow][nextHeight] = true;
                    }
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        tomatoesGrid = new int[col][row][height];
        visited = new boolean[col][row][height];

        // grid 입력
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    int val = Integer.parseInt(st.nextToken());
                    tomatoesGrid[k][j][i] = val;
                }
            }
        }

        bfs();

        if (isAllRipe()) {
            System.out.println(depth);
        } else {
            System.out.println(-1);
        }


    }
}