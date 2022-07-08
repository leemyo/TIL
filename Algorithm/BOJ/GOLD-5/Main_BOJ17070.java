package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ17070 {
	
	static int N, answer, map[][];
	
	static void dfs(int r, int c, int dir) {
		
		if(r==N-1 && c==N-1) {
			answer++;
			return;
		}
		
		if(dir==0) {//-
			if(r<N && c+1<N && map[r][c+1]==0) dfs(r,c+1,0);
		}
		else if(dir==1) {//아래대각선
			if(r<N && c+1<N && map[r][c+1]==0) dfs(r,c+1,0);
			if(r+1<N && c<N && map[r+1][c]==0) dfs(r+1,c,2);
		}
		else {//|
			if(r+1<N && c<N && map[r+1][c]==0) dfs(r+1,c,2);
		}
		
		if(r+1<N && c+1<N && map[r+1][c+1]==0 && map[r][c+1]==0 && map[r+1][c]==0) dfs(r+1,c+1,1);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input
		
		dfs(0,1,0);
		System.out.println(answer);
	}
}
