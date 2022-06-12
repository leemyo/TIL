package week2;

import java.io.*;
import java.util.*;

public class Main_BOJ15961 {
	
	static int N, D, K, C;
	static int sushi[];
	static long maxKind;
	static Set<Integer> set = new HashSet<>();
	static Map<Integer,Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
		
		N=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		for(int i=0;i<N;i++) {
			sushi[i]=Integer.parseInt(br.readLine());
		} //input
		
		for(int i=0;i<K;i++) {
			if(set.contains(sushi[i])) map.put(sushi[i], map.get(sushi[i])+1);
			else {
				map.put(sushi[i], 1);
				set.add(sushi[i]);
			}
		} // make dic
		
		maxKind = set.size();
		if(!set.contains(C)) maxKind++;
		
		
		//슬라이딩윈도우
		for(int s=0;s<N;s++) {
			if(map.get(sushi[s])==1) {
				map.remove(sushi[s]);
				set.remove(sushi[s]);
			}
			else {
				map.replace(sushi[s], map.get(sushi[s])-1);
			} // 앞 삭제
			
			int idx = (s+K)%N;
			if(set.contains(sushi[idx])) map.put(sushi[idx], map.get(sushi[idx])+1);
			else {
				map.put(sushi[idx], 1);
				set.add(sushi[idx]);
			} // 뒤 추가
			
			int nowmax = set.size();
			if(!set.contains(C)) nowmax++;
			
			maxKind = Math.max(maxKind, nowmax);
		}
		
		System.out.println(maxKind);
	}
}
