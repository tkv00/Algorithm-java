import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N,K;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        int[] room=new int[13];
        int result=0;
        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int level=Integer.parseInt(st.nextToken());
            int count=Integer.parseInt(st.nextToken());
            room[level*6+count]++;
        }


        for (int i=1;i<=12;i++){
            //여학생 방부터
            if(room[i]!=0){
                result+= (int) Math.ceil(((double) room[i]/K));
            }
        }
        System.out.println(result);
    }
}
