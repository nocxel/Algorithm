import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N, result;
    static int[] stairs;
    static int[][] dp;
    // 계단 오르기
    // 계단 오르는 칸 수를 1칸, 2칸으로 나눌 수 있고 한 칸씩은 연속해서 2번밖에 못가므로
    // 직전에 움직인 칸에 따라 dp를 실행한다. 직전에 한 칸 이동했다면 이번에는 2칸움직여야 한다.
    // dp[N][0] = N높이까지 직전에 2칸뛰어서 최대값 dp[N][1] = N높이까지 직전에 1칸 뛰어서 최대값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(br.readLine());
            stairs[i] = score;
        }

        // dp
        for (int i = 0; i < N; i++) {
            if (i > 1) {
                // 2칸오를 때는 dp[i-2]에서 두 값 모두 사용해서 올랐을 때 최대값으로 설정하면 된다.
                // why?
                // stairs = [50, 10, 50, 10, 50] 일 때, dp[4][0]을 구하려면
                // dp[2] = [100, 60]
                // dp[2][1] + stairs[4] 만 구하면 110이지만 dp[2][0] + stairs[4] = 150 으로 놓칠 수 있는 값이 존재하기 때문
                dp[i][0] = Math.max( dp[i-2][1] + stairs[i], dp[i-2][0] + stairs[i]);
                dp[i][1] = dp[i-1][0] + stairs[i];

//                System.out.println("dp[" + i + "][0] : " + dp[i][0] + " dp[" + i + "][1] : " + dp[i][1]) ;
            } else if (i == 0) {
                dp[i][0] = stairs[i];
                dp[i][1] = stairs[i];
            } else {
                dp[i][0] = stairs[i];
                dp[i][1] = dp[i-1][0] + stairs[i];
            }
        }

        result = Math.max(dp[N-1][0], dp[N-1][1]);

        System.out.println(result);



    }
}