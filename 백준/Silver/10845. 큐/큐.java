import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static String[] input;
    static Queue<String> queue = new LinkedList();

    // 큐 자료구조

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push" :
                    queue.add(input[1]);
                    break;
                case "pop" :
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front" :
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back" :
                    String lastItem = null;
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        for (String item : queue) {
                            lastItem = item;
                        }
                        System.out.println(lastItem);
                    }
                    break;
            }
            
        }
     
        
    }
}

