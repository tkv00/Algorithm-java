import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String str1;
    public static String str2;
    public static char[]arr1;
    public static char[]arr2;
    public static int[][] LCS;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        str1=br.readLine();
        str2=br.readLine();
        arr1=str1.toCharArray();
        arr2=str2.toCharArray();
        int row=arr1.length;
        int col=arr2.length;

        LCS=new int[row+1][col+1];
        int max=-1;
        for(int i=1;i<=col;i++){
            for(int j=1;j<=row;j++){
                //같은 경우
                if(arr1[j-1]==arr2[i-1]){
                    LCS[j][i]=LCS[j-1][i-1]+1;
                }else{
                    LCS[j][i]=Math.max(LCS[j-1][i],LCS[j][i-1]);
                }
                max=Math.max(max,LCS[j][i]);
            }
        }
        System.out.println(max);


    }
}
