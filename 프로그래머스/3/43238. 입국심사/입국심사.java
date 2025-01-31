import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long max=0;
        int size=times.length;
        Arrays.sort(times);
        long left=(long)times[0];
        long right=(long)times[size-1]*n;
        
        while(left<=right){
            long mid=(left+right)/2;
            long sum=0;
            for(int time:times){
                sum+=mid/time;
            }
            if(sum>=n){
                answer=Math.min(answer,mid);
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return answer;
    }
}