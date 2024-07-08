import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int n;//재료
    public static int m;//
    public static int []arr;
    public static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
       // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int start=0;
        int end=n-1;

        while (start<end){
            int sum=arr[start]+arr[end];
            if(sum==m){
                res++;
                start++;
                end--;
            }
            else if(sum>m){
                end--;
            }else {
                start++;
            }
        }
        System.out.println(res);
    }
}
