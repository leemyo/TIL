package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ1325 {
	
	static int N, M, maxCnt;
	static List<Integer>[] list;
	static int cnt[];
	
	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		boolean v[] = new boolean[N+1];
		
		q.add(i);
		v[i]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next:list[now]) {
				if(v[next]) continue;
				v[next]=true;
				q.add(next);
				cnt[next]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		cnt = new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		} //input
		
		for(int i=1;i<=N;i++) {
			bfs(i);
		}
		
		PriorityQueue<Integer> answer = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			if(maxCnt==cnt[i]) answer.add(i);
			else if(maxCnt<cnt[i]) {
				maxCnt=cnt[i];
				answer.clear();
				answer.add(i);
			}
		}
		
		while(!answer.isEmpty()) {
			sb.append(answer.poll()).append(' ');
		}
		System.out.println(sb.toString());
	}
}