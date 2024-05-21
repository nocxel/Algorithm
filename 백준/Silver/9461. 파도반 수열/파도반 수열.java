import java.io.*;
import java.util.*;


public class Main {


    




    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] padovan = new long[100];
        long[] padovan2 = new long[100];
        for (int i = 0; i < 100; i++) {
            if (i < 3) {
                padovan[i] = 1;
            } else if (i < 5) {
                padovan[i] = 2;
            } else {
                padovan[i] = padovan[i-1] + padovan[i-5];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(padovan[N-1]);
        }

    }
}