import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int N, input;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 우선순위큐는 minHeap처럼 동작합니다. 최소값을 찾기쉬움 => 최소값을 빨리 삭제함
        // maxHeap처럼 동작하게 하기위해서 Collections.reverseOrder를 이용해서 역순으로 정렬해줍니다.
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(input);
            }
        }


    }
}
