import java.io.*;
import java.util.*;

public class Main {
    static int T, n;
    static String input;
    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static void AC() throws IOException {
        boolean reverse = false;
        input = br.readLine();
        n = Integer.parseInt(br.readLine());
        String[] arrInput = br.readLine().replaceAll("[^0-9]+", " ").trim().split(" ");
        for (int i = 0; i < n; i++) {
            deque.addLast(Integer.parseInt(arrInput[i]));
        }

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'R' :
                    reverse = !reverse;
                    break;
                case 'D' :
                    if (!deque.isEmpty()) {
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    } else {
                        sb.append("error").append("\n");
                        return;
                    }
                    break;
            }
        }
        int size = deque.size();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            int val;
            if (reverse) {
                val = deque.removeLast();
            } else {
                val = deque.removeFirst();
            }

            if (i == 0) {
                sb.append(val);
            } else {
                sb.append(",").append(val);
            }
        }
        sb.append("]").append("\n");
        deque.clear();
    }


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            AC();
        }
        System.out.println(sb.toString());






    }
}
