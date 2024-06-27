import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static ArrayList<Integer> array;
    public static int [] sumArray;
    public static StringTokenizer st;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


        array=new ArrayList<>();
        sumArray=new int[N+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            array.add(Integer.valueOf(st.nextToken()));
        }

        for(int i=1;i<=N;i++){
            sumArray[i]=array.get(i-1)+sumArray[i-1];
        }
      
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            System.out.println(sumArray[m]-sumArray[n-1]);

        }




    }

}
