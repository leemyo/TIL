import java.io.*;
import java.util.*;

public class Main_BOJ1520 {

    static int N, M, map[][], dp[][];
    static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    static boolean isRange(int r, int c){
        return 0<=r && r<M && 0<=c && c<N;
    }

    static int dfs(int r, int c) {// 해당 위치에서 도착지까지 경로 개수
        if(r==M-1 && c==N-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];

        dp[r][c]=0;
        for (int i = 0; i < 4; i++) {
            int nr = r + d[i][0];
            int nc = c + d[i][1];

            if(!isRange(nr,nc)) continue;
            if(map[nr][nc]>=map[r][c]) continue;

            dp[r][c]+=dfs(nr,nc);
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        } // input

        System.out.println(dfs(0,0));
    }
}