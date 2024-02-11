import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean isPalindrome(String str) {
        for (int i = 0; i < ( str.length() / 2 ) ; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ( !(input = br.readLine()).equals("0") ) {
            if (isPalindrome(input)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
