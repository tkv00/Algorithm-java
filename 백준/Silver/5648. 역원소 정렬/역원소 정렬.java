import java.io.*;
import java.util.*;
public class Main {
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        List<Long> list=new LinkedList<>();
        int count=0;
        int N=Integer.parseInt(st.nextToken());
        while(true){
            while(st.hasMoreTokens()){
                String numStr=st.nextToken();
                String reverse=new StringBuilder(numStr).reverse().toString();
                list.add(Long.parseLong(reverse));
                count++;
            }
            if(count==N) break;
            st=new StringTokenizer(br.readLine());
        }
        
        Collections.sort(list);

        for(long x:list){
            sb.append(x).append("\n");
        }

        System.out.print(sb);
    }
}
