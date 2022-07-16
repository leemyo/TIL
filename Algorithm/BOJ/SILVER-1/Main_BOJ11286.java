package week2;

import java.io.*;
import java.util.*;

public class Main_BOJ11286 {
	
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			int n1 = Math.abs(a);
			int n2 = Math.abs(b);
			
			if(n1!=n2) return Math.abs(a)-Math.abs(b);
			else return a-b;
		});
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num !=0) pq.add(num);
			else {
				if(pq.size()==0) sb.append("0\n");
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
