import java.util.*;
class Solution {
    private static List<String> result;
    private static Map<String,PriorityQueue<String>> map;
    private static final String START="ICN";
    
    private static Map<String,PriorityQueue<String>> buildMap(String[][] tickets){
        Map<String,PriorityQueue<String>> map=new HashMap<>();
    
        for(String[] inputs:tickets){
            map.putIfAbsent(inputs[0],new PriorityQueue<>((a,b)->a.compareTo(b)));
            map.get(inputs[0]).add(inputs[1]);
            
        }
        
        return map;
    }

    private static void DFS(String from){
        PriorityQueue<String> now=map.get(from);
        
        while(now!=null && !now.isEmpty()){
            String to=now.poll();
            DFS(to);
        }
        
        result.add(0,from);
    }
    
    public String[] solution(String[][] tickets) {
        int size=tickets.length;
        result=new ArrayList<>();
        map=buildMap(tickets);
        
        DFS(START);
        
        return result.toArray(new String[0]);
    }
    
}