import java.io.*;
import java.util.*;
public class Main {
    private static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        return true;
    }

    private static int solve(int n){
        int cnt=0;
        for(int i=n+1;i<=2*n;i++){
            if(isPrime(i))cnt++;
        }
        return cnt;
    }

    public static void main(String[] args)throws IOException{
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num;
        while((num=Integer.parseInt(br.readLine()))!=0){
            sb.append(solve(num)).append("\n");
        }

        System.out.print(sb);
    }
}
