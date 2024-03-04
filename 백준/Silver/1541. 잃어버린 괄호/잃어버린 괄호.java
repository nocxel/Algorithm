import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static String input;
    static int result=0, curr = 0, idx = 0, value;
    static boolean isMinus;

    // -가 나오면 isMinus를 true로 설정하고 이후 연산을 curr값에 최대한 키워서 저장하여 result값에서 빼준다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                value = Integer.parseInt( input.substring(idx,i) );
                //System.out.println(value);
                idx = i+1;
                if (isMinus) {
                    curr += value;
                    result -= curr;
                    curr = 0;
                } else {
                    result += value;
                    isMinus = true;
                }
            }

            if (input.charAt(i) == '+') {
                value = Integer.parseInt( input.substring(idx,i) );
                idx = i+1;
                if (isMinus) {
                    curr += value;
                }else {
                    result += value;
                }
            }
            if (i == input.length() - 1) {
                //System.out.println(i);
                value = Integer.parseInt( input.substring(idx, i+1) );
                //System.out.println(value);
                if (isMinus) {
                    curr += value;
                    result -=curr;
                } else {
                    result += value;
                }

            }
        }

        System.out.println(result);



    }
}