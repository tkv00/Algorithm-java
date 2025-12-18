import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int M;//고정석 개수
    private static BufferedReader br;
    private static int[] dp;
    private static int end;
    private static int[] fix;
    private static int cnt = 1;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        fix = new int[N + 1];
        dp = new int[N + 1];
        dp[0]=1;
        if (N>=1) dp[1]=1;
        if (N>=2) dp[2]=2;
      

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            fix[num] = -1;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
    }


    //num : 사람 번호
    private static void operation() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (fix[i] ==0) {
                count++;
                if (i==N){
                    cnt *= dp[count];
                }
            } else if (fix[i] == -1) {
                cnt *= dp[count];
                count = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(cnt);
    }
}
