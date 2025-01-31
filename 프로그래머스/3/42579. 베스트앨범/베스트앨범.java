import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer>answer=new ArrayList<>();
        HashMap<String,Integer> map1=new HashMap<>();
        HashMap<String,List<Integer>> map2=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            map1.put(genres[i],map1.getOrDefault(genres[i],0)+plays[i]);
            if(!map2.containsKey(genres[i])){
                map2.put(genres[i],new ArrayList<>());
            }
            //인덱스 저장
            map2.get(genres[i]).add(i);
        }
        
        List<String> keySet=new ArrayList<>(map1.keySet());
        keySet.sort((o1,o2)->map1.get(o2).compareTo(map1.get(o1)));
        
        for(String str:keySet){
            List<Integer> arr=map2.get(str);
            arr.sort((o1,o2)->plays[o2]-plays[o1]);
            
            for(int i=0;i<Math.min(2,arr.size());i++){
                answer.add(arr.get(i));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}