import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        //아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        Map<Integer,Double> map=new HashMap<>();
        
        //총 인원수
        int person=stages.length;
        //스테이지별 클리어한 사람 수 리스트
        int[] clear=new int[N+1];
        double[] list=new double[N+1];
        int[] result=new int[N];
        for(int i=0;i<stages.length;i++){
            if(stages[i]>N)continue;
            clear[stages[i]]++;
        }
        int sum=0;
        
        for(int i=1;i<=N;i++){
            if(person-sum>0){
                map.put(i,(double)clear[i]/(person-sum));   
            }else{
                map.put(i,0.0);
            }
            sum+=clear[i];
            
        }
        List<Integer> keySet=new ArrayList<>(map.keySet());
        
        keySet.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
                    
        return keySet.stream().mapToInt(i->i).toArray();
    }
}