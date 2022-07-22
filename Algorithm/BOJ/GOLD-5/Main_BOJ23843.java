package July.week3;

import java.io.*;
import java.util.*;

public class Main_BOJ23843 {

    static int N, M;
    static PriorityQueue<Integer> time = new PriorityQueue<>((a,b)->b-a);
    static PriorityQueue<Integer> outlet = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            time.add(Integer.parseInt(st.nextToken()));
        } // input

        for(int i=0;i<M;i++){
            outlet.add(0);
        }

        while(!time.isEmpty()){
            int t = time.poll();
            int o = outlet.poll();
            outlet.add(o+t);
        }

        while(outlet.size()!=1) outlet.poll();
        System.out.println(outlet.poll());
        br.close();
    }
}
