import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static StringTokenizer st;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=i;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(num==0){
                Union(a,b);
               }
            else {
                if(Find(a)==Find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
            //System.out.println(Arrays.toString(arr));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static int Find(int a){
        if(arr[a]==a){
            return a;
        }
         return Find(arr[a]);
    }
    public static void Union(int a,int b){
        int num1=Find(a);
        int num2=Find(b);
        if(num1!=num2){
            arr[num2]=arr[num1];
        }
    }


}
