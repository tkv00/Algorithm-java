import java.util.*;
class Solution {
    public int solution(String s) {
        Stack<String> stack=new Stack<>();
        String[] str=s.split(" ");
        
        int result=0;
        
        for(String c:str){
            if(!stack.isEmpty() && c.equals("Z")){
                String k=stack.peek();
                result-=Integer.parseInt(k);
            }else{
                result+=Integer.parseInt(c);
                stack.push(c);
            }
        }
        return result;
    }
}