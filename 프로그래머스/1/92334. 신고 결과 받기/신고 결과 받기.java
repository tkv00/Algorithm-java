import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //K : 정지 기준 신고 횟수
        HashMap<String,Integer> map=new HashMap<>();
        HashMap<String,HashSet<String>> mapping=new HashMap<>();
    
        for(String str:id_list){
            map.put(str,0);
            mapping.put(str,new HashSet<>());
        }
        
        for(String str:report){
            String[]nstr=str.split(" ");
            //신고한 사람
            String reporter=nstr[0];
            //신고 당한 사람
            String reported=nstr[1];
            
            if(!mapping.get(reporter).contains(reported)){
                mapping.get(reporter).add(reported);
                map.put(reported,map.get(reported)+1);
            }
        }
        //신고 횟수이상인 사람 추출
        HashSet<String> ban=new HashSet<>();
        for(String str:map.keySet()){
            if(map.get(str)>=k){
                ban.add(str);
            }
        }
        int[] result=new int[id_list.length];
        
        for(int i=0;i<id_list.length;i++){
            int cnt=0;
            String str=id_list[i];
            for(String user:mapping.get(str)){
                if(ban.contains(user)){
                    cnt++;
                }
            }
            result[i]=cnt;
        }
        return result;
        
    }
}