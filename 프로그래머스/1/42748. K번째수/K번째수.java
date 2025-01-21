import java.util.*;

class Solution {
    private int sort_cut(int[] arr,int[] command){
        int size=command[1]-command[0]+1;
        int[] cut=new int[size];
        for(int i=0;i<size;i++){
            cut[i]=arr[command[0]-1+i];
        }
        Arrays.sort(cut);
        return cut[command[2]-1];
    }
    
    public int[] solution(int[] array, int[][] commands) {
        int size=commands.length;
        int[] answer = new int[size];
        
        for(int i=0;i<size;i++){
            answer[i]=sort_cut(array,commands[i]);
        }
        return answer;
    }
}