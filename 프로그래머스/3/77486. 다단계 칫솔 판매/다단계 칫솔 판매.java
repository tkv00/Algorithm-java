import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //이름-추천인
        HashMap<String,String> name_recommand=new HashMap<>();
        //이름-받는 비용
        HashMap<String,Integer> name_cost=new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            name_recommand.put(enroll[i],referral[i]);
        }
        
        
        for(int i=0;i<seller.length;i++){
            int cost=amount[i]*100;
            String curName=seller[i];
            
            while(cost>0 && curName!="-"){
                name_cost.put(curName,name_cost.getOrDefault(curName,0)+cost-(cost/10));
                //다음 이름으로 넘어가기
                cost/=10;
                curName=name_recommand.get(curName);
            }
            
        }
        
        int[] answer=new int[enroll.length];
        for(int i=0;i<answer.length;i++){
            answer[i]=name_cost.getOrDefault(enroll[i],0);
        }
        return answer;
    }
}