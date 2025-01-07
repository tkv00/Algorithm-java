import java.util.ArrayDeque;

class Solution {
    private static int answer=0;
    private static ArrayDeque<Integer> dq;
    
    //skill에 따른 디큐 생성
    private static boolean countArray(String str,char[] skill){
        char[] str_to_char=str.toCharArray();
        dq=new ArrayDeque<>();
        
        for(int i=0;i<str_to_char.length;i++){
           for(int j=0;j<skill.length;j++){
               if(str_to_char[i]==skill[j]){
                   dq.addLast(j);
               }
           }
        }
        
        
       
        
        //뽑은 처음 값이 0이 아닌 경우
        int expected=0;
        
        while(!dq.isEmpty()){
            int now=dq.pollFirst();
            if(now!=expected){
                return false;
            }
            expected++;
        }
        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        char[] skills=skill.toCharArray();
        for(int i=0;i<skill_trees.length;i++){
            if(countArray(skill_trees[i],skills)){
                answer++;
            }
        }
        return answer;
    }
}