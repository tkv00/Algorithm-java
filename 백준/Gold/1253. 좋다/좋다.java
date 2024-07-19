import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static long[] arr;
    public static long[][] sub;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int res=0;
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while (left<right){
                if(left==i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }
                if(arr[left]+arr[right]==arr[i]){
                    res++;
                    break;
                } else if (arr[left]+arr[right]<arr[i]) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(res);
    }
}
