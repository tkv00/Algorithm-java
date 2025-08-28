import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Problem{
        int number;
        int score;

        Problem(int number,int score){
            this.number=number;
            this.score=score;
        }
    }
    private static TreeSet<Problem> tree;
    private static Map<Integer, Integer> map=new HashMap<>();
    private static int N,M;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        tree=new TreeSet<>((a,b)->a.score==b.score ? a.number-b.number : a.score-b.score);

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            //문제 번호
            int P=Integer.parseInt(st.nextToken());
            //난이도
            int L=Integer.parseInt(st.nextToken());

            tree.add(new Problem(P,L));
            map.put(P,L);

        }
        //명령문 개수
        M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            String input=br.readLine();
            String[] inputs=input.split(" ");

            int P,L,x;
            switch(inputs[0]){
                case "add":
                    P=Integer.parseInt(inputs[1]);
                    L=Integer.parseInt(inputs[2]);
                    tree.add(new Problem(P,L));
                    map.put(P,L);
                    break;

                case "recommend":
                    x=Integer.parseInt(inputs[1]);
                    switch(x){
                        case 1:
                            sb.append(tree.last().number).append("\n");
                            break;

                        case -1:
                            sb.append(tree.first().number).append("\n");
                            break;
                    }
                    break;

                case "solved":
                    P=Integer.parseInt(inputs[1]);
                    //난이도 찾기
                    tree.remove(new Problem(P,map.get(P)));
                    map.remove(P);
                    break;

            }

        }
        System.out.print(sb.toString());
    }

}
