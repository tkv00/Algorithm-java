import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static int N,Q;
    private static StringBuilder sb=new StringBuilder();
    private static StringTokenizer st;
    private static BufferedReader br;
    private static TreeSet<Integer> tree;
    /*
     *
     * @param num : 도현이의 현재 위치 인덱스 값.
     * @return 시계 방향으로 이동해야 하는 최소 거리.
     */
    private static int getDistance(int num,int size){
        if(tree.isEmpty()) return -1;
        if(tree.contains(num)) return 0;
        int max=tree.last();

        Integer ceiling=tree.ceiling(num+1);
        if(ceiling==null){
            return size+tree.first()-num;
        }else{
            return ceiling-num;
        }
        
    }
    public static void main(String[] args) throws IOException {

        br=new BufferedReader(new InputStreamReader(System.in));
        tree=new TreeSet<>((a,b)->a-b);
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int x=Integer.parseInt(st.nextToken());
            //명소 목록 삽입.
            if(x==1)
                tree.add(i);
        }
        //도현이의 현재 위치
        int now=0;

        for(int i=0;i<Q;i++){
            int q=0,x=0;
            st=new StringTokenizer(br.readLine());
            q=Integer.parseInt(st.nextToken());
            if(st.hasMoreTokens()){
                x=Integer.parseInt(st.nextToken());
            }

            switch(q){
                case 1:
                    //명소인 경우
                    if(tree.contains(x-1)){
                        tree.remove(x-1);
                    }
                    //명소가 아닌 경우
                    else{
                        tree.add(x-1);
                    }
                    break;
                case 2:
                    now=(now+x)%N;
                    break;
                case 3:
                    sb.append(getDistance(now,N)).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
