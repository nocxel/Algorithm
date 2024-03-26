import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static List<Meeting> meetingList = new ArrayList<>();

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Meeting meeting = new Meeting(start, end);
            meetingList.add(meeting);
        }

        Collections.sort(meetingList);

        int cnt = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            Meeting meeting = meetingList.get(i);
            if (prev <= meeting.getStart()) {
                prev = meeting.getEnd();
                cnt ++;
            }
        }

        System.out.println(cnt);

        
        




    }
}

class Meeting implements Comparable<Meeting> {
    private int start;
    private int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end < o.end) {
            return -1;
        } else if (this.end > o.end) {
            return 1;
        } else {
            if (this.start <= o.start) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}