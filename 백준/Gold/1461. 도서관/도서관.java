import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    //0보다 작은 수
     static int[] arr;
    static StringTokenizer st;
    static int walk=0;

    static boolean[]books;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        books=new boolean[N];
        arr=new int[N+1];
        arr[0]=0;
        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            int k=Integer.parseInt(st.nextToken());
           arr[i]=k;
        }
        Arrays.sort(arr);
        //0인 지점 찾기
        int pivot=0;
        for(int i=0;i<=N;i++){
            if(arr[i]==0){
                pivot=i;
            }
        }
       // System.out.println(Arrays.toString(arr));
        //왼쪽 계산
        for(int i=0;i<pivot;i+=M){
            walk+=Math.abs(arr[i])*2;
        }
        //System.out.println(walk);

        //오른쪽 계산
        for(int i=N;i>pivot;i-=M){
            walk+=arr[i]*2;
        }
        //System.out.println(walk);
        walk-=Math.max(Math.abs(arr[0]),Math.abs(arr[N]));

        System.out.println(walk);



    }
}
