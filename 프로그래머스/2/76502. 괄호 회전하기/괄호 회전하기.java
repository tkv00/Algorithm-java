import java.util.*;
class Solution {
    private static boolean isValid(String str){
        Stack<Character> stack=new Stack<>();
        
        char[]list=str.toCharArray();
        for(char c:list){
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                char top=stack.pop();
                
                if((c==']' && top!='[') || 
                    (c=='}' && top!='{') ||
                     (c==')' && top!='(')){
                         return false;
                     }
                  
            }
        }
        
        
        if(stack.isEmpty())return true;
        return false;
    }
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            String nstr1=s.substring(i);
            String nstr2=s.substring(0,i);
            if(isValid(nstr1+nstr2)){
                answer++;
            }
        }
        return answer;
    }
}