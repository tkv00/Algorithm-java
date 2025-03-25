import java.util.*;

class Solution {
    private static final int LIMIT=2;
    public int[] solution(String[] genres, int[] plays) {
        //장르-재생 횟수
        HashMap<String,Integer> genres_count=new HashMap<>();
        
        //장르-노래 인덱스
        HashMap<String,List<Integer>> genres_index=new HashMap<>();
        
        int size=genres.length;
        for(int i=0;i<size;i++){
            genres_count.put(genres[i],
                             genres_count.getOrDefault(genres[i],0)+plays[i]);
            List<Integer> list=genres_index.getOrDefault(genres[i],new ArrayList<>());
            list.add(i);
            genres_index.put(genres[i],list);
        }
        
        //장르-재생 횟수 map 내림차순 정렬
        List<String> countKeySet=new ArrayList<>(genres_count.keySet());
        countKeySet.sort((o1,o2)->genres_count.get(o2)-genres_count.get(o1));
        
        List<Integer> result=new ArrayList<>();
        
        for(String genre:countKeySet){
            List<Integer> indexList=genres_index.get(genre);
            //내림차순 정렬
            indexList.sort((o1,o2)->plays[o2]-plays[o1]);
            
            for(int i=0;i<Math.min(LIMIT,indexList.size());i++){
                result.add(indexList.get(i));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}