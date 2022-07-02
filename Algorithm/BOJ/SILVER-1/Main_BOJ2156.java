package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ2156 {
	
	static int N, wine[], dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wine = new int[N];
		dp = new int[N];
		
		for(int i=0;i<N;i++) {
			wine[i] = Integer.parseInt(br.readLine());
		} // input
		
		dp[0]=wine[0];
		
		for(int i=1;i<N;i++) {
			if(i==1) dp[1]=wine[0]+wine[1];
			else if(i==2) dp[2]=Math.max(wine[0]+wine[1], Math.max(wine[0]+wine[2], wine[1]+wine[2]));
			else dp[i]=Math.max(dp[i-1], Math.max(dp[i-3]+wine[i-1], dp[i-2])+wine[i]);
		}
		
		System.out.println(dp[N-1]);
	}
}
