import java.io.*;
import java.util.*;
public class Main {
    private static int N,M;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] list=new int[N];
        for(int i=0;i<N;i++){
            list[i]=Integer.parseInt(st.nextToken());
        }
       

        int cnt=0;
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                sum+=list[j];
                if(sum>M) break;
                if(sum==M){
                    cnt++;
                    break;
                }
            }
        }
        System.out.print(cnt);
    }
}
