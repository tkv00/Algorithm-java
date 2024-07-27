import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static StringTokenizer st;
    public static long x;
    public static long y;
    public static long N;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Long.parseLong(br.readLine());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            x=Long.parseLong(st.nextToken());
            y=Long.parseLong(st.nextToken());

            res(x,y);
        }
    }
    public static void res(long x,long y){
       long t=y-x;
       double k=Math.sqrt(t);
       long f=(long)k;
       if(k>f){
           if((f*f)<t && t<=(((f*f)+((f+1)*(f+1)))/2)){
               System.out.println(f*2);
           }else{
               System.out.println(f*2+1);
           }
       }else{
           System.out.println(f*2-1);
       }

    }
}
