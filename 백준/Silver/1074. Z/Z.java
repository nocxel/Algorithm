import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, rQ, cQ, result = 0;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // N 값에 따라 r, c 값을 2 ^ (N - 1) 부터 2까지 나눠가며 출력해 나가야 한다


        for (int i = N - 1; i >= 0; i--) {
            rQ = r / (int)Math.pow(2, i);
            cQ = c / (int)Math.pow(2, i);

            result += (int) Math.pow(2, i * 2) * cQ + (int) Math.pow(2, i * 2) * 2 * rQ;

            r = r % (int)Math.pow(2, i);
            c = c % (int)Math.pow(2, i);
        }

        System.out.println(result);


    }
}
