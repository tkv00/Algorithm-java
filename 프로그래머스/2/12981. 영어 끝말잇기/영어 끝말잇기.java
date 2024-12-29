import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] union_array=new int[words.length];
        int find_index=-1;
        int second=1;
            
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<words.length;i++){
            //끝말잇기가 성립X
            if(!set.add(words[i])){
                find_index=i;
                break;
            }
          
            if(i>0 && (words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0))){
                find_index=i;
                break;
            }
            if((i+1)%n==0)second++;
        }
        
    
        if(find_index!=-1){
            int first=(find_index%n)+1;
            answer[0]=first;
            answer[1]=second;
        }
        return answer;
    }
}