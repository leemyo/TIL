package week2;

import java.io.*;
import java.util.*;

public class Main_BOJ2157 {

	static int N, M, K, map[][], dp[][], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		dp = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			if(a>=b) continue;
			map[a][b] = Math.max(map[a][b], c);
		}

		
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (i == 1) {
					dp[i][j] = Math.max(dp[i][j], dp[0][0] + map[0][j]);
				}
				else {					
					if(dp[i-1][j] != 0) {
						for (int k = j; k < N; k++) {
							if(map[j][k] != 0)
								dp[i][k] = Math.max(dp[i][k], dp[i-1][j] + map[j][k]);								
						}
					}
				}
			}
		}
		
		for (int i = 0; i < M; i++)
			answer = Math.max(answer, dp[i][N-1]);
		
		System.out.println(answer);
		br.close();

	}
}