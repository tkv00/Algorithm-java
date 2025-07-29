import java.io.*;
import java.util.*;
public class Main {
    private static int W,H;
    private static StringTokenizer st;
    private static int[] block;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        block=new int[W];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++){
            block[i]=Integer.parseInt(st.nextToken());
        }

        int sum=0;
        for(int i=1;i<W-1;i++){
            int left=0;
            int right=0;

            //왼쪽
            for(int j=i;j>=0;j--){
                left=Math.max(left,block[j]);
            }
            //오른쪽
            for(int j=i;j<W;j++){
                right=Math.max(right,block[j]);
            }
            if(block[i]<left && block[i]<right){
                sum+=Math.min(left,right)-block[i];
            }

        }
        System.out.print(sum);
    }
}
