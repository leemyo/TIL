package week2;

import java.io.*;
import java.util.*;

public class Main_BOJ11052 {

	static int N, card[], dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N+1];
		dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				if(dp[i]<dp[i-j]+card[j]) dp[i]=dp[i-j]+card[j];
			}
		}
		
		System.out.println(dp[N]);
		br.close();
	}
}
