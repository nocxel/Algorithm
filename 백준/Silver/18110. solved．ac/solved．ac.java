import java.io.*;
import java.util.Arrays;

public class Main {
    static int n, k, sum = 0;
    static int[] scoreArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        k = (int) Math.round(n * 0.15);


        scoreArr = new int[n];
        for (int i = 0; i < n; i++) {
            scoreArr[i] = Integer.parseInt(br.readLine());
        }

        scoreArr = Arrays.stream(scoreArr).sorted().toArray();

        for (int i = k; i < n-k; i++) {
            sum += scoreArr[i];
        }

        System.out.println( Math.round((double) sum / (n-2*k) ));







    }
}
