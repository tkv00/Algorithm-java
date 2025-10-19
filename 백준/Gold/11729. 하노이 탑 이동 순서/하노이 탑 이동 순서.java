import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int K;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int cnt=0;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        sb=new StringBuilder();


    }
    private static void hanoi(int N,int s,int e,int aux){
        if (N==1){
            sb.append(s).append(" ").append(e).append("\n");
            cnt++;
            return;
        }

        hanoi(N-1,s,aux,e);
        sb.append(s).append(" ").append(e).append("\n");
        cnt++;
        hanoi(N-1,aux,e,s);
    }
    public static void main(String[] args) throws IOException {
        init();
        hanoi(K,1,3,2);
        sb.insert(0,cnt+"\n");
        System.out.println(sb);
    }
}
