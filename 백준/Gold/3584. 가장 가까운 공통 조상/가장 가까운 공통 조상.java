import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static HashMap<Integer,Integer> tree; //자식 / 부모

    private static int testCnt;
    private static int N;
    private static StringTokenizer st;
    private static Integer[] result;
    private static int idx=0;
    private static LinkedList<Integer> list_1;
    private static LinkedList<Integer> list_2;
    private static void makeTree(int parent,int child){
        tree.put(child,parent);
    }
    private static void findNearByParent(HashMap<Integer, Integer> tree,
                                        LinkedList<Integer> list,
                                        int child) {
        list.add(child);
        //부모찾기
        while(tree.containsKey(child)){
            child=tree.get(child);
            list.add(child);
        }
    }
    private static Integer findEqualNumber(LinkedList<Integer> list1,
                                       LinkedList<Integer>list2){
        HashSet<Integer> set=new HashSet<>(list1);
        for (Integer integer : list2) {
            //System.out.print(integer1+" ");
            if(set.contains(integer)){
                return integer;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        testCnt=Integer.parseInt(br.readLine());
        result=new Integer[testCnt];

        for(;testCnt>0;testCnt--){
            tree=new HashMap<>();
            st=new StringTokenizer(br.readLine());
            int nodeCnt=Integer.parseInt(st.nextToken());

            for(int i=0;i<nodeCnt-1;i++){
                st=new StringTokenizer(br.readLine());
                int parent=Integer.parseInt(st.nextToken());
                int child=Integer.parseInt(st.nextToken());

                makeTree(parent,child);
            }
            st=new StringTokenizer(br.readLine());
            int find_1=Integer.parseInt(st.nextToken());
            int find_2=Integer.parseInt(st.nextToken());

            list_1=new LinkedList<>();
            list_2=new LinkedList<>();

            findNearByParent(tree,list_1,find_1);
            findNearByParent(tree,list_2,find_2);

            result[idx++]=findEqualNumber(list_1,list_2);
        }

        for(int answer:result){
            System.out.println(answer);
        }
    }
}
