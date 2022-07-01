package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ5549 {
	
	static int N, M, K;
	static char map[][];
	static Node dp[][];
	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		public int j, o, i;

		public Node(int j, int o, int i) {
			super();
			this.j = j;
			this.o = o;
			this.i = i;
		}
	}
	
	static void searchArea(int a, int b, int c, int d) {
		int jCnt = dp[c][d].j;
		if(a>0 && d>=0) jCnt-=dp[a-1][d].j;
		if(c>=0 && b>0) jCnt-=dp[c][b-1].j;
		if(a>0 && b>0) jCnt+=dp[a-1][b-1].j;
		
		int oCnt = dp[c][d].o;
		if(a>0 && d>=0) oCnt-=dp[a-1][d].o;
		if(c>=0 && b>0) oCnt-=dp[c][b-1].o;
		if(a>0 && b>0) oCnt+=dp[a-1][b-1].o;
		
		int iCnt = dp[c][d].i;
		if(a>0 && d>=0) iCnt-=dp[a-1][d].i;
		if(c>=0 && b>0) iCnt-=dp[c][b-1].i;
		if(a>0 && b>0) iCnt+=dp[a-1][b-1].i;
		
		sb.append(jCnt).append(" ").append(oCnt).append(" ").append(iCnt).append("\n");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new char[M][N];
		dp = new Node[M][N];
		
		for(int k=0;k<M;k++) {
			String str = br.readLine();
			for(int l=0;l<N;l++) {
				map[k][l] = str.charAt(l);
				
				if(map[k][l]=='J') dp[k][l] = new Node(1,0,0);
				else if(map[k][l]=='O') dp[k][l] = new Node(0,1,0);
				else dp[k][l] = new Node(0,0,1);
				
				if(k==0 && l==0) {}
				else if(k==0) {
					dp[k][l].j+=dp[k][l-1].j;
					dp[k][l].o+=dp[k][l-1].o;
					dp[k][l].i+=dp[k][l-1].i;
				}
				else if(l==0) {
					dp[k][l].j+=dp[k-1][l].j;
					dp[k][l].o+=dp[k-1][l].o;
					dp[k][l].i+=dp[k-1][l].i;
				}
				else {
					dp[k][l].j+=dp[k][l-1].j;
					dp[k][l].o+=dp[k][l-1].o;
					dp[k][l].i+=dp[k][l-1].i;
					
					dp[k][l].j+=dp[k-1][l].j;
					dp[k][l].o+=dp[k-1][l].o;
					dp[k][l].i+=dp[k-1][l].i;
					
					dp[k][l].j-=dp[k-1][l-1].j;
					dp[k][l].o-=dp[k-1][l-1].o;
					dp[k][l].i-=dp[k-1][l-1].i;
				}
			}
		} // map
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			
			searchArea(a,b,c,d);
		}
		
		System.out.println(sb.toString());
	}
}
