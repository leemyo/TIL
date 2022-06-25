package week4;

import java.io.*;
import java.util.*;

public class Main_BOJ3067 {
	
	static int N, coins[], M;
	static long answer, dp[];
	
	static long solution() {
		answer=0;
		dp = new long[10002]; // 최대 10000
		dp[0]=1;
		
		for(int i=0;i<N;i++) {
			for(int j=coins[i];j<=M;j++) {
				dp[j]+=dp[j-coins[i]];
			}
		}
		return dp[M];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				coins[i]=Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			// input
			
			answer = solution();
			sb.append(answer).append("\n");
		} // tc fin
	
		System.out.println(sb.toString());
	}
}
