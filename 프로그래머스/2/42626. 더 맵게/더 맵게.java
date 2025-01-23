import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int k:scoville){
            pq.add(k);
        }
        
        while(true){
            //첫 번째 수
            int first=pq.poll();
            if(first>=K ) break;
            if(pq.size()==0){
                if(first>=K)return answer;
                else return -1;
            }
            //두 번째 수
            if(!pq.isEmpty()){
                int second=pq.poll();
                //섞기
                int mix=first+(second*2);
                pq.add(mix);
                answer++;
            }
            
            
        }
        
        return answer;
    }
}