package August;

import java.io.*;
import java.util.*;

public class Main_BOJ1939 {

    static int N, M, s, e;
    static List<Node>[] edges;

    static class Node{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static boolean findRoad(int mid){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int weight[] = new int[N+1];
        weight[s]=0;

        while(!q.isEmpty()){
            int n = q.poll();
            if (n==e) return true;

            for(Node now : edges[n]){
                if(now.w<mid || weight[now.v]!=0) continue;

                weight[now.v] = now.w;
                q.add(now.v);
            } // for
        } // while

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new List[N+1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new LinkedList<>();
        }

        int max_weight = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            max_weight = Math.max(max_weight,w);

            edges[a].add(new Node(b,w));
            edges[b].add(new Node(a,w));
        } // input

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int l=1, r=max_weight;
        while(l<=r){
            int mid = (l+r)/2;
            if (findRoad(mid)) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.println(r);
    }

}
