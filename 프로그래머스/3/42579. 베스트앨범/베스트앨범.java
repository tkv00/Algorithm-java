import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> map=new HashMap<>();
        
        //장르별 가지고 있는 인덱스 맵
        //장르- 인덱스,재생횟수
        HashMap<String,HashMap<Integer,Integer>>indexMap=new HashMap<>();
        ArrayList<Integer>answer=new ArrayList<>();
        
        for(int i=0;i<genres.length;i++){
            //키값이 존재하지 않는 경우
            if(!map.containsKey(genres[i])){
                HashMap<Integer,Integer>hash=new HashMap<>();
                hash.put(i,plays[i]);
                map.put(genres[i],plays[i]);
                indexMap.put(genres[i],hash);
            }else{
                map.put(genres[i],map.get(genres[i])+plays[i]);
                indexMap.get(genres[i]).put(i,plays[i]);
            }
        }
        
        ArrayList<String>keyMap=new ArrayList<>(map.keySet());
       
        //정렬
        Collections.sort(keyMap,(o1,o2)->map.get(o2).compareTo(map.get(o1)));
      
        for(String key:keyMap){
            HashMap<Integer,Integer>music=indexMap.get(key);
            ArrayList<Integer> genre_key=new ArrayList<>(music.keySet());
            Collections.sort(genre_key,(o1,o2)->music.get(o2).compareTo(music.get(o1)));
            
            //일단 1개 넣기
            answer.add(genre_key.get(0));
            if(genre_key.size()>1){
                answer.add(genre_key.get(1));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}