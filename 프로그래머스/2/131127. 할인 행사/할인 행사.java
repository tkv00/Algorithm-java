import java.util.*;
class Solution {
    private static HashMap<String,Integer> map;
    private static HashMap<String,Integer> copy;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer=0;
        
        map=new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        
        for(int i=0;i<discount.length;i++){
            copy=new HashMap<>(map);
            int cnt=0;
            
            for(int j=i;j<Math.min(i+10,discount.length);j++){
                String now=discount[j];
                if(copy.containsKey(now)){
                    int num=copy.get(now)-1;
                    if(num==0){
                        cnt++;
                        copy.remove(now);
                    }
                    else copy.put(now,num);
                }
            }
            if(cnt==want.length) answer++;
            
        }
        
        return answer;
    }
}