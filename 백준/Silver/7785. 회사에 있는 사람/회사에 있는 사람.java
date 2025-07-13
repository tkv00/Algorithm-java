import java.util.*;
import java.io.*;
public class Main {
    private static HashMap<String,String> map=new HashMap<>();
    private static ArrayList<String> result=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            String[] list = str.split(" ");
            map.put(list[0], list[1]);
        }

        for(String key:map.keySet()){
            if(map.get(key).equals("enter")){
                result.add(key);
            }
        }
        result.sort(Collections.reverseOrder());
        for(String st:result){
            System.out.println(st);
        }
    }
}
