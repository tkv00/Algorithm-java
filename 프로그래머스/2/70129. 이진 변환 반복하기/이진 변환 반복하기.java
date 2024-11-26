class Solution {
    public int[] solution(String s) {
        //변환 횟수 변수
        int cnt=0;
        //제거된 0의 개수
        int cntZero=0;
        while(!s.equals("1")){
            cnt++;
            //1.x의 모든 0 제거
            int k=s.replace("1","").length();//0의 개수 카운트
            cntZero+=k;
            
            //2진법 변환
            s=Integer.toBinaryString(s.length()-k);
            
        }
        int[] answer = {cnt,cntZero};
        return answer;
    }
}