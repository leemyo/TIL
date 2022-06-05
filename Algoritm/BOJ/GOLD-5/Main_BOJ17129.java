package week2;

import java.io.*;
import java.util.*;

public class Main_BOJ17129 {
	
	static int N, M, map[][], answer;
	static int d[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static Node s;
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(s);
		int v[][] = new int[N][M];
		v[s.r][s.c]=1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr = n.r+d[i][0];
				int nc = n.c+d[i][1];
				
				if(!isRange(nr,nc)) continue;
				if(v[nr][nc]<=v[n.r][n.c]+1 && v[nr][nc]!=0) continue;
				if(map[nr][nc]==1) continue;
				if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==5) {
					answer = v[n.r][n.c]+1;
					return;
				}
				v[nr][nc]=v[n.r][n.c]+1;
				q.add(new Node(nr,nc));
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
				if(map[i][j]==2) {
					s = new Node(i,j);
				}
			}
		} // input
		
		answer=0;
		bfs();
		
		if(answer==0) { // 도달 못 함.
			System.out.println("NIE");
		}
		else {
			System.out.println("TAK");
			System.out.println(answer-1);
		}
	}
}