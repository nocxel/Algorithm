import java.io.*;
import java.util.*;

public class Main {
    static class CustomSet {
        HashSet<Integer> set;

        public CustomSet() {
            this.set = new HashSet<>();
        }

        void add(int x) {
            set.add(x);
        }

        void remove(int x) {
            set.remove(x);
        }

        void check(int x, BufferedWriter bw) throws IOException {
            if (set.contains(x)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        void toggle(int x) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }

        void all() {
            set.clear();
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
        }

        void empty() {
            set.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        CustomSet customSet = new CustomSet();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int val = 0;
            if (st.hasMoreTokens()) {
                val = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    customSet.add(val);
                    break;
                case "remove":
                    customSet.remove(val);
                    break;
                case "check":
                    customSet.check(val, bw);
                    break;
                case "toggle":
                    customSet.toggle(val);
                    break;
                case "all":
                    customSet.all();
                    break;
                case "empty":
                    customSet.empty();
                    break;
                default:
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
