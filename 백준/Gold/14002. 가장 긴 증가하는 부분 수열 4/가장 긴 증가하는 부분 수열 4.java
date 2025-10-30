import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] dp;
    private static int[] input;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int result=Integer.MIN_VALUE;
    private static StringBuilder sb;
    private static List<Integer> list;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb=new StringBuilder();
        list=new ArrayList<>();

        dp = new int[N];
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dynamicProgramming() {
        for (int i = 0; i < N; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            result=Math.max(dp[i],result);
        }

        sb.append(result).append("\n");
    }

    private static void findRoot(){
        for (int i=N-1;i>=0;i--){
            if (result==dp[i]){
                list.add(input[i]);
                result--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dynamicProgramming();
        findRoot();

        for (int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
