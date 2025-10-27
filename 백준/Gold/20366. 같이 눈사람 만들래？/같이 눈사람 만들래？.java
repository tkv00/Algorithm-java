import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] arr;
    private static List<int[]> pq;
    private static int min=Integer.MAX_VALUE;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        pq=new ArrayList<>();

        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }

    private static void combination(){
        for (int i=0;i<N-1;i++){
            for (int j=i+1;j<N;j++){
                pq.add(new int[]{i,j,arr[i]+arr[j]});
            }
        }

        pq.sort((a, b) -> a[2] - b[2]);
    }

    private static void operation(){

        int size=pq.size();
        for (int i=0;i<size-1;i++){
            int[] snowMan1=pq.get(i);
            int[] snowMan2=pq.get(i+1);

            if (snowMan1[0]==snowMan2[0] || snowMan1[1]==snowMan2[1] || snowMan1[1]==snowMan2[0] || snowMan1[0]==snowMan2[1]) continue;

            min=Math.min(min,snowMan2[2]-snowMan1[2]);
            
        }
        System.out.println(min);
    }
    public static void main(String[] args) throws IOException {
        init();
        combination();
        operation();
    }
}
