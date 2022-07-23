package July.week4;

import java.io.*;
import java.util.*;

public class Main_BOJ1107 {

    static int N, M, answer;
    static boolean btn[];


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        btn=new boolean[10];
        int cnt=0;
        if(M!=0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                btn[Integer.parseInt(st.nextToken())]=true;
                cnt++;
            }
        }

        answer = Math.abs(100-N); // 방향키로만 움직였을때
        for(int channel=0;channel<=999_999;channel++){
            String str_ch = String.valueOf(channel);
            boolean flag = false;
            for(int i=0;i<str_ch.length();i++){
                if (btn[str_ch.charAt(i)-'0']) {
                    flag=true; break;
                }
            } // 안 고장난 버튼으로 갈 수 있는지 확인
            if(flag) continue;

            // 가진 버튼으로 갈 수 있으면
            answer = Math.min(answer,str_ch.length()+Math.abs(N-channel));
        }

        System.out.println(answer);
        br.close();
    }
}
