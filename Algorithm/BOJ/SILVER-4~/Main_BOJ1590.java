package July.week3;

import java.io.*;
import java.util.*;

public class Main_BOJ1590 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, T;
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int inter = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            int maxBusTime=s+inter*(cnt-1);
            if(maxBusTime<T) continue;
            if(s>=T){
                answer = Math.min(answer, s-T);
            }
            else{
                int rest = (T-s)%inter;
                if(rest==0) answer = 0;
                else answer = Math.min(answer, inter-rest);
            }
        }

        if(answer==Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(answer);

        br.close();
    }
}
