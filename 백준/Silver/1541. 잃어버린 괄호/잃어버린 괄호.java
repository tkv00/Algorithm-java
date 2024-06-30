import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int res=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        String []minusInput=input.split("-");

        String []firstnum=minusInput[0].split("\\+");
        for(String index:firstnum){
            res+=Integer.parseInt(index);
        }

        for(int i=1;i<minusInput.length;i++){
            if(minusInput[i].contains("+")){
                String []num=minusInput[i].split("\\+");
                int sum=0;
                for(String index:num){
                    sum+=Integer.parseInt(index);
                }
                res-=sum;
            }
            else{
                res-=Integer.parseInt(minusInput[i]);
            }
        }
        System.out.println(res);
       // System.out.println(Arrays.toString(minusInput));


    }
}
