import java.io.*;

public class Main {
    static int N,curr = 0;
    static int[] arr;

    static boolean isStackPermutation (int[] arr) {
        int peak = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if ( arr[i] > arr[i+1] + 1) { // 2이상 감소할 때
                int count = arr[i] - arr[i+1] - 1;
                for (int j = 0; j < i+1; j++) {
                    if (arr[j] > arr[i+1] && arr[j] < arr[i]) {
                        count--;
                    }
                }
                if (count!=0) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }
        br.close();

        if (!isStackPermutation(arr)) {
            System.out.println("NO");

        } else {
            StringBuilder sb = new StringBuilder();
            // peak 까지만 push가 일어나고 나머지는 pop해주면 됨

            for (int i = 0; i < N; i++) {
                if (i == 0) { // i = 0 일때 arr[0]만큼 + 출력하고 -출력함
                    sb.append("+");
                    for (int j = 1; j < arr[i]; j++) {
                        sb.append("\n").append("+");
                    }
                    sb.append("\n").append("-");
                    curr = arr[i];
                } else if (curr < arr[i]) {   // curr 보다 높은 값이 나올경우 그 차이만큼 +출력하고 -출력
                    for (int j = 0; j < arr[i] - curr; j++) {
                        sb.append("\n").append("+");
                    }
                    sb.append("\n").append("-");
                    curr = arr[i];
                } else {
                    sb.append("\n").append("-");
                }
            }


            System.out.println(sb);

        }



    }
}
