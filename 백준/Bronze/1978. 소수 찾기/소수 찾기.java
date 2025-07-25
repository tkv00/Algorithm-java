import java.io.*;
import java.util.*;
public class Main {
    private static StringTokenizer st;
    private static int N;
    private static boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int cnt=0;
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            if(isPrime(num)) cnt++;
        }
        System.out.print(cnt);

    }
}
