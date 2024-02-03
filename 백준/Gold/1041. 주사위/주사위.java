import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dice = new int[6];
    static long minScale01 = Long.MAX_VALUE;
    static long minScale02 = Long.MAX_VALUE;
    static long minScale03 = Long.MAX_VALUE;
    static long maxScale01 = Long.MIN_VALUE;
    static int sumDice = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        // 1면 최소값, 최대값, 총 합계 구하기
        for (int i = 0; i < 6; i++) {
            if (dice[i] < minScale01) minScale01 = dice[i];
            if (dice[i] > maxScale01) maxScale01 = dice[i];
            sumDice += dice[i];
        }
        // 2면 최소값 (A-F,B-E,C-D는 고를 수 없음, => i+j!=6이어야 함)
        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 6; j++) {
                if (i!=j && i + j != 5 && dice[i]+dice[j] < minScale02) {
                    minScale02 = dice[i] + dice[j];
                }
            }
        }
        // 3면 최소값 (주사위에서 마주보지 않는 면들을 모았을 떄 최소값)
        // A,F 중 최소 + B,E 중 최소 + C,D중 최소 이렇게 더하면 최소값임
        minScale03 = Math.min(dice[0],dice[5]) + Math.min(dice[1],dice[4]) + Math.min(dice[2],dice[3]);
//        탐색 연습도 해봤다
//        boolean[] visited = new boolean[6];
//        for (int i = 0; i < 6; i++) {
//            visited[i] = true;
//            for (int j = 0; j < 6; j++) {
//                if (visited[j] || visited[5-j]) continue;
//                visited[j] = true;
//                for (int k = 0; k < 6; k++) {
//                    if (!visited[k] && !visited[5-k]) {
//                        int sum = dice[i] + dice[j] + dice[k];
//                        if (sum < minScale03) {
//                            minScale03 = sum;
//                            System.out.println("i: " + i + " j : " + j +" k: " + k);
//                        }
//                        visited[k] = false;
//                    }
//                }
//                visited[j] = false;
//            }
//            visited[i] = false;
//        }

        if (N == 1) {
            System.out.println(sumDice - maxScale01);
            return;
        } else { // N이 2 이상 일 때의 규칙을 이용하자
            long answer = 0;
            // 3면은 언제나 4개 (맨 윗면 모서리)
            // 2면은 (바닥면의 모서리 4개) + 8*(N-2) (변이 8개)
            // 1면은 5(N-2)^2 (보이는 5면들의 가운데 부분) + 4*(N-2) (바닥면의 변) = 5N^2 - 16N + 12 = (5N - 6) * (N - 2)
            // 형변환 주의
            answer += 4 * minScale03;
            answer += (long)((8 * N) - 12) * minScale02;
            answer += (long)((5*N) - 6) * (N - 2) * minScale01;
            System.out.println(answer);



        }








        // 최소값들을 찾아야함



    }


}

