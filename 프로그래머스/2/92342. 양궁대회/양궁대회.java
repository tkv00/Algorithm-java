class Solution {
    //라이언 배열
    private static int[] apeach;
    //최대 점수
    private static int maxDiff;
    private static int[] answer;
    
    private static int getScore(int[] ryan){
        int score=0;
        for(int i=0;i<ryan.length;i++){
            if(ryan[i] + apeach[i]>0){
                //라이언이 점수 획득하면 +, 어피치가 점수 획득하면 -
                score+=ryan[i]>apeach[i] ? (10-i):-(10-i);  
            }
        }
        return score;
    }
    
    private static void calculateDiff(int[] ryan){
        int score=getScore(ryan);
        if(score>maxDiff){
            maxDiff=score;
            answer=ryan.clone();
        }
        //점수가 같은 경우
        else if(maxDiff>0 && maxDiff==score){
            //가장 낮은 점수가 많은 배열 리턴
            for(int i=10;i>=0;i--){
                if(answer[i]!=ryan[i]){
                    if(answer[i]<ryan[i]){
                        answer=ryan.clone();
                    }
                    break;
                }
            }
        }
    } 
    
    private static void backtrack(int n ,int idx,int[] ryan){
        //쏜 화살 개수
        if(n==0){
            calculateDiff(ryan);
            return;
        }
        
        for(int i=idx;i<=10;i++){
            int cnt=Math.min(apeach[i]+1,n);
            ryan[i]=cnt;
            backtrack(n-cnt,idx+1,ryan);
            ryan[i]=0;
        }
    }
    
    public int[] solution(int n, int[] info) {
        apeach=info;
        maxDiff=0;
        backtrack(n,0,new int[11]);
        return maxDiff==0 ? new int[]{-1} : answer;
    }
}