import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int N;
    public static int[]arr;
    public static int[] sumArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        int size=(N*(N+1))/2;
        sumArr=new int[size];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int index=0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                sumArr[index++]=arr[i]+arr[j];
            }
        }
        Arrays.sort(sumArr);
        int max=-1;
        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                int t=arr[i]-arr[j];
                if(Arrays.binarySearch(sumArr, t) >-1){
                    max=Math.max(max,arr[i]);
                }
            }
        }
        System.out.println(max);


    }

}
