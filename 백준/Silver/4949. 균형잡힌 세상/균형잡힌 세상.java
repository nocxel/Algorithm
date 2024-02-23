import java.io.*;
import java.util.Stack;

public class Main {
    static String input;


    static boolean isBalanceState(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((input = br.readLine()) != null && !input.equals(".")) {
            if (isBalanceState(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }




    }
}
