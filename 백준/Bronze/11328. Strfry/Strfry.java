import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb=new StringBuilder();
    private static char[] arr1;
    private static char[] arr2;
    private static StringTokenizer st;

    private static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            String str1=st.nextToken();
            String str2=st.nextToken();
            char[] ch1=str1.toCharArray();
            char[] ch2=str2.toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);
            boolean isSame=Arrays.equals(ch1,ch2);

            if(isSame){
                sb.append("Possible").append("\n");
            }else{
                sb.append("Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }
}
