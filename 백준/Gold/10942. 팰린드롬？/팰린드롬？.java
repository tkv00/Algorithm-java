import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    static int question;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1][N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            dp[i][i]=1;//1자리 수
        }
        //2자리 수
        for(int i=1;i<N;i++){
            if(arr[i]==arr[i+1]){
                dp[i][i+1]=1;
            }
        }
        //3 자리 수 이상
        for (int i=3;i<=N;i++){
            for(int j=1;j<=N-i+1;j++){
                //양 끝이 같아야함
                if(arr[j]==arr[i+j-1]){
                    //나머지 수들
                    if(dp[j+1][i+j-2]==1){
                        dp[j][i+j-1]=1;
                    }
                }
            }
        }
        question=Integer.parseInt(br.readLine());
        for(int i=0;i<question;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]+"\n");
        }
        System.out.println(sb);

    }

}
