class Solution
{
    public boolean stop(int a,int b){
        int k=a>b ? a : b;
        if(Math.abs(a-b)==1 && k%2==0){
            return true;
        }
        return false;
    }
    public int solution(int n, int a, int b)
    {
        int cnt=0;
        //1이면 계속 1유지
        //짝수->나누기 2
        //홀수->+1 나누기 2
        //차이가 1일 때까지
        
        while(true){
            if(stop(a,b)){
                break;
            }
            a=a%2==0 ? a/2 : (a+1)/2;
            b=b%2==0 ? b/2 :(b+1)/2;
            cnt++;
        }
        return cnt+1;
    }
}