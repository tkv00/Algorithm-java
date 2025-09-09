import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        
        int cnt=0;
        while(a!=b){
            a = (a%2==0) ? a/2 : a/2+1;
            b = (b%2==0) ? b/2 : b/2+1;
            cnt++;
        }
        return cnt;
    }
}