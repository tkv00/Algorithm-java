import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result=new ArrayList<>();
        for(int num:arr){
            if(num%divisor==0){
                result.add(num);
            }
        }
        Collections.sort(result);
        if(result.size()==0){
            return new int[]{-1};
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}