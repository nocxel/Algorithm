import java.io.*;
import java.util.StringTokenizer;


public class Main {
    // N: 나무 그루, M: 필요한 나무 길이
    static int N, M, min = 0, max = 1_000_000_000, mid = max/2; // 1 <= N <= 1,000,000 , 1 <= M <= 2,000,000,000 int 가능
    static int[] trees;

    // 톱 높이를 length로 설정했을 때 결과 값
    static long chopTree(int length) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > length) {
                sum += ( tree - length );
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        while (min+1 != max) {
            if (chopTree(mid) < M) {
                max = mid;
                mid = (max + min) / 2;
            } else {
                min = mid;
                mid = (max + min) / 2 + 1;
            }
        }

        System.out.println(min);






    }
}
