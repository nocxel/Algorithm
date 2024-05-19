import java.io.*;
import java.util.*;


public class Main {
    static int T, reg, target;
    static String ans;
    static StringTokenizer st;
    static Queue<Node> queue = new LinkedList<>();
    static boolean[] visited;

    static class Node {
        int reg;
        String operator;

        public Node(int reg, String operator) {
            this.reg = reg;
            this.operator = operator;
        }

        public int getReg() {
            return reg;
        }

        public String getOperator() {
            return operator;
        }

        public Node D() {
            int reg = this.reg * 2 % 10000;
            String operator = this.operator + "D";
            return new Node(reg, operator);

        }
        public Node S() {
            int reg = 9999;
            if (this.reg != 0) {
                reg = this.reg - 1;
            }
            String operator = this.operator + "S";
            return new Node(reg, operator);
        }
        public Node L() {
            int reg = (this.reg % 1000) * 10 + ( this.reg / 1000 );
            String operator = this.operator + "L";
            return new Node(reg, operator);
        }
        public Node R() {
            int reg = (this.reg % 10) * 1000 + ( this.reg / 10 );
            String operator = this.operator + "R";
            return new Node(reg, operator);
        }


    }

    static String DSLR(int reg, int target) {
        //bfs로 푼다
        queue.clear();
        Node node = new Node(reg, "");
        queue.add(node);
        visited = new boolean[10000];
        visited[reg] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.getReg() == target) {
                    ans = node.getOperator();
                    return ans;
                }
                addIfNotVisited(node.D(), visited);
                addIfNotVisited(node.S(), visited);
                addIfNotVisited(node.L(), visited);
                addIfNotVisited(node.R(), visited);
            }
        }
        return "";


    }
    static void addIfNotVisited(Node node, boolean[] visited) {
        int reg = node.getReg();
        if (!visited[reg]) {
            visited[reg] =true;
            queue.add(node);
        }
    }

    public static void main(String[] args) throws Exception {
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            reg = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            System.out.println(DSLR(reg, target));
        }


    }
}