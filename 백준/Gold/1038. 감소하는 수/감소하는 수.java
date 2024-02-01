import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int count = 0;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1씩증가시켜서 구하려니까 한 세월걸림
        // 백트래킹으로 조합을 만들어서 리스트에 넣고 sort할거임
        // 이러면 1022개 list를 다 만들어버리고 N번째 요소를 출력하는 형식으로
        if (N < 10) System.out.println(N);
        else if(N > 1022) System.out.println(-1);

        // 앞 자리를 1 ~ 9로 결정해서 DFS 로 보냄
        else {
            for (int i = 0; i < 10; i++) {
                DFS(i);
            }
            Collections.sort(list);
            System.out.print(list.get(N));
        }
    }

    public static void DFS(long num) {
        list.add(num);
        long modNum = num % 10;
        // 0으로 끝난경우 더 붙일 수 없으므로 그대로 종료
        if (modNum == 0) {
            return;
        }
        // 앞자리보다 작은 숫자를 뒤에 붙여서 재귀
        for (long i = modNum - 1; i >= 0; i--) {
            long newValue = (10 * num) + i;
            DFS(newValue);
        }

    }


}

