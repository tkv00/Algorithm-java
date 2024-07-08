import java.util.Scanner;

public class Main {
    public static int n;
    public static int[]dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=Integer.parseInt(sc.next());
        if(n==1) {
            System.out.println(1);
            return;
        }
        dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;


        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }

       System.out.println(dp[n]);
    }
}
