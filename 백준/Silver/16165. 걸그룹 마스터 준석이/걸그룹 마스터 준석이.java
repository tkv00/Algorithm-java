import java.io.*;
import java.util.*;
public class Main {
    private static int N,M;
    private static HashMap<String,ArrayList<String>> map=new HashMap<>();
    private static StringTokenizer st;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String team=br.readLine();
            int memberNumber=Integer.parseInt(br.readLine());
            map.putIfAbsent(team,new ArrayList<>());

            for(int j=0;j<memberNumber;j++){
                String member=br.readLine();
                map.get(team).add(member);
            }
            //Array정렬
            Collections.sort(map.get(team));
        }

        for(int i=0;i<M;i++){
            String member=br.readLine();
            int type=Integer.parseInt(br.readLine());
            solve(type,member);
        }
        System.out.print(sb);
    }
    private static void solve(int type,String name){
        //팀 이름
        if(type==0){
            ArrayList<String> members=map.get(name);
            for(String member:members){
                sb.append(member).append("\n");
            }
        //멤버 이름
        }else if(type==1){
            for(String key:map.keySet()){
                if(map.get(key).contains(name)){
                    sb.append(key).append("\n");
                    break;
                }
            }
        }
    }
}
