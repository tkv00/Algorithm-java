class Solution {
    private static int answer=0;
    private static int depth;
    private static int t;
    public int solution(int[] numbers, int target) {
        //numbers배열 순서 바꾸지 않기
        depth=numbers.length;
        t=target;
        dfs(0,0,numbers);
        return answer;
        
    }
    public static void dfs(int total,int dep,int[] num){
        if(dep==depth){
            if(total==t){
                answer++;
            }
            return;
        }
        //더하기
        dfs(total+num[dep],dep+1,num);
        
        //빼기
        dfs(total-num[dep],dep+1,num);
        
    }
}