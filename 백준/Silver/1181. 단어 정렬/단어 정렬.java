import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static int N;
    private static String[] strings;
    private static Set<String> set=new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
           set.add(String.valueOf(br.readLine()));
        }
        strings=new String[set.size()];

        int idx=0;
        for (String str:set){
            strings[idx++]=str;
        }

        Arrays.sort(strings,(o1,o2)->{
            if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        });
        StringBuilder sb=new StringBuilder();
        for (String str:strings){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
