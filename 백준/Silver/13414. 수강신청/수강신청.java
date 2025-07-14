import java.io.*;
import java.util.*;
public class Main {
    private static int K,L;
    private static StringTokenizer st;
    private static LinkedHashSet<String> set=new LinkedHashSet<>();
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        K=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        for(int i=1;i<=L;i++){
            String str=br.readLine();
            if(set.contains(str)) set.remove(str);
            set.add(str);
        }
        StringBuilder sb=new StringBuilder();
        for(String key:set){
            sb.append(key).append("\n");
            K--;
            if(K==0)break;
        }
        System.out.print(sb);
    }
}
