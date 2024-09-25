import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static int N;
    static StringTokenizer st;
    static char[] arr;
    static int redBall=0;
    static int blueBall=0;
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new char[N];
        String str=br.readLine();
        arr=str.toCharArray();
        for(int i=0;i<N;i++){
            if(arr[i]=='R'){
                redBall+=1;
            }else{
                blueBall+=1;
            }
        }
        //전부 파란색 볼 또는 빨간색 볼일 때
        if(redBall==0 || blueBall==0){
            System.out.println(0);
            exit(0);
        }
        //비교값
        int cnt=0;

        //왼쪽에 빨간 볼 모으기
        for(int i=0;i<N;i++){
            if(arr[i]=='R'){
                cnt+=1;
            //파란 공 나올는 값 증가 멈추기
            }else {
                break;
            }
        }
        res=Math.min(redBall-cnt,res);

        //왼쪽에 파란 볼 모으기
        cnt=0;
        for(int i=0;i<N;i++){
            if(arr[i]=='B'){
                cnt+=1;
            }else{
                break;
            }
        }
        res=Math.min(blueBall-cnt,res);

        //오른쪽에  빨간 볼 모으기
        cnt=0;
        for(int i=N-1;i>=0;i--){
            if(arr[i]=='R'){
                cnt+=1;
            }else{
                break;
            }
        }
        res=Math.min(redBall-cnt,res);

        //오른쪽에 파란 볼 모으기
        cnt=0;
        for(int i=N-1;i>=0;i--){
            if(arr[i]=='B'){
                cnt+=1;
            }else{
                break;
            }
        }
        res=Math.min(blueBall-cnt,res);

        System.out.println(res);

    }
}
