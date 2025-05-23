import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private static int N;
    private static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new Integer[N];
        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for (Integer x:arr){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
}
