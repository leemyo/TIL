package July.week3;

import java.io.*;
import java.util.*;

public class Main_BOJ1743 {

    static int N,M,K,answer;
    static boolean map[][],v[][];
    static int d[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    static LinkedList <Node> trash = new LinkedList<>();

    static class Node{
        int r, c;

        // 단축키 alt+insert
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isRange(int r, int c){
        return 0<r && r<=N && 0<c && c<=M;
    }

    static void dfs(Node n){

        Queue<Node> q = new LinkedList<>();
        q.add(n);
        v[n.r][n.c]=true;
        int trashSize=1;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0;i<4;i++){
                int nr = now.r+d[i][0];
                int nc = now.c+d[i][1];

                if(!isRange(nr,nc)) continue;
                if(v[nr][nc]||!map[nr][nc]) continue;

                q.add(new Node(nr,nc));
                v[nr][nc]=true;
                trashSize++;
            }
        } // while

        if(trashSize>answer) answer=trashSize;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        v = new boolean[N+1][M+1];
        map = new boolean[N+1][M+1];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c]=true;
            trash.add(new Node(r,c));
        }

        for(int i=0;i<trash.size();i++){
            Node n = trash.get(i);
            if(v[n.r][n.c]) continue;
            dfs(n);
        }

        System.out.println(answer);
    }
}
