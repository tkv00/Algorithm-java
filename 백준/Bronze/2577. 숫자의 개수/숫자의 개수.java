import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        long A,B,C;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        A=Long.parseLong(br.readLine());
        B=Long.parseLong(br.readLine());
        C=Long.parseLong(br.readLine());
        int[] resultArr=new int[10];

        long result=A*B*C;
        char[] arr=String.valueOf(result).toCharArray();

        for (char c:arr){
            resultArr[c-'0']++;
        }

        for (int x:resultArr){
            System.out.println(x);
        }
    }
}
