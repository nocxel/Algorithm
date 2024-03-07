import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                dp[i] = i;
                continue;
            }
            if (i == 2) {
                dp[i] = 3;
                continue;
            }
            dp[i] = (dp[i-2] * 2) % 10007 + dp[i-1] % 10007;
        }

        System.out.println(dp[n] % 10007);










    }
}
