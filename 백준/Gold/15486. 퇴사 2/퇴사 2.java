import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Counsel{
        int start;
        int end;
        int cost;

        Counsel(int start,int end,int cost){
            this.start=start;
            this.end=end;
            this.cost=cost;
        }
    }
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static Counsel[] inputs;
    private static int[] dp;
    private static int max=0;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        inputs=new Counsel[N+1];
        dp=new int[N+1];

        for (int day=1;day<=N;day++){
            st=new StringTokenizer(br.readLine());

            int T=Integer.parseInt(st.nextToken());//걸리는 날짜
            int P=Integer.parseInt(st.nextToken());//받을 수 있는 금액

            inputs[day]=new Counsel(day,day+T-1,P);

        }
    }

    private static void dynamicProgramming(){
        for (int i=1;i<=N;i++){
            Counsel now=inputs[i];
            //상담을 하지 않는 case
            dp[i]=Math.max(dp[i-1],dp[i]);

            //상담을 하는 경우
            if (now.end>N) continue;
            dp[now.end]=Math.max(dp[now.end],now.cost+dp[now.start-1]);

            //System.out.println("day : "+i+" "+Arrays.toString(dp));

            max=Math.max(max,dp[now.end]);
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        dynamicProgramming();
        //System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
