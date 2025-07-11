import java.util.*;
class Solution {
    public String solution(int n) {
        String[] strs={"4","1","2"};
        String answer="";
        
        while(true){
            int num=n%3;
            answer=strs[num]+answer;
            n=n/3;
            if(num==0) n--;
            if(n<=0) break;
        }
        return answer;
    }
}