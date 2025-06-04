import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static Map<Long,Long> map=new HashMap<>();
    private static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            long k=Long.parseLong(br.readLine());
            map.put(k,map.getOrDefault(k,0L)+1);
        }
        list=new ArrayList<>(map.keySet());
        list.sort((o1,o2)->{
            if(!map.get(o1).equals(map.get(o2))){
                return Long.compare(map.get(o2),map.get(o1));
            }
            return Long.compare(o1,o2);
        });

        System.out.print(list.get(0));
    }
}
