import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int V;
    public static int E;
    public static int [][]arr;
    public static StringTokenizer st;
    public static int INF=4000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        arr=new int[V+1][V+1];
        for(int i=1;i<=V;i++){
            Arrays.fill(arr[i],INF);
        }
        for(int i=1;i<=E;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            arr[start][end]=cost;
        }





        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                for(int k=1;k<=V;k++){
                    arr[j][k]= Math.min(arr[j][k],arr[j][i]+arr[i][k]);
                }
            }
        }

        int MAX=INF;
       for(int i=1;i<=V;i++){
           MAX=Math.min(arr[i][i],MAX);
       }
        if(MAX==INF){
            System.out.println(-1);
        }else{
            System.out.println(MAX);
        }
    }


}
