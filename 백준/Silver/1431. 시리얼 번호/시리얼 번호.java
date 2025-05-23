import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static Node[] nodes;
    private static class Node{
        String str;
        Node(String str){
            this.str=str;
        }

        int getDigitSum(){
            int sum=0;
            for (char c:str.toCharArray()){
                int k=c-'0';
                if(k>=0 && k<10){
                    sum+=c-'0';
                }
            }
            return sum;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        nodes=new Node[N];
        for (int i=0;i<N;i++){
            String str=br.readLine();
            nodes[i]=new Node(str);
        }
        Arrays.sort(nodes,(o1,o2)->{
            if(o1.str.length()!=o2.str.length()){
                return o1.str.length()-o2.str.length();
            }

            int sum1=o1.getDigitSum();
            int sum2=o2.getDigitSum();

            if(sum1!=sum2){
                return sum1-sum2;
            }

            return o1.str.compareTo(o2.str);
        });

        StringBuilder sb=new StringBuilder();
        for (Node node:nodes){
            sb.append(node.str).append("\n");
        }
        System.out.println(sb);
    }
}
