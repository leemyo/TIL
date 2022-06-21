package week4;

import java.util.*;
import java.io.*;

public class Main_BOJ20040 {
	
	static int N, M, answer;
	static int vertex[];
	static boolean flag;
	
	static void initUnion() {
		for(int i=0;i<N;i++) {
			vertex[i]=i;
		}
	}
	
	static void makeUnion(int x, int y) {
		int rootx = findUnion(x);
		int rooty = findUnion(y);
		if(rootx!=rooty) vertex[rooty]=rootx;
		else {
			flag=true;
		}
	}
	
	static int findUnion(int x) {
		if(vertex[x]==x) return x;
		else {
			vertex[x]=findUnion(vertex[x]);
			return vertex[x];
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		vertex = new int[N];
		initUnion(); //초기화
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			if(flag) continue;
			if(!flag) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				makeUnion(x,y);
				if(flag) answer=i+1;
			}
		}
		
		System.out.println(answer);
	}
}
