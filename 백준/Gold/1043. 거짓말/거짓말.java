import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int peopleNum;
    public static int partyNum;
    public static int knowNum;
    public static int[] know;
    public static int[] arr;
    public static boolean[] list;
    public static StringTokenizer st;
    public static ArrayList<Integer>[] party;

    public static int getParent(int a,int []arr){
        if(a==arr[a]) return a;
        else return arr[a]=getParent(arr[a],arr);
    }
    public static void Union(int a,int b,int []arr){
        a=getParent(a,arr);
        b=getParent(b,arr);
        if(a>b) arr[a]=b;
        else arr[b]=a;
    }
    public static int res(){
        int k=0;
        for(int i=0;i<=partyNum;i++){
            if(list[i]) k++;
        }

        return k;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        peopleNum=Integer.parseInt(st.nextToken());
        partyNum=Integer.parseInt(st.nextToken());

        party= new ArrayList[partyNum+1];
        for(int i=0;i<=partyNum;i++){
            party[i]=new ArrayList<>();
        }

        st=new StringTokenizer(br.readLine());
        knowNum=Integer.parseInt(st.nextToken());

        arr=new int[peopleNum+1];
        for(int i=1;i<=peopleNum;i++){
            arr[i]=i;
        }

        know=new int[knowNum];
        //아는 사람 번호 입력받기
        for(int i=0;i<knowNum;i++){
            know[i]=Integer.parseInt(st.nextToken());
        }
        //각 파티 참가자들 리스트에 넣기
        for(int i=1;i<=partyNum;i++){
            st=new StringTokenizer(br.readLine());
            int size=Integer.parseInt(st.nextToken());
            for(int j=0;j<size;j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        //System.out.println(Arrays.toString(know));
       // System.out.println(Arrays.toString(party));

        for(int i=1;i<=partyNum;i++){
            int firstNum=party[i].get(0);
            for(int j=0;j<party[i].size();j++){
                Union(firstNum,party[i].get(j),arr);
            }
        }
        list=new boolean[partyNum+1];
        Arrays.fill(list,true);

       // System.out.println(Arrays.toString(arr));
        int cnt=0;
        for(int i=0;i<knowNum;i++){
            int knowIdx=getParent(know[i],arr);//알고 있는 사람의 그룹 번호
            for(int j=1;j<=partyNum;j++){
                for(int person:party[j]){
                    if(getParent(person,arr)==knowIdx){
                        list[j]=false;
                        break;
                    }
                }
            }

        }
        for(int i=1;i<=partyNum;i++){
            if(list[i]) cnt++;
        }
        System.out.println(cnt);





    }
}
