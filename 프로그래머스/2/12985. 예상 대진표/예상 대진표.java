class Solution
{
    private static boolean isStop(int i){
        return i/2==0;
    }
    public int solution(int n, int a, int b)
    {
        int cnt=0;
        while(true){
            a=a/2+a%2;
            b=b/2+b%2;
            cnt++;
            if(a==b)break;
        }
        //1 2 3 4
        return cnt;
    }
}