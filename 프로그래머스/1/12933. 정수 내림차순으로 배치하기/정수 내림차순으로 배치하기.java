import java.util.*;

class Solution {
    public long solution(long n) {
        char[] ch=String.valueOf(n).toCharArray();
        Arrays.sort(ch);//오름 차순
        StringBuilder str=new StringBuilder(new String(ch)).reverse();
        return Long.parseLong(str.toString());
    }
}