import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N;
    static String[] input;
    static Deque<String> deque = new LinkedList<>();

    // 덱 자료구조

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front" :
                    deque.addFirst(input[1]);
                    break;
                case "push_back" :
                    deque.addLast(input[1]);
                    break;
                case "pop_front" :
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.poll());
                    }
                    break;
                case "pop_back" :
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front" :
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peek());
                    }
                    break;
                case "back" :
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
            }

        }


    }
}

