import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int n, result;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        // dp[n] = dp[n-1]에 가로로 붙여서 만들기 + dp[n-2]에 세로로 붙여서 만들기
        // 즉, dp[n] = dp[n-1] + dp[n-2];

        for (int i = 0; i < n + 1; i++) {
            if (i < 3) {
                dp[i] = i;
            } else {
                dp[i] = dp[i-1] % 10007 + dp[i-2] % 10007;
            }
        }
        result = dp[n] % 10007;
        System.out.println(result);




    }
}