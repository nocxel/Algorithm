import java.io.*;
import java.util.Stack;

public class Main {
    static int K, t, sum = 0;
    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            t = Integer.parseInt(br.readLine());
            if (t == 0) {
                stack.pop();
            } else {
                stack.add(t);
            }
        }
        for (int item : stack) {
            sum += item;
        }
        System.out.println(sum);




    }
}
