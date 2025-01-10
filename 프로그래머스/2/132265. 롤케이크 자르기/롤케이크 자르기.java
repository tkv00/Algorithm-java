import java.util.*;

class Solution {
    private static HashMap<Integer,Integer> set1;
    private static Set<Integer> set2;
    public int solution(int[] topping) {
        int answer=0;
        set1=new HashMap<>();
        set2=new TreeSet<>();
        for(int i=0;i<topping.length;i++){
            set1.put(topping[i],set1.getOrDefault(topping[i],0)+1);
        }
        int size=set1.size();
        
        
        for(int t:topping){
            set2.add(t);
            set1.put(t,set1.get(t)-1);
            
            if(set1.get(t)==0){
                set1.remove(t);
            }
            if(set1.size()==set2.size()){
                answer++;
            }
        }
        
        return answer;
    }
}