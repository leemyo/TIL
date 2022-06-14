package week3;

import java.io.*;
import java.util.*;

public class Main_1916 {
	
	static int N, M, s_city, e_city;
	static long answer;
	static List<Node>[] list;
	static int v[];
	
	static class Node{
		int end, w;

		public Node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}
	}
	
	static void bfs() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		
		boolean visited[] = new boolean[N+1];
		pq.add(new Node(s_city,0));
		v[s_city]=0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(!visited[n.end]) {
				visited[n.end]=true;
				for(int i=0;i<list[n.end].size();i++) {
					Node now = list[n.end].get(i);
					
					if(v[now.end]>v[n.end]+now.w) {
						v[now.end]=v[n.end]+now.w;
						pq.add(new Node(now.end,v[now.end]));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		v = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
			v[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e,w));
		}
		
		st = new StringTokenizer(br.readLine());
		s_city=Integer.parseInt(st.nextToken());
		e_city=Integer.parseInt(st.nextToken());
	
		bfs();
		System.out.println(v[e_city]);
	} 
}
