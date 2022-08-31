import java.util.*;
import java.io.*;

public class Main_BOJ13904 {

    static int N, maxdate, answer;
    static Node[] hw;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable{
        int due, point;

        public Node(int due, int point) {
            this.due = due;
            this.point = point;
        }

        @Override
        public int compareTo(Object o) {
            Node o1 = (Node) o;
            if(o1.point != this.point) return o1.point-this.point; // 내림차순
            else return this.due-o1.due; // 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        hw = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 남은 일수
            int w = Integer.parseInt(st.nextToken()); // 과제 점수
            hw[i] = new Node(d,w);
            maxdate = Math.max(maxdate,d);
        }
        for (int today = maxdate; today > 0 ; today--) {
            for (int i = 0; i < N ; i++) {
                if(hw[i].due>=today) {
                    pq.add(new Node(hw[i].due,hw[i].point));
                    hw[i].due=-1;
                }
            }
            if(pq.size()==0) continue;
            else{
                Node n = pq.poll();
                answer+=n.point;
            }
        }

        System.out.println(answer);

    }

}
