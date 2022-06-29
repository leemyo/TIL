package week4;

import java.io.*;
import java.util.*;

public class Main_BOJ3190 {
	
	static int N, K, L, map[][], sec;
	static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}}; // 0 90 180 270
	static Queue<Node> changeDir = new LinkedList<>();
	
	static class Node{
		int x;
		char d;
		public Node(int x, char d) {
			super();
			this.x = x;
			this.d = d;
		}
	}
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static void dummy() {		
		Queue<int[]> snake = new LinkedList<>();
		
		int[] pos = new int[] {0,0};
		int nowDir = 1; // 오른쪽 보고 있다. = 90
		snake.add(new int[] {0,0});
		map[0][0]=1; // 뱀 위치 중
		
		Node next = changeDir.poll(); // L은 1보다 크므로
		
		while(true) {
			int nr = pos[0]+dir[nowDir][0];
			int nc = pos[1]+dir[nowDir][1];
			
			// 벽 또는 자기 자신과 부딪히면 게임 끝
			if(!isRange(nr,nc)) break;
			if(map[nr][nc]==1) break;
			
			sec++;
			//위치 이동
			pos[0] = nr;
			pos[1] = nc;
			
			if(map[nr][nc]==0) { // 사과 없는 칸
				int[] delSnake = snake.poll(); // 꼬리가 줄어든다
				map[delSnake[0]][delSnake[1]]=0;
			}
			
			// 뱀 위치 추가
			map[nr][nc]=1;
			snake.add(new int[] {nr,nc});
			
			// 방향을 바꿔야 할 때
			if (next.x == sec) {
				
				if(next.d == 'L') { // 왼쪽으로 : -1
					nowDir = (nowDir==0)? 3:(nowDir-1);
				}
				else { // 오른쪽으로 : +1
					nowDir = (nowDir+1)%4;
				}
				
				if(!changeDir.isEmpty()) next = changeDir.poll();
			}
			
		} // while
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int k=0;k<K;k++) {	
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			map[r][c]=-1; // apple
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			changeDir.add(new Node(x,d));
		} // input
		
		dummy();
		System.out.println(sec+1);
		
		br.close();
	}
}
