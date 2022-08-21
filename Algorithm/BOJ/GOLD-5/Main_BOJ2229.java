package August;

import java.io.*;
import java.util.*;

public class Main_BOJ2229 {

    static int N, answer, score[], dp[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        } // input
        dp[1] = Math.abs(score[0]-score[1]);

        for(int i=2;i<N;i++){

            int max = score[i];
            int min = score[i];

            for (int j = i; j >= 1; j--) {
                max = Math.max(max, score[j]);
                min = Math.min(min, score[j]);

                if(dp[j-1]+(max-min)>dp[i]) dp[i] = dp[j-1]+(max-min);
            }
        }

        System.out.println(dp[N-1]);
        br.close();
    }
}