import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class Main {
    public static int n;
    public static int res=1;
    public static int []arr;
    public static int sum=3;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
       for(int i=1;i<=n;i++){
           arr[i]=i;
       }
        if(n==1 || n==2){
            System.out.println(1);
            exit(0);
        }
        int start=1,end=2;


        while (start<=end && end<=n/2+1){

           if(sum==n){
               res++;
               end++;
               sum+=arr[end];
           }else if(sum>n){
               sum-=arr[start];
               start++;
           }else{
               end++;
               sum+=arr[end];
           }
        }
        System.out.println(res);
    }


}
//6=1+2+3  10=4+3+2+1  21=10+11 22=12+
