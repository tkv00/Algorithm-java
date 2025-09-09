import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
       Map<String,Integer> map=new HashMap<>();
        for(String people:participant){
            map.put(people,map.getOrDefault(people,0)+1);
        }
        for(String people:completion){
            map.put(people,Math.max(0,map.get(people)-1));
        }
        
        for(String name:map.keySet()){
            if(map.get(name)!=0) return name;
        }
        return null;
    }
}