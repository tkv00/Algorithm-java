import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        
        int sum=0;
        for(int num:numbers){
            sum+=num;
        }
        
        return Math.round(((double)sum/numbers.length)*10)/10.0;
    }
}