import java.util.*;

class Solution {
    //이익 계산 함수
    private static int getTotal(int amount){
        return amount * 100;
    }
    private static class Info{
        String name;
        int index;
        
        Info(String name,int index){
            this.name=name;
            this.index=index;
        }
    }
    private static Map<String,Integer> map;
    private static Map<String,Info> tree;
    private static int[] result;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        /**
        1. 추천인에게 10% 배분 
        2. 추천한 사람한테 10% 내꺼
        3. 10% 계산한 금액 1원 미만 -> 이득 측정 X , 모두 내꺼
        **/
        
        /**
        result -> enroll에 등록된 이름으로
        **/
        
        map=new HashMap<>();
        tree=new HashMap<>();
        result=new int[enroll.length];
        
        //트리 관계 매핑
        for(int i=0;i<enroll.length;i++){
            tree.put(enroll[i],new Info(referral[i],i));
        }
        
        for(int i=0;i<seller.length;i++){
            int money=getTotal(amount[i]);
            String name=seller[i];
            int index=tree.get(name).index;
            result[index]+=money-(money/10);
            
            int left=money/10;
            while(true){
                name=tree.get(name).name;
                if(name.equals("-")){
                    break;
                }
                result[tree.get(name).index]+=left-(left/10);
                left/=10;
                if(left==0) break;
            }
        }
        return result;
    }
}