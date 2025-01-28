import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int idx=0;
        Arrays.sort(d);
        
        while(true){
            if(d.length-1<idx) break;
            budget-=d[idx];
            if(budget<0) break;
            answer++;
            idx++;
        }
        return answer;
    }
}