package week3;

import java.io.*;
import java.util.*;

public class Main_14719 {
	
	static int H, W, answer;
	static int height[];
	
	static void cntRainwater() {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(height[0]);
		int wall=height[0];
		
		for(int i=1;i<W;i++) {
			if(height[i]>=wall) {
				while(!stack.isEmpty()) {
					answer+=(wall-stack.pop());
				}
				stack.add(height[i]);
				wall = height[i];
			}
			else {
				stack.add(height[i]);
			}
		}
		
		if(!stack.isEmpty()) {
			wall = (wall>stack.peek())? stack.peek():wall;
			while(!stack.isEmpty()) {
				int now = stack.pop();
				if(now>wall) {
					wall=now;
				}
				else {
					answer+=(wall-now);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		height = new int[W];
		for(int i=0;i<W;i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		
		cntRainwater();
		System.out.println(answer);
		
		br.close();
	}
}
