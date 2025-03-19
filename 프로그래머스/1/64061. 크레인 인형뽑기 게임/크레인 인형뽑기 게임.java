import java.util.*;
class Solution {

    public int solution(int[][] board, int[] moves) {
        int size=board.length;
        Stack<Integer> stack=new Stack<>();
        int result=0;
        
        for(int move:moves){
            for(int i=0;i<size;i++){
                if(board[i][move-1]!=0){
                    if(!stack.isEmpty() && stack.peek().equals(board[i][move-1])){
                        stack.pop();
                        result+=2;
                    }else{
                        stack.push(board[i][move-1]);                    
                    }
                    board[i][move-1]=0;
                    break;
                }
            }
        }
        return result;
    }
}