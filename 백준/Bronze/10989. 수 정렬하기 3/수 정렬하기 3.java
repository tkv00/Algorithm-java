import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        arr=new int[N];
        for (int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            arr[i]=num;
        }
        Arrays.sort(arr);
        for (int x:arr){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
}
