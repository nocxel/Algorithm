import java.io.*;
import java.util.*;


public class Main {
    static Map<String, Integer> map;
    static String name, type;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void combination() throws IOException {
        StringTokenizer st;
        map = new HashMap<>();
        int N = Integer.parseInt(br.readLine()); // lines;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            type = st.nextToken();
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        long ans = 1;
        for (Integer value : map.values()) {
            ans = ans * (value + 1);
        }
        ans -= 1;
        System.out.println(ans);

    }

    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        int T = Integer.parseInt(br.readLine()); // test case
        for (int i = 0; i < T; i++) {
            combination();
        }



    }
}