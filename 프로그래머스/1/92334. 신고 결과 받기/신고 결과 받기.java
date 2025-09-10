import java.util.*;

class Solution {
    private static int[] result;
    //신고 당한 횟수
    private static Map<String,Integer> map1;
    //신고 한 사람 목록
    private static Map<String,Set<String>> map2;
    private static Map<String,Integer> indexMap;
    public int[] solution(String[] id_list, String[] report, int k) {
        result=new int[id_list.length];
        map1=new HashMap<>();
        map2=new HashMap<>();
        indexMap=new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            indexMap.put(id_list[i],i);
        }
        
        for(String str:id_list){
            map2.put(str,new HashSet<>());
        }
        
        for(String str:report){
            //신고 한 사람
            String from=str.split(" ")[0];
            //신고 당한 사람
            String to=str.split(" ")[1];
            if(!map2.get(from).contains(to)){
                map1.put(to,map1.getOrDefault(to,0)+1);
                map2.get(from).add(to);
            }
        }
        
        for(String name:id_list){
            Set<String> set=map2.get(name);
            for(String name2:set){
                if(map1.get(name2)>=k) result[indexMap.get(name)]++;
            }
        }
        return result;
        
        
    }
}