import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static Map<Integer,Integer> map=new HashMap<>();
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int idx=Integer.parseInt(br.readLine());
        System.out.println(map.getOrDefault(idx,0));
    }
}
