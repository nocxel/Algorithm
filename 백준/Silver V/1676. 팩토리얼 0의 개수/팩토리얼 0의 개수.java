import java.io.*;

public class Main {
    static int N, ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ans = (N/125)+ (N/25) + (N/5);

        System.out.println(ans);
    }
}

