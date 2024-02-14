import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] arr;
    static long min = 1, mid, max;

    static long countLAN(long[] arr, long length) {
        long result = 0;
        for (long item : arr) {
            result += ( item / length );
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];

        // ans값을 주어진 길이 중 최대로 설정해 놓기
        for (int i = 0; i < K; i++) {
            long d = Long.parseLong(br.readLine());
            arr[i] = d;
            if (d > max) {
                max = d;
            }
        }



        // N과 같거나 더 많이 나눌 수 있을 때 까지 반복문
        // 이분탐색으로 구현 근데 최대값을 구해야하는데
        while (min <= max) {

            mid = (min + max) / 2;
            long count = countLAN(arr, mid);


            if (count < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);


    }
}

