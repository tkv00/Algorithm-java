import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static long sum(long a){
        long sum=0;
        while (a!=0) {
            sum+=Math.pow(a%10, P);
            a/=10;
        }
        return sum;
    }
    private static int A,P;
    private static ArrayList<Long> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        A=Integer.parseInt(input.split(" ")[0]);
        P=Integer.parseInt(input.split(" ")[1]);
        list.add((long)A);
        int idx=0;
        long number=A;
        while (true) {
            long newNumber=sum(list.get(idx));
            if(list.contains(newNumber)){
                number=newNumber;
                break;
            } 
            list.add(newNumber);
            idx++;
        }
        System.out.println(list.indexOf(number));
    }
    
}
