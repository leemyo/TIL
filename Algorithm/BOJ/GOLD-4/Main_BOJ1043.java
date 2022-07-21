package July.week3;

import java.io.*;
import java.util.*;

public class Main_BOJ1043 {

    static int N, M;
    static boolean map[][];
    static Queue<Integer> know = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map=new boolean[M+1][N+1];

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++){
            int person = Integer.parseInt(st.nextToken());
            know.add(person);
            map[0][person]=true;
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++){
                int person = Integer.parseInt(st.nextToken());
                map[i][person]=true;
            }
        } // for

        while(!know.isEmpty()){
            int person = know.poll();
            for(int i=1;i<=M;i++){
                if(map[i][person]) { // 해당 파티에 진실을 아는 사람이 간다면
                    if(map[i][0]) continue; // 파티가 이미 지정이 되어있다면 다음
                    map[i][0]=true; // 해당 파티를 못가는 파티로 바꾸고
                    for(int j=1;j<=N;j++){ // 해당 파티를 간 사람들을 봄
                        if(map[i][j] && !map[0][j]) {
                            map[0][j]=true;
                            know.add(j);
                        }
                    }
                }
            } // 파티를 모두 살핌
        } // while

        int answer=0;
        for(int i=1;i<=M;i++){
            if(!map[i][0]) answer++;
        }

        System.out.println(answer);
    }
}
