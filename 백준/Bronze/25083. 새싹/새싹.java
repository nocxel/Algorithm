import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append("         ,r'\"7").append("\n");
        bw.append("r`-_   ,'  ,/").append("\n");
        bw.append(" \\. \". L_r'").append("\n");
        bw.append("   `~\\/").append("\n");
        bw.append("      |").append("\n");
        bw.append("      |");
        bw.close();
        System.out.println(bw);

    }
}

