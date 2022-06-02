package week1;

import java.io.*;
import java.util.*;

public class Solution_SWEA1865 {
	
	static int N;
	static double pos[][], maxPos;
	static boolean v[];
	
	static void dfs(int now, double nowPos, int cnt) {
		
		if(nowPos*100<=maxPos) return;
		if(cnt==N) {
			if(nowPos*100>maxPos) {
				maxPos = nowPos*100;
			}
			return;
		}
		else if(now==N) return;
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			
			v[i]=true;
			dfs(now+1,nowPos*pos[now][i],cnt+1);
			v[i]=false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			pos = new double[N][N];
			v = new boolean[N];
			maxPos=0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					pos[i][j]=Integer.parseInt(st.nextToken())*0.01;
				}
			}// input
			
			for(int i=0;i<N;i++) {
				dfs(i,1,0);
			}
			
			sb.append(String.format("%.6f",maxPos)).append("\n");
		}// tc fin
		
		System.out.println(sb.toString());
	}
}
