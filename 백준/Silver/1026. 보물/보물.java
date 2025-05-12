import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] arrA;
    private static Integer[] arrB;
    private static int N;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arrA=new Integer[N];
        arrB=new Integer[N];

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arrA[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arrB[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arrA[i]*arrB[N-i-1];
        }
        System.out.println(sum);
    }
}
