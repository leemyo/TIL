package August;

import java.io.*;
import java.util.*;

public class Main_BOJ21608 {

    static int N, score;
    static int prefer[][], d[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    static int map[][];
    static List<Seat> students = new LinkedList<>();

    static class Seat{
        int pIdx, r, c;

        public Seat(int pIdx, int r, int c) {
            this.pIdx = pIdx;
            this.r = r;
            this.c = c;
        }
    }

    static boolean isRange(int r, int c){
        return 0<=r && r<N && 0<=c && c<N;
    }

    static void calScore(Seat s){
        int sat=0; // 만족도

        for (int i = 0; i < 4; i++) {
            int nr = s.r+d[i][0];
            int nc = s.c+d[i][1];
            if(!isRange(nr,nc)) continue;

            for(int j=1;j<5;j++){
                if(map[nr][nc]==prefer[s.pIdx][j]){
                    sat++; break;
                }
            }
        }

        if(sat==1) score+=1;
        else if(sat==2) score+=10;
        else if(sat==3) score+=100;
        else if(sat==4) score+=1000;
    }

    static Seat findEmptySeat(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==0) return new Seat(-1,i,j);
            }
        }
        return new Seat(-1,-1,-1);
    }

    static int findSatisfaction(int r, int c, int pidx){
        int sat = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r+d[i][0];
            int nc = c+d[i][1];

            if(!isRange(nr,nc)) continue;
            for(int j=1;j<5;j++){
                if(map[nr][nc]==prefer[pidx][j]){
                    sat++; break;
                }
            }
        }
        return sat;
    }

    static int findBlank(int r, int c){
        int blank=0;
        for (int i = 0; i < 4; i++) {
            int nr = r+d[i][0];
            int nc = c+d[i][1];

            if(!isRange(nr, nc)) continue;
            if(map[nr][nc]==0) blank++;
        }
        return blank;
    }

    static void findSeat(int sIdx){
        Seat seat = findEmptySeat();
        seat.pIdx=sIdx;
        int nowSat = findSatisfaction(seat.r,seat.c, seat.pIdx); // 해당 자리 만족도
        int blank = findBlank(seat.r, seat.c); // 빈칸, 자리 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]!=0) continue;
                int seatSat = findSatisfaction(i,j,sIdx);
                if(nowSat>seatSat) continue;
                else if(nowSat==seatSat){

                    int nowBlank = findBlank(i,j);
                    if(blank < nowBlank) {
                        seat.r = i;
                        seat.c = j;
                        blank = nowBlank;
                    }
                }
                else {
                    seat.r = i;
                    seat.c = j;
                    blank = findBlank(i,j);
                    nowSat = seatSat;
                }
            }
        }

        map[seat.r][seat.c]=prefer[seat.pIdx][0];
        students.add(seat);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        prefer = new int[N*N][5];
        map = new int[N][N];

        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                prefer[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input

        for (int i = 0; i < N*N; i++) {
            findSeat(i);
        }
        for(Seat s : students) {
            calScore(s);
        }

        System.out.println(score);
    }
}
