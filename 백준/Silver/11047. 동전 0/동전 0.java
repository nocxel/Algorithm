import java.io.*;
import java.util.*;


public class Main {
    static int[] coins;
    static int target, ans = 0;

    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        coins = new int[line];

        for (int i = 0; i < line; i++) {
            coins[line-i-1] = Integer.parseInt(br.readLine());
        }

        for (int coin : coins) {
            if (target >= coin) {
                ans += (target / coin);
                target = target % coin;
            }
        }

        System.out.println(ans);

    }
}
