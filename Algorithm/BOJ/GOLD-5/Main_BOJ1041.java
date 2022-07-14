package week2;

import java.io.*;
import java.util.*;

public class Main_BOJ1041 {
	
	static long N, dice[];
	static long answer, two, three;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new long[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min_one = 51;
		long max_one = 0;
		for(int i=0;i<6;i++) {
			dice[i]=Integer.parseInt(st.nextToken());
			min_one = Math.min(min_one, dice[i]);
			max_one = Math.max(max_one, dice[i]);
		}
		
		two = Long.MAX_VALUE;
		for(int i=0;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				if(i+j==5) continue;
				two = Math.min(two, dice[i]+dice[j]);
			}
		}
		
		for(int i=0;i<3;i++) {
			three+=Math.min(dice[i], dice[5-i]);
		}
		
		if(N==1) {
			for(int i=0;i<6;i++) answer+=dice[i];
			answer-=max_one;
		}
		
		else {
			long tmp=0;
			
			tmp=(N-2)*(N-2)*5 + (N-2)*4;
			answer=tmp*min_one; // 1면
			
			tmp=(N-2)*8 + 4;
			answer+=tmp*two; // 2면
			
			answer+=4*three; //3면
		}
		
		System.out.println(answer);
	}
}
