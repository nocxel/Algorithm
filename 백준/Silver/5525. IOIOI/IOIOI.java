import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static int N, M, start,count = 0;
    static String S;
    static boolean isStart;

    // M = length;
    // N = 1, P(N) = IOI / N = 2, P(N) = IOIOI
    // 주어진 문자열 S에 포함된 P(N)이 몇 개인가? S는 I와 O로 이루어져 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'I' && !isStart) { // 세기 시작
                start = 0;
                isStart = true;
            } else if (S.charAt(i) == 'O' && start % 2 == 0 && isStart) {
                start += 1;
            } else if (S.charAt(i) == 'I' && start % 2 == 1) {
                start += 1;
            } else if (S.charAt(i) == 'I' && start % 2 == 0 && isStart) {
                start = 0;
            }
            else {
                isStart = false;
                continue;
            }

            if (start % 2 == 0 && start / 2 >= N) {
                count += 1;
//                System.out.println("i : " + i + " count : "+ count);
            }
        }

        System.out.println(count);



    }
}