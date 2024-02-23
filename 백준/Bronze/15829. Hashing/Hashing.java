import java.io.*;

public class Main {
    static long r = 31, M = 1234567891, sum;
    static int length;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        input = br.readLine();
        for (int i = 0; i < length; i++) {
            sum += (long) (input.charAt(i) -'a' + 1) * Math.pow(r,i);
        }
        System.out.println(sum % M);






    }
}
