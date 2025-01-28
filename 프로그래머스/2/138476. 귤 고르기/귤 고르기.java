import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //1 2 2 3 3 4 5 5
        //1 2 2 3 3 4 5 5
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        List<Integer> keySet=new ArrayList<>(map.keySet());
        //내림차순 정렬
        keySet.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
    
        for(int t:keySet){
            k-=map.get(t);
            answer++;
            if(k<=0)break;
        }
        
        return answer;
    }
}