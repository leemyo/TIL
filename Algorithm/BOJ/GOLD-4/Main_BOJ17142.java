package week3;

import java.io.*;
import java.util.*;

public class Main_BOJ17142 {

	static int N, M, map[][], answer, zeroCnt;
	static int d[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static List<Virus> virus = new LinkedList<>();
	static boolean visited[];
	
	static class Virus{
		int r,c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static int spreadVirus() {
		Queue<Virus> q = new LinkedList<>();
		
		int bfsVisit[][] = new int[N][N];
		
		for(int i=0;i<virus.size();i++) {
			if(visited[i]) {
				Virus v = virus.get(i);
				q.add(new Virus(v.r,v.c));
				bfsVisit[v.r][v.c] = 1;
			}
		}
		
		int cnt=zeroCnt;
		int maxCnt=0;
		
		while(!q.isEmpty()) {
			Virus now = q.poll();
			for(int i=0;i<4;i++) {
				int newr = now.r+d[i][0];
				int newc = now.c+d[i][1];
				
				if(!isRange(newr,newc)) continue;
				if(map[newr][newc]==1) continue;
				if(bfsVisit[newr][newc]!=0) continue;
				bfsVisit[newr][newc]=bfsVisit[now.r][now.c]+1;
				q.add(new Virus(newr,newc));
				
				cnt--;
			}
		}
		if(cnt!=0) return Integer.MAX_VALUE;
		else {

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==0) {
						maxCnt = Math.max(bfsVisit[i][j], maxCnt);
					}
				}
			}
			return maxCnt;
		}
	}
	
	static void cmb(int idx, int cnt) {
		if(cnt==M) { // 해당 경우 값 구하고, ANSWER와 비교.
			int now = spreadVirus();
			if(now==-1) return;
			answer = Math.min(now, answer);
			return;
		}
		
		for(int i=idx;i<virus.size();i++) {
			if(visited[i]) continue;
			
			visited[i]=true;
			cmb(i+1,cnt+1);
			visited[i]=false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus.add(new Virus(i,j)); //바이러스 정보 저장 리스트에
					zeroCnt++;
				}
				else if(map[i][j]==0) zeroCnt++;
			}
		} // input
		
		answer=Integer.MAX_VALUE;
		visited = new boolean[virus.size()];
		zeroCnt-=M;
		cmb(0,0); //M개만큼 COMBINATION
		
		//ANSWER가 마지막에도 기본값이면 -1 출력
		if(answer==Integer.MAX_VALUE) answer=0;
		if((zeroCnt-virus.size()+M)==0) answer=1;
		System.out.println(answer-1);
		
	}
}
