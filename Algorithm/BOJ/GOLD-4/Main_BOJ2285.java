package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ2285 {

	static int N;
	static long total;
	static PriorityQueue<Node> pq;
	
	static class Node {
		int x, a;

		public Node(int x, int a) {
			super();
			this.x = x;
			this.a = a;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>((p,q)-> p.x - q.x);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			Node n = new Node(x,a);
			pq.add(n);
			total+=a;
		} // input
		
		long nowTotal = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			nowTotal+=n.a;
			if(nowTotal>=(total+1)/2) {
				System.out.println(n.x);
				break;
			}
		}
		
	}
}
