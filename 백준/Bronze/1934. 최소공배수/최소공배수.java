import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int testCase;
    public static int gcd;
    public static StringTokenizer st;
    public static void uclid(int big,int small){
        if(big%small==0){
            gcd=small;
            return;
        }
        uclid(small,big%small);
    }
    public static void result(int big,int small,int gcd){
        System.out.println((big*small)/gcd);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        testCase=Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            st=new StringTokenizer(br.readLine());
            int small=Integer.parseInt(st.nextToken());
            int big=Integer.parseInt(st.nextToken());
            uclid(big,small);
            result(big,small,gcd);
        }
    }
}
