package July.week4;

import java.io.*;
import java.util.*;

public class Main_BOJ1713 {

    static int N, rCnt, rec[];

    static class Node implements Comparable<Node>{
        int idx, cnt, num;

        public Node(int idx, int cnt, int num) {
            this.idx = idx;
            this.cnt = cnt;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cnt==o.cnt){
                return this.idx-o.idx;
            }
            else return this.cnt-o.cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rCnt = Integer.parseInt(br.readLine());
        rec = new int[rCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<rCnt;i++){
            rec[i]= Integer.parseInt(st.nextToken());
        } // input

        List<Node> list = new LinkedList<>();

        for(int i=0;i<rCnt;i++){
            boolean flag = false;
            int mIdx=0;
            for(int j=0;j<list.size();j++){ // rec[i] 가 현재 후보에 있는지 확인
                    Node n = list.get(j);
                    if(n.num==rec[i]) {
                        mIdx = j;
                        flag=true;
                        break;
                    }
            }

            if(flag){ // 현재 후보군에 있으면
                Node origin = list.get(mIdx);
                Node tmp = new Node(origin.idx, origin.cnt+1, origin.num);
                list.set(mIdx,tmp);
            }
            else { // 현재 후보군에 없으면 !flag >> pq.size보고 알아서 빼고 추가
                if(list.size()==N){
                    Node tmp = new Node(i, 1, rec[i]);
                    list.set(0,tmp);
                }
                else {
                    list.add(new Node(i,1,rec[i]));
                }
            }
            Collections.sort(list);
        }

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arr.add(list.get(i).num);
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.size();i++){
            sb.append(arr.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }

}
