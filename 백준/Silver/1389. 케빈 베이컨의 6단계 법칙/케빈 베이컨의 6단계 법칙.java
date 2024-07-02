import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static int N;
    public static int M;
    public static StringTokenizer st;
    public static int[][] arr;
    public static final int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], INF);
        }
        // System.out.println(Arrays.deepToString(arr));
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
           
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for(int i=1;i<=N;i++){
            arr[i][i]=0;
        }
        //System.out.println(Arrays.deepToString(arr));
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                for (int k = 1; k <= N; k++) {
                   if(arr[j][k]>arr[j][i]+arr[i][k]){
                       arr[j][k]=arr[j][i] + arr[i][k];
                   }
                }

            }
        }
       // System.out.println(Arrays.deepToString(arr));
        int []index=new int[N+1];
        int min=1000001;
        for(int i=1;i<=N;i++){
            int sum=0;
            for (int j=1;j<=N;j++){
                sum+=arr[i][j];
            }
            if(sum<min){
                min=sum;
            }
            index[i]=sum;
        }
        //System.out.println(Arrays.toString(index));
        for(int i=1;i<=N;i++){
            if(min==index[i]){
                System.out.println(i);
                exit(0);
            }
        }
    }

}
