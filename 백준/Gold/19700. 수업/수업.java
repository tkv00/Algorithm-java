import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static PriorityQueue<int[]> infos;
    private static TreeMap<Integer,Integer> teamSize;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        infos=new PriorityQueue<>((o1,o2)->o2[0]-o1[0]);
        N=Integer.parseInt(br.readLine());
        //팀 크기 - 팀 개수
        teamSize=new TreeMap<>();

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int h=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            infos.offer(new int[]{h,k});
        }
    }

    private static void operation(){
        while (!infos.isEmpty()){
            int[] now=infos.poll();

            Integer key=teamSize.lowerKey(now[1]);
            //팀이 없는 경우
            if(key==null){
                teamSize.put(1,teamSize.getOrDefault(1,0)+1);
            }else {
                int count=teamSize.get(key);
                if(count==1) teamSize.remove(key);
                else teamSize.put(key,teamSize.get(key)-1);

                teamSize.put(key+1,teamSize.getOrDefault(key+1,0)+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();

        int answer=0;
        for (int v:teamSize.values()){
            answer+=v;
        }

        System.out.println(answer);
    }
}
