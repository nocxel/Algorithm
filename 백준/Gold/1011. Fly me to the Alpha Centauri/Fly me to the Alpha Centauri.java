import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int d = Y - X;

            int max = (int)Math.sqrt(d);

            if (max == Math.sqrt(d)) {
                sb.append(max * 2 - 1).append('\n');
            }
            else if(d <= max * max + max) {
                sb.append(max * 2).append('\n');
            }
            else {
                sb.append(max * 2 + 1).append('\n');
            }
        }
        System.out.println(sb);

    }
}
