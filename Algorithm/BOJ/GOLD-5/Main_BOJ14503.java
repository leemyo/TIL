package week3;

import java.io.*;
import java.util.*;

public class Main_BOJ14503 {
	
	static int N, M, map[][], answer;
	static int d[][]= {{-1,0},{0,1},{1,0},{0,-1}}; // 북 동 남 서
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
	
    public static void roboVac(int r, int c, int dir) {
        
    	if (map[r][c] == 0) {
            map[r][c] = 2;
            answer++;
        }

        boolean flag = false; // 4방향 청소여부 확인
        int originDir = dir;
        
        for (int i = 0; i < 4; i++) {
            int next_d = (dir + 3) % 4;
            int next_r = r + d[next_d][0];
            int next_c = c + d[next_d][1];

            if (isRange(next_r,next_c)) {
                if (map[next_r][next_c] == 0) { // 청소하기
                	roboVac(next_r, next_c, next_d);
                    flag = true; // 청소하면 true
                    break;
                }
            }
            dir = (dir + 3) % 4;
        }

        if (!flag) {//후진해야하는 상황
            int nextdir = (originDir + 2) % 4;
            int nextr = r + d[nextdir][0];
            int nextc = c + d[nextdir][1];

            if (isRange(nextr,nextc)) {
                if (map[nextr][nextc] != 1) { // 벽이 아니어야함 
                	roboVac(nextr, nextc, originDir);
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //input
        
        roboVac(r, c, d);
        
        System.out.println(answer);
        br.close();
    }
}
