import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static TEST_RESULT[] tests;
    private static class TEST_RESULT{
        String name;
        int korean;
        int english;
        int math;
        TEST_RESULT(String name,int korean,int english,int math){
            this.english=english;
            this.korean=korean;
            this.math=math;
            this.name=name;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        tests=new TEST_RESULT[N];

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String name=String.valueOf(st.nextToken());
            int korean=Integer.parseInt(st.nextToken());
            int english=Integer.parseInt(st.nextToken());
            int math=Integer.parseInt(st.nextToken());

            tests[i]=new TEST_RESULT(name,korean,english,math);
        }
        Arrays.sort(tests,(o1,o2)->{
            if ((o1.korean==o2.korean)&&(o1.math==o2.math)&&(o1.english==o2.english)){
                return o1.name.compareTo(o2.name);
            }
            if((o1.korean==o2.korean)&&(o1.english==o2.english)){
                return o2.math-o1.math;
            }
            if(o1.korean==o2.korean){
                return o1.english-o2.english;
            }

            return o2.korean-o1.korean;
        });

        StringBuilder sb=new StringBuilder();
        for (TEST_RESULT test:tests){
            sb.append(test.name).append("\n");
        }

        System.out.println(sb);
    }

}
