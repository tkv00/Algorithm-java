import java.io.*;
import java.util.*;
public class Main {
    private static Set<String> before=new HashSet<>();
    private static Set<String> after=new HashSet<>();
    private static Set<String> names=new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] times=br.readLine().split(" ");
        String S=times[0];
        String E=times[1];
        String Q=times[2];
        String str;
        while((str=br.readLine())!=null){
         
            String[] strs=str.split(" ");
            String time=strs[0];
            String name=strs[1];

            names.add(name);
            if(S.compareTo(time)>=0){
                before.add(name);
            }else if(E.compareTo(time)<=0 && Q.compareTo(time)>=0){
                after.add(name);
            }
        }
        int cnt=0;
        for(String name:names){
            if(before.contains(name) && after.contains(name)){
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
