import java.util.*;

class Solution {
    private static int PROFIT=100;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //총 결과
        HashMap<String,Integer> result = new HashMap<>();
        //자식-부모 관계 정의
        HashMap<String,String> child_parent=new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            result.put(enroll[i],0);
            child_parent.put(enroll[i],referral[i]);
        }
        
        for(int i=0;i<seller.length;i++){
            String child=seller[i];
            int minus=(PROFIT*amount[i])/10;
            result.put(child,result.getOrDefault(child,0)+amount[i]*PROFIT-minus);
            do{
                child=child_parent.get(child);
                result.put(child,result.getOrDefault(child,0)+minus-minus/10);
                minus/=10;
                if(minus==0) break;
            }while(!child.equals("-"));
        }
        int[] resultArray=new int[enroll.length];
        int idx=0;
        for(String str:enroll){
            resultArray[idx++]=result.get(str);
        }
        return resultArray;
        
    }
}