package week4;

import java.util.*;
import java.io.*;

public class Main_BOJ3273 {
	
	static int N, arr[], x, answer;
	
	static void findPair() {
		int l=1, r=N;
		
		while(l<r) {
			if(N==1) break;
			if(arr[l]+arr[r]==x) {
				answer++;
				if(arr[l+1]-arr[l]>arr[r]-arr[r-1]) r--;
				else l++;
			}
			else {
				if(arr[l]+arr[r]>x) r--;
				else l++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		findPair();
		System.out.println(answer);
	}

}
