import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char[] list=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char c:list){
            if(!stack.isEmpty() && c==stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
    if(stack.isEmpty())return 1;
    return 0;
    }
    
}