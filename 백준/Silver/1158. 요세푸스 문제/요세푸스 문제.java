import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;
    private static StringTokenizer st;
    private static LinkedList<Integer> list=new LinkedList<>();
    private static LinkedList<Integer> input=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++){
            input.add(i);
        }
        ListIterator<Integer> iter=input.listIterator();

        while(!input.isEmpty()){
            for(int i=0;i<K-1;i++){
                if(!iter.hasNext()){
                    iter=input.listIterator();
                }
                iter.next();
            }
            if(!iter.hasNext()){
                iter=input.listIterator();
            }

            int removed=iter.next();
            iter.remove();
            list.add(removed);
        }
        StringBuilder sb=new StringBuilder();
        sb.append("<");

        for(int i=0;i<list.size();i++){
            if(i==list.size()-1){

                sb.append(list.get(i)).append(">");
                break;
            }
           sb.append(list.get(i)).append(", ");
        }
        System.out.print(sb);

    }

}
