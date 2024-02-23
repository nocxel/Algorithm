import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    static int[][] ground;
    static int[] result;

    static int[] compactGround(int[][] ground, int block) {
        int[] result = new int[2];
        int resultHeight = Integer.MAX_VALUE;
        int resultTime = Integer.MAX_VALUE;
        int maxHeight;
        int minHeight = Integer.MAX_VALUE;
        int currTime = 0;
        int areaSize = ground.length * ground[0].length;
        int maxBlock = 0;
        for (int[] items : ground) {
            for (int item : items) {
                maxBlock += item;
                if (minHeight > item) {
                    minHeight = item;
                }
            }
        }
        maxBlock += block;
        // 만들 수 있는 높이 최대값
        maxHeight = maxBlock / areaSize;

        for (int height = maxHeight; height >= minHeight; height--) {
            // 땅 다지는 시간 구하기
            for (int[] items : ground) {
                for (int item : items) {
                    // 목표높이보다 낮을 때, 블럭을 쌓는다 (1초)
                    if (item < height) {
                        currTime += (height - item);
                    } else { // 목표높이보다 높으면, 블럭을 제거한다 (2초)
                        currTime += 2 * (item - height);
                    }
                }
            }
            if (currTime < resultTime) {
                resultTime = currTime;
                resultHeight = height;
                // System.out.println("시간 : " + resultTime + " 높이 : " + resultHeight);
            }
            // 시간 초기화
            currTime = 0;

        }
        result[0] = resultTime;
        result[1] = resultHeight;
        return result;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        ground = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = compactGround(ground, B);

        System.out.println(result[0] + " " + result[1]);
        
    }
}
