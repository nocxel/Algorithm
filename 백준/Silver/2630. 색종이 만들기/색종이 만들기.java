import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, blueCnt = 0, whiteCnt = 0;
    static char[][] matrix; // white - 'w', blue - 'b'

    // matrix의 일부분의 색상이 같으면 true를 반환
    static boolean isSameColor(char[][] matrix, int startX, int startY, int size, char standard) {
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (matrix[i][j] != standard) return false;
            }
        }
        return true;
    }

    /**
     * matrix의 색이 모두 같으면 cnt값을 증가시키고 그렇지 않으면 4등분하여 재귀실행
     */
    static void divideAndConquer(char[][] matrix, int startX, int startY, int size) {
        char standardColor = matrix[startX][startY];
        if (isSameColor(matrix, startX, startY, size, standardColor)) {
            if (standardColor == 'w') whiteCnt++;
            else blueCnt++;
            return;
        }

        int newSize = size / 2;
        divideAndConquer(matrix, startX, startY, newSize);
        divideAndConquer(matrix, startX + newSize, startY, newSize);
        divideAndConquer(matrix, startX, startY + newSize, newSize);
        divideAndConquer(matrix, startX + newSize, startY + newSize, newSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char token = st.nextToken().equals("1") ? 'b' : 'w';
                matrix[i][j] = token;
            }
        }

        divideAndConquer(matrix, 0, 0, N);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
}
