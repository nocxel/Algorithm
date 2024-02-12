import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static String[] input;
    static Stack st = new Stack();

    // 스택 자료구조

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push" :
                    st.push(input[1]);
                    break;
                case "pop" :
                    if (st.empty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(st.pop());
                    }
                    break;
                case "size" :
                    System.out.println(st.size());
                    break;
                case "empty" :
                    if (st.empty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top" :
                    if (st.empty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(st.peek());
                    }
                    break;
            }
        }
    }
}

