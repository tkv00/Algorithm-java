import java.util.*;

class Solution {
    private static Set<Integer>[] bucket;
    
    public int solution(int N, int number) {
        //초기화
        int answer=-1;
        
        bucket=new Set[9];
        for(int i=0;i<9;i++){
            bucket[i]=new HashSet<>();
        }
        
        //NNN...으로 만든 수 넣기
        for(int i=1;i<9;i++){
            String str="";
            for(int j=1;j<=i;j++){
                str+=String.valueOf(N);
            }
            //str->int
            int input=Integer.parseInt(str);
            bucket[i].add(input);
        }
        
        //ex. 3개로 만든 수->2+1,1+2
        for(int i=1;i<=8;i++){
            for(int j=1;j<i;j++){
                for(int k:bucket[j]){
                    for(int t:bucket[i-j]){
                        bucket[i].add(k+t);
                        bucket[i].add(k*t);
                        bucket[i].add(t-k);
                        if(k!=0){
                            bucket[i].add(t/k);
                        }
                    }
                }
            }
        }
        
        for(int i=1;i<=8;i++){
            if(bucket[i].contains(number)){
                answer=i;
                break;
            }
        }
        return answer;
    }
}