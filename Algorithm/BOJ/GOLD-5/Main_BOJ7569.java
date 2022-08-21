package August;

import java.io.*;
import java.util.*;

public class Main_BOJ7569 {

    static int N, M, H, answer, tCnt, tomato[][][];
    static int d[][]={{0,0,-1},{0,0,1},{-1,0,0},{1,0,0},{0,1,0},{0,-1,0}};
    static class Node{
        int r, c, h, day;

        public Node(int r, int c, int h, int day) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }
    static Queue<Node> q = new LinkedList<>();

    static boolean isRange(int r, int c, int h){
        return 0<=r && r<N && 0<=c && c<M && 0<=h && h<H;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0;m<M;m++){
                    tomato[h][n][m] = Integer.parseInt(st.nextToken());
                    if(tomato[h][n][m]==1) {
                        q.add(new Node(n,m,h,0));
                    }
                    else if(tomato[h][n][m]==0) tCnt++;
                }
            }
        } // input

        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.day>answer) answer =n.day;

            for (int i = 0; i < 6; i++) {
                int nr = n.r + d[i][0];
                int nc = n.c + d[i][1];
                int nh = n.h + d[i][2];

                if(!isRange(nr,nc,nh)) continue;
                if(tomato[nh][nr][nc]!=0) continue;

                tCnt--;
                tomato[nh][nr][nc]=1;
                q.add(new Node(nr,nc,nh,n.day+1));
            }
        } // while

        if(tCnt==0) System.out.println(answer);
        else System.out.println("-1");

    }
}
