import java.util.*;
import java.io.*;
public class Main {
    private static int N,C;
    private static StringTokenizer st;
    private static HashMap<Integer,Integer> map=new HashMap<>();
    private static HashMap<Integer,Integer> orderMap=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        ArrayList<Integer> list=new ArrayList<>();
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            list.add(num);
            map.put(num,map.getOrDefault(num,0)+1);
            if(!orderMap.containsKey(num)){
                orderMap.put(num,i);
            }
        }

        list.sort((o1,o2)->{
            Integer o1Count=map.get(o1);
            Integer o2Count=map.get(o2);

            if(o1Count.equals(o2Count)){
                return Integer.compare(orderMap.get(o1),orderMap.get(o2));
            }else{
                return Integer.compare(o2Count,o1Count);
            }
        });

        StringBuilder sb=new StringBuilder();
        for(int x:list){
            sb.append(x).append(" ");
        }

        System.out.print(sb);
    }
}
