import java.io.*;
import java.util.*;

public class Main {
    static int N, ans = 0, sum = 0; // 사람 수
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedTimes = Arrays.stream(times).sorted().toArray();

        for (int sortedTime : sortedTimes) {
            ans += sum + sortedTime;
            sum += sortedTime;
        }
        System.out.println(ans);

    }
}
