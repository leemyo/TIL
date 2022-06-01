package week1;

import java.io.*;
import java.util.*;

public class Main_BOJ16948_DFS {
	
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
	
	static void dfs(int r, int c) {
		
		if(map[ePos.r][ePos.c]<=map[r][c]) return;
		
		for(int i=0;i<6;i++) {
			int nr = r+d[i][0];
			int nc = c+d[i][1];
			
			if(!isRange(nr,nc)) continue;
			if(map[r][c]+1>=map[nr][nc] && map[nr][nc]!=0) continue;
			
			map[nr][nc] = map[r][c]+1;
			dfs(nr,nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sPos = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		ePos = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		map[sPos.r][sPos.c]=1;
		map[ePos.r][ePos.c]=Integer.MAX_VALUE;
		
		dfs(sPos.r, sPos.c);
		
		if(map[ePos.r][ePos.c]==Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(map[ePos.r][ePos.c]-1);
	}
}
