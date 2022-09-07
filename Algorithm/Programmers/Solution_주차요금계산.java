import java.util.*;
import java.util.Map.*;

public class Solution_주차요금계산 {

    static HashMap<String, Integer> hm = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static List<Integer> carCost, inTime;

    static class Node implements Comparable<Node>{
        String carNum;
        int carCost;

        public Node(String carNum, int carCost) {
            this.carNum = carNum;
            this.carCost = carCost;
        }

        @Override
        public int compareTo(Node o) {
            return this.carNum.compareTo(o.carNum);
        }
    }

    static public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        carCost = new LinkedList<>();
        inTime = new LinkedList<>();
        String[] input;
        int idx=0;

        int tmpp = 0;
        for(String str : records){
            input = str.split(" "); // input 시간 차번호 in/out

            if(input[2].equals("IN")){
                String[] tmp = input[0].split(":");
                int time=Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]); // 분 기준 시간

                if(hm.containsKey(input[1])){
                    inTime.set(hm.get(input[1]),time);
                }else {
                    hm.put(input[1],idx++);
                    carCost.add(0);
                    inTime.add(time);
                }


            }else { // OUT인 경우
                String[] tmp = input[0].split(":");
                int time=Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]) - inTime.get(hm.get(input[1])); // 분 기준 시간

                carCost.set(hm.get(input[1]), carCost.get(hm.get(input[1]))+time);
                inTime.set(hm.get(input[1]),-1);
            }
        }

        answer = new int[idx];
        int fulltime = 24*60-1;
        for(Entry<String,Integer> entry : hm.entrySet()){
            String carNum = entry.getKey();
            int index = entry.getValue();
            int rest = inTime.get(index);
            if(rest != -1){ // 출차처리 안됨
                int time = fulltime-inTime.get(index);
                int cost = carCost.get(index);
                carCost.set(index, cost+time);
            }

            int cost = carCost.get(index);
            pq.add(new Node(carNum,cost));
        }

        int pq_idx = 0;
        // fees: 기본시간 기본요금 단위시간 단위요금
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.carCost<=fees[0]) {
                answer[pq_idx++]=fees[1];
                continue;
            }else{
                int realCost = ((n.carCost-fees[0])/fees[2])*fees[3]+fees[1];
                if((n.carCost-fees[0])%fees[2]!=0) realCost+=fees[3];
                answer[pq_idx++]=realCost;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = new int[] {180, 5000, 10, 600};
        String[] records = new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees,records);
    }

}
