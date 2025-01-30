import java.util.*;
class Solution {
    private static HashMap<String,Integer> copy;
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> map=new HashMap<>();
        int day=0;
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        //banana 3
        //apple. 2
        //rice.  2
        //pork.  2
        //pot.   1
        int size=discount.length-10;
        for(int i=0;i<=size;i++){
            copy=new HashMap<>(map);
            int cnt=0;
            for(int j=i;j<i+10;j++){
                if(copy.containsKey(discount[j])){
                    copy.put(discount[j],copy.get(discount[j])-1);
                    if(copy.get(discount[j])==0){
                        copy.remove(discount[j]);
                        cnt++;
                    }
                }
            }
            if(cnt==number.length) day++;
        }
        return day;
    }
}