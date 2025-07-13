import java.io.*;
import java.util.*;
public class Main {
    private static StringTokenizer st;
    private static int N,M;
    private static HashMap<String,String> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            String str=br.readLine();
            String[] list=str.split(" ");
            map.put(list[0],list[1]);
        }

        for(int i=0;i<M;i++){
            String str=br.readLine();
            sb.append(map.get(str)).append("\n");
        }
        System.out.print(sb);
    }
}
