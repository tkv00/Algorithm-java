import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        //여벌 체육복을 가져온 학생 도난 당한 경우 제외
        Set<Integer> lostArr=new HashSet<>();
        Set<Integer> resArr=new HashSet<>();
        
        //여벌 가져온 사람
        for(int r:reserve){
            resArr.add(r);
        }
        
        //체육복 잃어버린 사람
        for(int l:lost){
            if(resArr.contains(l)){
                resArr.remove(l);
            }else{
                lostArr.add(l);
            }
        }
        
        for(Integer i:resArr){
            if(lostArr.contains(i-1)){
                lostArr.remove(i-1);
            }else if(lostArr.contains(i+1)){
                lostArr.remove(i+1);
            }
        }
        return n-lostArr.size();
    }
}