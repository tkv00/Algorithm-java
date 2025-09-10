import java.util.*;

class Solution {
    private static class Info{
        int idx,play;
        Info(int idx,int play){
            this.idx=idx;
            this.play=play;
        }
    }
    
    private static int getSum(List<Info> infos){
        int sum=0;
        if(infos.size()>0){
            for(Info info:infos){
            sum+=info.play;
            }
        }
        return sum;
    }
    
    private static TreeMap<String,List<Info>> musicMap;
    private static final int INF=2;
        
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> resultArr=new ArrayList<>();
        int size=genres.length;
        musicMap=new TreeMap<>();
        
        for(int i=0;i<size;i++){
            musicMap.putIfAbsent(genres[i],new ArrayList<>());
            musicMap.get(genres[i]).add(new Info(i,plays[i]));
        }
        
        List<String> keySet=new ArrayList<>(musicMap.keySet());
        
        Collections.sort(keySet,(a,b)->getSum(musicMap.get(b))-getSum(musicMap.get(a)));
        
        for(String genre:keySet){
            List<Info> list=musicMap.get(genre);
            Collections.sort(list,(a,b)->b.play-a.play);
            for(int i=0;i<Math.min(list.size(),INF);i++){
                resultArr.add(list.get(i).idx);
            }
        }
        
        int[] answer=new int[resultArr.size()];
        for(int i=0;i<resultArr.size();i++){
            answer[i]=resultArr.get(i);
        }
        
        return answer;
    }
}