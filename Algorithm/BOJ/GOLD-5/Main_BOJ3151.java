package week3;

import java.io.*;
import java.util.*;

public class Main_3151 {
	
	static int N, student[];
	static long answer;
	
	static int findLow(int l, int r, int key) {
		int mid;
		while(l<r) {
			mid = (l+r)/2;
			if(student[mid]>=key) r=mid;
			else l=mid+1;
		}
		return r;
	}
	
	static int findHigh(int l, int r, int key) {
		int mid;
		while(l<r) {
			mid = (l+r)/2;
			if(student[mid]>key) r=mid;
			else l=mid+1;
		}
		return l;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		student = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			student[i] = Integer.parseInt(st.nextToken());
		} // input
		
		Arrays.sort(student);

		for(int f=0;f<N-1;f++) {
			for(int r=f+1;r<N;r++) {
				int key = -(student[f]+student[r]); //내가 찾는 값
				
				//중복을 위해
				int rowBound = findLow(r+1,N,key);
				if(rowBound==N || student[rowBound]!=key) continue; // 중복 없으므로 넘겨도 됨
				int highBound = findHigh(r+1,N,key);
				answer+=(highBound-rowBound);
			}
		}
		
		System.out.println(answer);
	}
}
