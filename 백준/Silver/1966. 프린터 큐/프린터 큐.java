import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T,N,M;
    static Queue<Integer> queue = new LinkedList<>();

    static int maxValQueue(Queue<Integer> queue) {
        int max = queue.isEmpty() ? 0 : queue.peek();
        for (int i : queue) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }


    static int printQueue(Queue<Integer> queue, int target) {
        int count = 1;

        while (!queue.isEmpty()) {
            if (target == 0) {
                if (maxValQueue(queue) == queue.peek()) {
                    break;
                } else {
                    queue.add(queue.poll());
                    target = queue.size() - 1;
                }

            } else {
                if (maxValQueue(queue) == queue.peek()) {
                    queue.poll();
                    count++;
                } else {
                    queue.add(queue.poll());
                }
                target--;
            }
        }

        return count;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(printQueue(queue, M));
            queue.clear();




        }




    }
}
