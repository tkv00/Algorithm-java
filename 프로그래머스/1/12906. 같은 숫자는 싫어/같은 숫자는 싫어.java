import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack=new Stack<>();
        
        for(int num:arr){
            if(!stack.isEmpty() && stack.peek().equals(num)){
                stack.pop();
            }
            stack.push(num);
        }
        int[]result=new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            result[i]=stack.get(i);
        }
        return result;
    }
}