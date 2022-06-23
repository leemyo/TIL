package week4;

import java.io.*;
import java.util.*;

public class Main_BOJ2667 {
	
	static int N, aptCnt, map[][];
	static int d[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean v[][];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		v[r][c]=true;
		int cnt=1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr = now[0]+d[i][0];
				int nc = now[1]+d[i][1];
				
				if(!isRange(nr,nc)) continue;
				if(v[nr][nc] || map[nr][nc]!=1) continue;
				
				v[nr][nc]=true;
				cnt++;
				q.add(new int[] {nr,nc});
			}
		}
		
		pq.add(cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		v = new boolean[N][N];
		String str;
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		} // input
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !v[i][j]) {
					aptCnt++;
					bfs(i,j);
				}
			}
		}
		
		sb.append(aptCnt).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
