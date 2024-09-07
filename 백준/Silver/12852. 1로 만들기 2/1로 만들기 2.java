import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    public static int n;
    public static int[] arr=new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1]=0;
        arr[2]=1;
        arr[3]=1;
        int[] res=new int[n+1];
        res[0]=n;

        if(n>3){
            for(int i=4;i<=n;i++){
                if(i%3==0&&arr[i]>arr[i/3]+1){
                    arr[i]=arr[i/3]+1;
                    res[i]=i/3;
                }
                if(i%2==0&&arr[i]>arr[i/2]+1){
                    arr[i]=arr[i/2]+1;
                    res[i]=i/2;
                }
                if(arr[i]>arr[i-1]+1){
                    arr[i]=arr[i-1]+1;
                    res[i]=i-1;
                }
            }
        }

        System.out.println(arr[n]);
        int num=n;
        for(int i=0;i<arr[n];i++){
            sb.append(num+" ");
            num=res[num];
        }
        sb.append(1);
        System.out.println(sb);

    }
}
