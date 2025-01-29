class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        //실제 범위
        int width=w*2+1;
        int cnt=0;
        int start=1;
        for(int sta:stations){
            //왼쪽 부분
            int left=sta-w;
            if(start<left){
                int gap=left-start;
                answer+=(int)Math.ceil((double)gap/width);
            }
            start=sta+w+1;
        }
        if(start<=n){
            int gap=n-start+1;
            answer+=(int)Math.ceil((double)gap/width);
        }
        return answer;
    }
}