import javax.crypto.Cipher;
import java.io.*;
import java.util.*;


public class Main {
    // 최대값 최소값에 모두 접근 가능해야하므로 우선순위큐 2개를 사용하자
    // 우선순위큐 2개로 minPQ.remove(maxPQ.poll())를 사용해서 구현했으나
    // PQ.remove 의 시간복잡도는 O (log N) 시간초과가 발생한다
    // map으로 해당값이 몇 개있는지 표시한다면 O(1)로 삭제를 나타낼 수 있다

    // 아니면 처음부터 treeMap으로 순서를 보장한 자료구조를 사용해서 나타내면 어떨까?

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Integer> map;
    static int T, L;


    static void dualPriorityQueue() throws IOException {
        L = Integer.parseInt(br.readLine()); // lines
        map = new HashMap<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            int val = Integer.parseInt(st.nextToken());
            switch (op) {
                case 'I':
                    maxPQ.add(val);
                    minPQ.add(val);
                    map.put(val, map.getOrDefault(val, 0) + 1);
                    break;
                case 'D':
                    if (map.isEmpty()) continue;
                    if (val == 1) {
                        delete(maxPQ);
                    } else {
                        delete(minPQ);
                    }

                    break;
            }
        }
        if (map.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            int max = delete(maxPQ);
            int min = max;
            if (!map.isEmpty()) {
                min = delete(minPQ);
            }
            System.out.println(max + " " + min);
        }

    }
    static int delete(Queue<Integer> q) {
        int val = 0;
        while (true) {
            val = q.poll();

            int cnt = map.getOrDefault(val, 0);
            if (cnt == 0) continue;

            if (cnt == 1) {
                map.remove(val);
            } else {
                map.put(val, cnt - 1);
            }
            break;
        }
        return val;
    }




    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); // testcase
        for (int t = 1; t <= T; t++) {
            dualPriorityQueue();
        }


    }
}