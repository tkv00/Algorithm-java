import java.util.Stack;
class Solution {
    boolean solution(String s) {
        char[] arr=s.toCharArray();
        Stack<Character>stack=new Stack<>();
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            stack.push(arr[i]);
        }
        
        while(!stack.isEmpty()){
            char c=stack.pop();
            if(cnt<0){
                return false;
            }
            
            if(c==')'){
                cnt++;
            }else if(c=='('){
                cnt--;
            }
        }
       if(cnt!=0){
           return false;
       }
         return true;
        
    }
}