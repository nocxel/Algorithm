import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;



    static void result(int n) {
        int [] fibo = new int[3];
        fibo[0] = 0;
        fibo[1] = 1;
        
        if (n == 0) {
            System.out.println("1 0");
        } else if (n == 1) {
            System.out.println("0 1");
        } else {
            for (int i = 2; i <= n; i++) {
                fibo[2] = fibo[1] + fibo[0];
                fibo[0] = fibo[1];
                fibo[1] = fibo[2];
            }
            System.out.println(fibo[0] + " " + fibo[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            result(n);
        }



    }
}
