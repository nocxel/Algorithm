import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int N, M;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt( br.readLine() );
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            set.add( Integer.parseInt( arr[i] ) );
        }

        M = Integer.parseInt( br.readLine() );
        arr = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (set.contains( Integer.parseInt( arr[i] )) ) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

