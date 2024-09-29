import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int x;
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        x=Integer.parseInt(br.readLine());

        //arr배열 오츰차순 정렬
        Arrays.sort(arr);
        //왼쪽 포인터
        int start=0;
        //오른쪽 포인터
        int end=n-1;

        while (start<end){
            int sum=arr[start]+arr[end];
            //합이 x랑 같다면 res증가
            if(sum==x){
                start++;
                end--;
                res++;
            }
            //합이 x보다 크다면 오른쪽 포인터 줄이기
            if(sum>x)end--;
            //합이 x보타 작다면 왼쪽 포인터 늘리기
            if(sum<x)start++;
        }
        System.out.println(res);

    }
}
