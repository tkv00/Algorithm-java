import java.util.*;
class Solution {
    private static int sum(boolean[] arr){
        int sum=0;
        for(boolean value:arr){
            if(value) sum++;
        }
        return sum;
    }
    
    public int solution(int n, int[] lost, int[] reserve) {
        /*
        1.번호는 체격순
        2.앞번호 학생이나 바로 뒤 학생한테만 빌리기 가능
        3.최대한 많은 학생이 체육복 가지고 있아야 함
        */
        int[] cloth=new int[n+1];
        for(int idx:lost){
            cloth[idx]--;
        }
        for(int idx:reserve){
            cloth[idx]++;
        }
        
        for(int i=1;i<=n;i++){
            if(cloth[i]<0){
                if(i-1>=1 && cloth[i-1]>=1){
                    cloth[i-1]--;
                    cloth[i]++;
                }else if(i+1<=n && cloth[i+1]>=1){
                    cloth[i+1]--;
                    cloth[i]++;
                }
            }
        }
        int sum=0;
        for(int idx:cloth){
            if(idx>=0){
                sum++;
            }
        }
        
        return sum-1;
    }
}