package August;

import java.util.*;
import java.io.*;

public class Solution_카카오프렌즈컬러링북 {

    static int d[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    static int ans;
    static boolean[][] v;

    static class Node{
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isRange(int r, int c, int m, int n){
        return 0<=r && r<m && 0<=c && c<n;
    }

    static void bfs(int nowr, int nowc, int m, int n, int[][] picture){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(nowr,nowc));
        v[nowr][nowc]=true;
        int cnt=0;
        int color = picture[nowr][nowc];

        while(!q.isEmpty()){
            Node node = q.poll();
            cnt++;

            for(int i=0;i<4;i++){
                int nr = node.r+d[i][0];
                int nc = node.c+d[i][1];
                if(!isRange(nr,nc,m,n)) continue;
                if(v[nr][nc]) continue;
                if(picture[nr][nc]!= color) continue;

                q.add(new Node(nr,nc));
                v[nr][nc]=true;
            }
        }
        if(cnt>ans) ans = cnt;
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        v = new boolean[m][n];
        ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(v[i][j] || picture[i][j]==0) continue;
                bfs(i,j,m,n,picture);
                numberOfArea++;
            }
        }

        maxSizeOfOneArea = ans;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(6,4, picture)));
    }

}
