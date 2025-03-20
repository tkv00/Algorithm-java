import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        char[] result=new char[n];
        for(int i=0;i<n;i++){
            result[i]='O';
        }
        int[] up=new int[n+2];
        int[] down=new int[n+2];
        
        for(int i=0;i<n+2;i++){
            up[i]=i-1;
            down[i]=i+1;
        }
        
        //삭제 저장
        Stack<Integer> stack=new Stack<>();
        int idx=k;
        idx++;
        for(String str:cmd){
            if(str.startsWith("C")){
                up[down[idx]]=up[idx];
                down[up[idx]]=down[idx];
                stack.push(idx);
                
                idx=n<down[idx] ? up[idx] : down[idx];
            }else if(str.startsWith("Z")){
                int restore=stack.pop();
                down[up[restore]]=restore;
                up[down[restore]]=restore;
            }else{
                String[] nstr=str.split(" ");
                int x=Integer.parseInt(nstr[1]);
                for(int i=0;i<x;i++){
                    idx=nstr[0].equals("U") ? up[idx] : down[idx];
                }
            }
        }
        
        for(int i:stack){
            result[i-1]='X';
        }
        return String.valueOf(result);
    }
}