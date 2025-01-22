import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> map=new HashSet<>();
        int size=phone_book.length;
        
        for(String s:phone_book){
            map.add(s);
        }
        
        for(String s:phone_book){
            int N=s.length();
            //사이즈보다 작은 값 for문
            for(int i=1;i<N;i++){
                //앞에서부터 자른 값
                String newS=s.substring(0,i);
                if(map.contains(newS))return false;
            }
        }
        return true;
        
    }
}