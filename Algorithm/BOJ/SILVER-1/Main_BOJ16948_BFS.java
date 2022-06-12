package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ16948_BFS {
	
	static int N, map[][];
	static int d[][] = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
	static Node sPos,ePos;
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(sPos);
		map[sPos.r][sPos.c]=1;
		map[ePos.r][ePos.c]=Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(map[ePos.r][ePos.c]<=map[now.r][now.c]) return;
			for(int i=0;i<6;i++) {
				int nr = now.r+d[i][0];
				int nc = now.c+d[i][1];
				
				if(!isRange(nr,nc)) continue;
				if(map[now.r][now.c]+1>=map[nr][nc] && map[nr][nc]!=0) continue;
				
				map[nr][nc] = map[now.r][now.c]+1;
				q.add(new Node(nr,nc));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sPos = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		ePos = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		bfs();
		
		if(map[ePos.r][ePos.c]==Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(map[ePos.r][ePos.c]-1);
	}
}
