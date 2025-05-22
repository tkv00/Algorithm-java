import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int result=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char[] arr=String.valueOf(N).toCharArray();
        int[] numArr=new int[10];

        for (int i=0;i<arr.length;i++){
            if(arr[i]=='6'|| arr[i]=='9'){
                if (numArr[6]>=numArr[9]){
                    numArr[9]++;
                }else {
                    numArr[6]++;
                }
            }else {
                numArr[arr[i]-'0']++;
            }
        }

        for (int x:numArr){
            result=Math.max(x,result);
        }

        System.out.println(result);
    }
}
