import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        //뒤에서 부터 탐색
        for(int i=N-1;i>0;i--){
            //앞에 숫자가 더 크다면
            int score=0;
            if(arr[i]<=arr[i-1]){
                //점수계산은 앞의 숫자 - 뒤의 숫자 + 1 ex) 5 - 5 =0이니깐 +1
               score=arr[i-1]-arr[i]+1;
               res+=score;
               //그 앞의 숫자보다 1작은 수 부여
               arr[i-1]=arr[i]-1;
            }
        }
        System.out.println(res);

    }
}
