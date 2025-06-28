import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    private static LinkedList<Character> input;
    private static LinkedList<Character> resultString;
    private static StringTokenizer st;
    private static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String str=br.readLine();
            sb.append(result(str)).append("\n");
        }
        System.out.print(sb);
    }

    private static String result(String str){
        input=new LinkedList<>();
        for(char c:str.toCharArray()){
            input.add(c);
        }
        resultString=new LinkedList<>();
        ListIterator<Character> iter=resultString.listIterator();

        for(char c:input){
            switch(c){
                case '<':
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                    break;
                case '>':
                    if(iter.hasNext()){
                        iter.next();
                    }
                    break;
                case '-':
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default:
                    iter.add(c);
                    break;
            }
        }
        StringBuilder returnStr=new StringBuilder();
        for(char c:resultString){
            returnStr.append(c);
        }
        return returnStr.toString();
    }
}
