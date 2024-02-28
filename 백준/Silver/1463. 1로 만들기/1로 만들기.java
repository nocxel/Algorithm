import java.io.*;

public class Main {
    static int X;

    // X를 1로 만드는 연산의 최솟값을 출력한다
    // 1. X가 3으로 나눠지면 3으로나눈다.
    // 2. X가 2로 나눠지면 2로나눈다.

    // 횟수를 1부터 늘려가면서 dp로 풀면 될듯?
    // ex) 10의 경우를 살펴보면, 9 + 1 or 2로 나눠지니까 5 * 2 중 더 빠른걸 고르면 됨
    // => dp[10] = min ( dp[9] + 1 , dp[5] + 1)
    // 6으로 나눠질때는 상관없나?
    // => dp[12] = min (dp[11] + 1, dp[6] + 1, dp[4] + 1);


    static int dp[] = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        for (int i = 2; i <= X ; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

        }

        System.out.println(dp[X]);


    }
}
