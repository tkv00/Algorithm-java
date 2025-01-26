import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        //Arrays.sort(citations);
        
        int size=citations.length;
        Arrays.sort(citations);
        
        for(int i=0;i<size;i++){
            int h=size-i;
            if(citations[i]>=h){
                answer=h;
                break;
            }
        }
        return answer;
    }
}