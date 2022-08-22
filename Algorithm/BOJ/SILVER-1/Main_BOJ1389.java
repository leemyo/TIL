package August;

import java.io.*;
import java.util.*;

public class Main_BOJ1389 {

    static int N, M, answer = Integer.MAX_VALUE, answer_idx;

    static List<Integer>[] list;

    static class Node{
        int idx, dpt;

        public Node(int idx, int dpt) {
            this.idx = idx;
            this.dpt = dpt;
        }
    }

    static void findDepth(int idx){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(idx,1));
        int[] arr = new int[N+1];
        for (int i = 0; i <= N ; i++) arr[i]=0;

        while(!q.isEmpty()){
            Node n = q.poll();
            for(int num : list[n.idx]){
                if(arr[num]!=0) continue;
                arr[num] = n.dpt+1;
                q.add(new Node(num,arr[num]));
            }
        }

        int ans = 0;
        for (int i = 0; i <= N; i++) {
            ans += arr[i];
        }

        if(answer>ans){
            answer = ans;
            answer_idx=idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for(int i=0;i<=N;i++) {
            list[i]=new LinkedList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        } // input

        for (int i = 1; i <= N; i++) {
            findDepth(i);
        }

        // 사람 번호를 출력. 여러 명이면 번호가 작은 사람부터 출력
        System.out.println(answer_idx);
    }
}
