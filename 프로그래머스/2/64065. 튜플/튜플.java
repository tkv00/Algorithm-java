import java.util.*;

class Solution {
    public int[] solution(String s) {
        String []str=s.substring(2,s.length()-2).split("\\},\\{");
        Arrays.sort(str,Comparator.comparingInt(String::length));
        Set<Integer> set=new LinkedHashSet<>();
        
        
        for(String st:str){
            String[]ns=st.split(",");
            for(String k:ns){
                set.add(Integer.parseInt(k));
            }
            
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}