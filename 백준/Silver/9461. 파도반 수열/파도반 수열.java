import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int T;
    private static BufferedReader br;
    private static StringBuilder sb=new StringBuilder();
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            int num=Integer.parseInt(br.readLine());
            long[] arr=new long[num+1];
            sb.append(operation(arr,num)).append("\n");
        }
    }

    private static long operation(long[] arr,int N){
        arr[1]=1;
        if (N<=1) return arr[N];
        arr[2]=1;
        if (N == 2) return arr[N];

        for (int i=3;i<=N;i++){
            arr[i]=arr[i-3]+arr[i-2];
        }

        return arr[N];
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
