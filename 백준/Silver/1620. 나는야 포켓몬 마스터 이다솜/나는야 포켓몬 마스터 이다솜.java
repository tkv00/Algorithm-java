import java.util.*;
import java.io.*;
public class Main {
    private static int N,M;
    private static HashMap<String,Integer> map1=new HashMap<>();
    private static HashMap<Integer,String> map2=new HashMap<>();
    private static StringTokenizer st;
    private static boolean isDigit(String str){
        char[] arr=str.toCharArray();
        for(char c:arr){
            if(c>=48 && c<=57){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        int index=1;

        for(int i=0;i<N;i++){
            String str=br.readLine();
            map1.put(str,index);
            map2.put(index,str);
            index++;
        }

        for(int i=0;i<M;i++){
            String str=br.readLine();
            if(isDigit(str)){
                sb.append(map2.get(Integer.parseInt(str))).append("\n");
            }else{
                sb.append(map1.get(str)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
