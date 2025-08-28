import java.util.*;
import java.io.*;
public class Main {
    private static int T;
    private static StringTokenizer st;
    private static int N,M;
    private static PriorityQueue<Integer> pq1;
    private static PriorityQueue<Integer> pq2;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());

            int[] arr1=new int[N];
            int[] arr2=new int[M];

            st=new StringTokenizer(br.readLine());
            //A 배열 입력
            for(int j=0;j<N;j++){
                arr1[j]=Integer.parseInt(st.nextToken());
            }

            st=new StringTokenizer(br.readLine());
            //B 배열 입력
            for(int j=0;j<M;j++){
                arr2[j]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int cnt=0;
            int idxA=0,idxB=0;
            while(idxA<N && idxB<M){
                if(arr1[idxA]>arr2[idxB]){
                    cnt+=N-idxA;
                    idxB++;
                }else idxA++;
            }
            sb.append(cnt).append("\n");

        }
        System.out.print(sb);
    }
}
