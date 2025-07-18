import java.io.*;
import java.util.*;
public class Main {
    private static int T;
    private static int N,M;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
            }
            sb.append(N-1).append("\n");
        }
        System.out.print(sb);
    }
}
