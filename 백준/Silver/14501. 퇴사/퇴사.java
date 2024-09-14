import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringTokenizer st;
    //dp테이블
    static int[] dp;
    //걸리는 시간 배열
    static int[]time;
    //받을 수 있는 금액
    static int[]cost;
    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        //초기화
        dp=new int[N+2];
        time=new int[N+1];
        cost=new int[N+1];

        //입력값 받기
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            int input1=Integer.parseInt(st.nextToken());
            int input2=Integer.parseInt(st.nextToken());

            time[i]=input1;
            cost[i]=input2;
        }

        //up-down방식
        //예를 들면 N=7이면 8일까지 일을 완료 시 상담 가능
        //N~N+1,N-1~N+1,N-2~N+1.... dp테이블 완성
        for(int i=N;i>0;i--){
            //당일에 일을 하지 못하는 경우 -> 전날부터 N+1일까지 상담값 주면된다.
            if(i+time[i]>N+1){
                dp[i]=dp[i+1];
            }
            //당일에 일할 수 있는 경우
            else{
                dp[i]=Math.max(dp[i+1],cost[i]+dp[time[i]+i]);
            }
        }
        System.out.println(dp[1]);
    }
}
