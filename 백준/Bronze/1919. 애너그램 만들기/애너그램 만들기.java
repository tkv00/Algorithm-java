import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int[] num1=new int[26];
    private static int[] num2=new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str1=br.readLine();
        String str2=br.readLine();
        int result=0;
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();

        for (char c:arr1){
            num1[c-'a']++;
        }
        for (char c:arr2){
            num2[c-'a']++;
        }

        for (int i=0;i<26;i++){
            if(num1[i]==num2[i]) continue;
            result+=Math.abs(num1[i]-num2[i]);
        }

        System.out.println(result);
    }
}
