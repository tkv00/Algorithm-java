import java.util.*;
class Solution {
    private static Set<String> set;
    public int[] solution(int n, String[] words) {
        int[] answer=new int[2];
        set=new HashSet<>();
        String prev=words[0];
        set.add(words[0]);
        
        
        for(int i=1;i<words.length;i++){
            char[] prevArr=prev.toCharArray();
            char[] nowArr=words[i].toCharArray();
            
            if(prevArr[prevArr.length-1] != nowArr[0] || set.contains(words[i])) {
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            
            set.add(words[i]);
            prev=words[i];
        }
        return answer;
    }
}