package July.week4;

import java.io.*;

public class Main_BOJ2138 {

    static int N, answer;
    static boolean before[], after[], change[][];

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        before = new boolean[N];
        after = new boolean[N];
        change = new boolean[2][N];

        String str = br.readLine();
        for(int i=0;i<N;i++){
            if(str.charAt(i)-'0'==0) before[i]=false;
            else before[i]=true;
            change[0][i] = before[i];
            change[1][i] = before[i];
        }

        str = br.readLine();
        for(int i=0;i<N;i++){
            if(str.charAt(i)-'0'==0) after[i]=false;
            else after[i]=true;
        }

        change[0][0]=false;
        change[1][0]=true;
        answer= Integer.MAX_VALUE;

        for(int i=0;i<2;i++){
            int cnt =0;
            if(change[i][0]!=before[0]) {
                change[i][1]=!change[i][1];
                cnt++;
            }
            for(int j=1;j<N;j++){
                if(change[i][j-1]!=after[j-1]){ // 바꿔야 하는 경우
                    cnt++;
                    change[i][j-1]=after[j-1];
                    change[i][j]=!change[i][j];
                    if(j==N-1) continue;
                    change[i][j+1]=!change[i][j+1];
                }
            }
            if(change[i][N-2]== after[N-2] && change[i][N-1]== after[N-1]) {
                answer = Math.min(answer,cnt);
            }

        }

        answer = (answer == Integer.MAX_VALUE)? -1:answer;
        System.out.println(answer);
        br.close();
    }

}
