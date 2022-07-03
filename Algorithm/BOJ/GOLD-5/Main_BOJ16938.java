package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ16938 {

	static int N, L, R, X;
	static int level[], answer;
	static boolean v[];
	
	static void dfs(int idx, int maxq, int minq, long sum, int cnt) {
		
		for(int i=idx;i<N;i++) {
			if(v[i] || sum>R) continue;
		
			int tmpmax = Math.max(maxq, level[i]);
			int tmpmin = Math.min(minq, level[i]);
			v[i]=true;
			if(cnt>=1) {
				if(tmpmax-tmpmin>=X && L<=sum+level[i] && sum+level[i]<=R) {
					answer++;
				}
			}
			dfs(i+1, tmpmax, tmpmin, sum+level[i], cnt+1);
			v[i]= false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		level = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			level[i] = Integer.parseInt(st.nextToken());
		} // input
		
		dfs(0,0,1_000_001,0,0);
		System.out.println(answer);
		
	}
}