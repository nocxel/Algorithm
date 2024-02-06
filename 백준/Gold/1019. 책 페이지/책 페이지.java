import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int add = 0;
    static long[] numberCount = new long[10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 1; N > 0; i*=10) {
            // 0 i개 만큼 감소시켜야함
            numberCount[0]-=i;
            int NMod10 = N%10;
            N/=10;
            // N의 일의자리까지는 1개더 많이
            for (int j = 0; j < NMod10; j++) {
                numberCount[j] += (N+1) * i;
            }
            numberCount[NMod10] += N * i + add + 1;
            for (int j = NMod10 + 1; j < 10; j++) {
                numberCount[j] += N * i;
            }

            // 나머지 자리 체크할 때 사용할 변수
            // ex) N = 391, 십의자리 체크할때 390, 391 로 9는 2번 사용, 백의자리에서 3은 300~ 391까지 92번 사용
            add += NMod10 * i;
        }

        for (int i = 0; i < numberCount.length; i++) {
            if (i==numberCount.length - 1) {
                sb.append(numberCount[i]);
            } else {
                sb.append(numberCount[i]).append(" ");
            }

        }
        System.out.println(sb);





    }


}

