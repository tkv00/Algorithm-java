import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    public static long[]arr;
    public static long[]moduleArr;
    public static long[]subArr;
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new long[n+1];
        moduleArr=new long[n+1];
        subArr=new long[m];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        long res=0;//정답갯수
        for(int i=1;i<=n;i++){
            moduleArr[i]=(moduleArr[i-1]+arr[i])%m;
            subArr[(int) moduleArr[i]]++;
        }

        //System.out.println(Arrays.toString(moduleArr));
        for(int i=0;i<m;i++){
            if(i==0) {
                res+=  subArr[0];
            }
            if(subArr[i]>1){
                res+= ((subArr[i]*(subArr[i]-1))/2);
            }

        }
        System.out.println(res);
    }

}
