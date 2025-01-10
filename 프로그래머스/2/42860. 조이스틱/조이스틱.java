class Solution {
    private static int answer=0;
    //A까지 알파벳 조이스틱 측정
    private static int toAlpha(char c){
        int k=c-'A';
        int t=26-k;
        return Math.min(k,t);
    }
    
    public int solution(String name) {
        char[] arr=name.toCharArray();
        int move=arr.length-1;
        
        //A가 2번째 인덱스이면 개수 1개 빼기
        for(int i=0;i<arr.length;i++){
            int idx=i+1;
            answer+=toAlpha(arr[i]);
            while(idx<arr.length && arr[idx]=='A'){
                idx++;
            }
            move=Math.min(move,Math.min(i*2+arr.length-idx,(arr.length-idx)*2+i));
            
        }
        return answer+move;
    }
    
}