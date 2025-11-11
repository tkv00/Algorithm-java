import java.util.*;
class Solution {
    private static final String IN="님이 들어왔습니다.";
    private static final String OUT="님이 나갔습니다.";
    private static List<String> result;
    private static Map<String,String> user;
    public String[] solution(String[] record) {
        result=new ArrayList<>();
        user=new HashMap<>();
        
        for(String input:record){
            String order=input.split(" ")[0];
            if(order.equals("Enter") || order.equals("Change")){
                String uid=input.split(" ")[1];
                String name=input.split(" ")[2];
                user.put(uid,name);    
            }
        }
        
        for(String input:record){
            String order=input.split(" ")[0];
            String uid=input.split(" ")[1];
            
            switch(order){
                case "Enter":
                    result.add(user.get(uid)+IN);
                    break;
                case "Leave":
                    result.add(user.get(uid)+OUT);
                    break;
            }
        }
        
        String[] answer=new String[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
        
    }
}