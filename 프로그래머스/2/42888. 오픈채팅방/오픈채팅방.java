import java.util.*;
class Solution {
    private static final String IN="님이 들어왔습니다.";
    private static final String OUT="님이 나갔습니다.";
    private static Map<String,String> records;
    private static List<String> results;
    private static String[] result;
    
    public String[] solution(String[] record) {
        records=new HashMap<>();
        results=new ArrayList<>();
        
        
        for(String input:record){
            String [] inputs=input.split(" ");
            String order=inputs[0];
            String key=inputs[1];
            String name="";
            if(!order.equals("Leave")){
                name=inputs[2];
            }
           
            switch(order){
                case "Change":
                case "Enter":
                    records.put(key,name);
                    break;      
            }
        }
        
        for(String input:record){
            String [] inputs=input.split(" ");
            String order=inputs[0];
            String key=inputs[1];
            String name="";
            if(!order.equals("Leave")){
                name=inputs[2];
            }
           
            
            switch(order){
                case "Enter":
                    results.add(records.get(key)+IN);
                    break;
                case "Leave":
                    results.add(records.get(key)+OUT);
                    break;
            }
        }
        
        result=new String[results.size()];
        int idx=0;
        
        for(String str:results){
            result[idx]=str;
            idx++;
        }
        
        return result;
    }
}