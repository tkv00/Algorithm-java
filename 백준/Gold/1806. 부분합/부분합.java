import java.io.*;
import java.util.*;
public class Main {
    private static int N,S;
    private static StringTokenizer st;
    private static int[] input;
    private static int MIN=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        input=new int[N];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end=0;
        int sum=0;

        while(true){

            if(S<=sum){
                MIN=Math.min(MIN,end-start);
                sum-=input[start++];
            }else if(end==N) break;
            else {
                sum+=input[end++];
            }
        }
        System.out.print(MIN==Integer.MAX_VALUE?0:MIN);
    }
}
