import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 문제 알파벳 i개 di = i번째 알파벳 인덱스
    // d1 + d2 + d3 ... + di = N
    // di는 가능한 최대값을 가져야함 (최대값에서 감소하는 식으로 짜야겠다)
    //      ex) N = 12; 1236하면 안됨 (1245하면 더 빠른 String이 구성되므로)
    // d(i-1) < di <= sum(d1,d2,...,d(i-1))+1
    // d값들의 합이 N을 못 만들면 탈출하고 -1 출력하기

    static int N;

    // N이 100이하라서 알파벳 7개로 127길이까지 가능하기 때문에 7개짜리 배열을 생성
    static int[] alphabetIdx = new int[7];

    // 현재 조건으로 만들 수 있는 수인지 판별하는 식 (백트래킹으로 가망없는 노드에서의 탐색을 줄인다.)
    // 현재 조건에서의 가능성을 모두 체크해서 현재 조건으로 돌아오는 일이 없도록 해야한다.
    // 현재 조건 = 마지막 인덱스, sum값
    static boolean isPossible(int idx, int sum, int N) {
        boolean result = false; // 마지막 인덱스, sum값으로 N을 만들수있는가?
        int min = sum, max = sum;
        int maxIdx = (int) (Math.log(N) / Math.log(2)) + 1; // i개면 2^i - 1 까지 만들 수 있다

        for (int i = 0; i < maxIdx - idx; i++) {
            min += alphabetIdx[idx - 1] + i + 1;
            max += sum + i + 1;
            sum += sum + 1;
        }
        if (min <= N && N <= max) {
            result = true;
        }
        return result;
    }

    static boolean isValid;
    static void bt(int i, int sum) { // i는 현재 di 값, sum은 d1 ~ d[i-1] 까지 합한 값
        // 실패조건 : 가능하지 않은 sum값이 나올 경우 ex) dt(1,0)
        // 여기서는 최대값부터 탐색을 시작해서 sum을 점점 감소시키므로 sum의 하한보다 작아지면 실패하게 된다
        if (N <= 0 || sum < (i*(i+1)) /2 ) {
            isValid = false;
            return;
        }
        // 성공조건 : 합이 N이 되면 성공
        if (sum == N) {
            isValid = true;
            return;
        }
        // alphabetIdx[i] 최대값 = sum + 1;
        // alphabetIdx[i] 최소값 = alphabetIdx[i-1];
        if (i == 0) {
            alphabetIdx[i] = 1;
            sum += alphabetIdx[i];
            bt(i+1, sum);
        } else if ( !isPossible(i, sum, N) ) {
            // 만들 수 없는 수 일 때 감소 시킴 (최소값보다 적게 남았을 때로 하면 안된다 다시 판별 해야할 수 있다)
            alphabetIdx[i - 1]--;
            //System.out.println(alphabetIdx[i - 1]);
            sum--;
            bt(i, sum);
        } else if (sum + 1 < N - sum) { // 최대 값 보다 많이 남았을 때
                alphabetIdx[i] = sum + 1;
                sum += alphabetIdx[i];
                bt(i+1, sum);
        } else {
            alphabetIdx[i] = N-sum;
            bt(i+1, N);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bt(0,0);

        // 배열로 문자열 만들어서 출력하기
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bw = new BufferedWriter(stringWriter);
        Queue<Integer> queue = new LinkedList<>();
        int idx = 0;
        if (isValid) {
            for (int i = 0; i < N; i++) {
                if( idx < 7 && i+1 == alphabetIdx[idx] ) {
                    bw.append( (char)( 'A'+ idx ) );
                    alphabetIdx[idx]--;
                    for (int k = 0; k < alphabetIdx[idx]; k++) {
                        queue.offer(idx);
                    }
                    idx++;
                } else {
                    int intValue = queue.poll();
                    char charValue = (char) ('A' + intValue);
                    bw.append(charValue);
                }
            }
        } else {
            System.out.println(-1);
        }


        bw.flush();
        System.out.println(stringWriter);



    }
}
