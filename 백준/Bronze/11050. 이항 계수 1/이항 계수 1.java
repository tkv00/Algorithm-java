import java.io.*;
import java.util.*;
public class Main {
    private static int N,K;
    private static StringTokenizer st;
    private static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }
    private static int combination(int n,int k){
        return factorial(n)/(factorial(n-k)*factorial(k));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        if(N==K || K==0){
            System.out.print(1);
            return;
        }
        System.out.print(combination(N,K));
    }
}
