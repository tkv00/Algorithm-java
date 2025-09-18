import java.util.*;
import java.io.*;
class Solution {
    private static int cnt;
    private static int zeroCnt;
    
    private static void operation(String s){
        while(true){
            if(s.equals("1")) break;
            
            int size=s.length();
            //0제거
            s=s.replaceAll("0","");
            zeroCnt+=(size-s.length());
            
            int length=s.length();
            //2진수 변환.
            s=Integer.toString(length,2);
            cnt++;
        }    
    }
    
    
    public int[] solution(String s) {
        cnt=0;
        zeroCnt=0;
        operation(s);
        return new int[]{cnt,zeroCnt};
    }
}