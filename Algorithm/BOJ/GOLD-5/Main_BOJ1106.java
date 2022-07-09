package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ1106 {

	static int N, C, answer, dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken()); // 최소 고객
		N = Integer.parseInt(st.nextToken());
		dp = new int[C+101]; // 달성 고객 + 도시 최대 고객
		Arrays.fill(dp, 1000001);
		dp[0]=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			for(int j=customer;j<C+101;j++) {
				dp[j] = Math.min(dp[j], dp[j-customer]+cost);
			}
			
		} // input
		
		answer = 1000001;
		for(int i=C;i<C+101;i++) { // 달성 고객 ~ 최소 비용 구하기
			answer = Math.min(answer, dp[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
