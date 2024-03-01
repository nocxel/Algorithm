import java.io.*;

public class Main {
    static int T, n;
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < 11; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 4;
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);

        }


    }
}
