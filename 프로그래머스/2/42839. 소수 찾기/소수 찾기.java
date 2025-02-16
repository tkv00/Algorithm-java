import java.util.*;
class Solution {
    private static Set<Integer> primes=new HashSet<>();
    //소수 판단
    private static boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    } 
    private static int answer=0;
    private static void dfs(String str,String numbers,boolean[]visited){
        if(!str.isEmpty()){
            int number=Integer.parseInt(str);
            if(isPrime(number) && !primes.contains(number)){
                primes.add(number);
                answer++;
            }
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(str+numbers.charAt(i),numbers,visited);
                visited[i]=false;
            }
        }
    }
    public int solution(String numbers) {
        boolean[]visited=new boolean[numbers.length()];
        dfs("",numbers,visited);
        return answer;
        
    }
}