package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ1240 {
	
	static int N, M;
	static List<Node> edges[];
	static int order[];
	
	static class Node{
		int vertex, w;

		public Node(int vertex, int w) {
			super();
			this.vertex = vertex;
			this.w = w;
		}
	}
	
	static int findDist(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		order = new int[N+1];
		order[s]=1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Node next:edges[now]) {
				if (order[next.vertex]!=0 && order[now]+next.w>=order[next.vertex]) continue;
				order[next.vertex]=order[now]+next.w;
				q.add(next.vertex);
			}
		}
		
		return order[e]-1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			edges[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[a].add(new Node(b,w));
			edges[b].add(new Node(a,w));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(findDist(s,e)).append("\n");
		} // input
		
//		for(int i=1;i<=N;i++) {
//			System.out.print(i+" : ");
//			for(Node next:edges[i]) {
//				System.out.print(next.vertex+" ");
//			}
//			System.out.println();
//		}
		System.out.println(sb.toString());
	}
}
