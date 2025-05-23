import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static Set<Integer> set=new HashSet<>();
    private static int N=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            set.add(num);
        }
        arr=new int[set.size()];
        int idx=0;
        for (int x:set){
            arr[idx++]=x;
        }
        Arrays.sort(arr);
        for (int x:arr){
            System.out.println(x);
        }

    }
}
