package August;

import java.util.*;
import java.io.*;

public class Main_BOJ3020 {

    static int N, H, up[], down[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        up = new int[H+2];
        down = new int[H+2];

        for(int i=0;i<N;i++){
            if(i%2==0) {
                down[Integer.parseInt(br.readLine())]++;
            } else {
                up[H-Integer.parseInt(br.readLine())+1]++;
            }
        } // input

        for(int i=H;i>=1;i--){
            up[i]+=up[i+1];
        }
        for(int i=1;i<=H;i++){
            down[i]+=down[i-1];
        }

        int min_crush=Integer.MAX_VALUE, min_cnt = 0;

        for(int h=1;h<=H;h++){
            int now_crush = (down[H] - down[h - 1]) + (up[1] - up[h + 1]);

            if(now_crush<min_crush) {
                min_cnt=1;
                min_crush=now_crush;
            }
            else if(now_crush==min_crush) min_cnt++;
        }
        System.out.println(min_crush+" "+min_cnt);

    }

}
