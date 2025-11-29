import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static class Union{
        Set<Integer> set=new HashSet<>();

        void add(int x){
            if (!set.contains(x)) {
                set.add(x);
            }
        }

        void remove(int x){
            set.remove(x);
        }

        int check(int x){
            if (set.contains(x)) return 1;
            return 0;
        }

        void toggle(int x){
            if (set.contains(x)) set.remove(x);
            else set.add(x);
        }

        void empty(){
            this.set=new HashSet<>();
        }

        void all(){
            set=new HashSet<>();
            for (int i=1;i<=20;i++){
                set.add(i);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int M=Integer.parseInt(br.readLine());
        Union union=new Union();

        for (int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String order=st.nextToken();

            if (order.equals("all") || order.equals("empty")){
                if (order.equals("all")) {
                    union.all();
                } else {
                    union.empty();
                }
                continue;
            }

            int num=Integer.parseInt(st.nextToken());

            switch (order){
                case "add":
                    union.add(num);
                    break;
                case "remove":
                    union.remove(num);
                    break;
                case "check":
                    sb.append(union.check(num)).append("\n");
                    break;
                case "toggle":
                    union.toggle(num);
                    break;
            }
        }

        System.out.println(sb);

    }

}
