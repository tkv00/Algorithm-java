import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map=new HashMap<>();
        List<String> result=new ArrayList<>();
        
        for(String str:record){
            if(!str.startsWith("Leave")){
                String[] nstr=str.split(" ");
                map.put(nstr[1],nstr[2]);
            }
        }
        
        for(String str:record){
            String[] nstr=str.split(" ");
            
            if(nstr[0].equals("Enter")){
                result.add(map.get(nstr[1])+"님이 들어왔습니다.");
            }else if(nstr[0].equals("Leave")){
                result.add(map.get(nstr[1])+"님이 나갔습니다.");
            }
        }
        
        return result.toArray(String[]::new);
    }
}