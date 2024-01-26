import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int diff = (int)(max - min) + 1;
        boolean[] check = new boolean[diff];

        // min의 최대값이 1조임
        // 100만개 숫자에 대해서 일일히 나눠지는 지 체크하면 for i = 2; i < sqrt(num); i++ if (num % i*i == 0)로 체크해야하니까
        // 100만 * 100만개 확인해야할 수 있음 이 될 수 있음
        // 그냥 에라토스테네스의 체처럼 하면될 듯?
        // 일단 최소값을 제곱수로 다 나눠봄 i = 2; i*i <= max; i++ i 범위가 2~ 100만
        // 해서 나온 몫들 100만개에 대해서
        // max까지 i*i 를 더해서 체로 거르는 거임
        // 그러면 시그마 (max - min)/ i*i 정도의 개수만 확인하면 됨 (아마도?)

        // 몫은 q, 나눠떨어지지 않으면 +1해줌 올림을 써도 됨
        // 17 / 4 = 4.xxxx => q = 5; 4*5 = 20부터 4의 배수를 세면 되니까
        for (long i = 2; i*i <= max; i++) {
            long pow = i*i;
            long q = min / pow;
            if (min % pow != 0) {
                q += 1;
            }
            for (long j = q; j*pow <= max; j++) {
                int tmp = (int)(j*pow-min);
                if (!check[tmp]) {
                    check[tmp] = true;
                    diff--;

                }
            }
        }
        System.out.println(diff);


    }

}

