import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer=1;
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],new ArrayList<>());
                map.get(clothes[i][1]).add(clothes[i][0]);
            }else{
                map.get(clothes[i][1]).add(clothes[i][0]);
            }
        }
        for(String str:map.keySet()){
            int size=map.get(str).size()+1;
            answer*=size;
        }
        return answer-1;
    }
}