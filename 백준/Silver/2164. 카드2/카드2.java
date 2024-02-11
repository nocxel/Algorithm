import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, num, ans;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt( br.readLine() );
        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }
        for (int i = 0; i < N - 1; i++) {
            queue.poll();
            num = queue.poll();
            queue.add(num);
        }
        ans = queue.poll();
        System.out.println(ans);

    }
}

