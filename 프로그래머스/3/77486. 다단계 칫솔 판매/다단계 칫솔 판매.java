import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[]result=new int[enroll.length];
        //사람-금액 해시
        HashMap<String,Integer> person_money=new HashMap<>();
        //사람-부모 해시
        HashMap<String,String> person_parent=new HashMap<>();
        
        //초기화
        for(int i=0;i<enroll.length;i++){
            person_money.put(enroll[i],0);
            person_parent.put(enroll[i],referral[i]);
        }
        
        for(int i=0;i<seller.length;i++){
            String now=seller[i];
            int cost=amount[i]*100;
            while(!now.equals("-")){
                person_money.put(now,person_money.getOrDefault(now,0)+cost-cost/10);
                now=person_parent.get(now);
                cost=cost/10;
                if(cost==0)break;
            }
        }
      
        for(int i=0;i<enroll.length;i++){
            result[i]=person_money.get(enroll[i]);
        }
        return result;
    }
}