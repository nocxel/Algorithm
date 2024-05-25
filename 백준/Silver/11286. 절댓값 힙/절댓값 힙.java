import java.io.*;
import java.util.*;


public class Main {

    static class AbsPriorityQueue{
        private PriorityQueue<Long> pq;

        public AbsPriorityQueue() {
            pq = new PriorityQueue<>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    long abs1 = Math.abs(o1);
                    long abs2 = Math.abs(o2);
                    if (abs1 == abs2) {
                        return Long.compare(o1, o2);
                    } else {
                        return Long.compare(abs1, abs2);
                    }
                }
            });
        }

        public void push(long x) {
            pq.add(x);
        }

        public long pop() {
            if (pq.isEmpty()) {
                return 0L;
            }
            return pq.poll();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }

    }


    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int lines = Integer.parseInt(br.readLine());
        AbsPriorityQueue apq = new AbsPriorityQueue();

        for (int i = 0; i < lines; i++) {
            long x = Long.parseLong(br.readLine());

            if (x == 0) {
                System.out.println(apq.pop());
            } else {
                apq.push(x);
            }
        }


    }
}
