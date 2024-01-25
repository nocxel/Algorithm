import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
        // 정규식
		while (testCase-- > 0) answer.append(br.readLine().matches("(100+1+|01)+") ? "YES\n" : "NO\n");

		System.out.println(answer);
	}
}
