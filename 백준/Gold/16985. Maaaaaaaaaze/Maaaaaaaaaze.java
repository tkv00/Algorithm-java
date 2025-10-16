import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int SIZE = 5;
    private static final int LOCKED = 0;
    private static final int OPEN = 1;
    private static Map<Integer, int[][]> originalCube;
    //모든 큐브 조합
    private static List<Map<Integer, int[][]>> allCubes;

    //격자판 조합
    private static boolean[] visited;
    private static BufferedReader br;
    private static StringTokenizer st;

    //격자이동
    private static int[] dx = new int[]{0, 0, 1, -1, 0, 0};
    private static int[] dy = new int[]{1, -1, 0, 0, 0, 0};
    private static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    private static int[] findX = new int[]{0, 0, 4, 4};
    private static int[] findY = new int[]{0, 4, 0, 4};

    private static int dist = Integer.MAX_VALUE;

    private static void init() throws IOException {
        originalCube = new HashMap<>();
        allCubes = new ArrayList<>();
        visited = new boolean[SIZE];
        br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            int[][] arr = new int[SIZE][SIZE];
            for (int j = 0; j < SIZE; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < SIZE; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[j][k] = num;
                }
            }
            originalCube.put(i, arr);
        }
    }

    //큐브 조합 생성 - 쌓는 조합
    private static void combination(int depth, Map<Integer, int[][]> cube) {
        if (depth == SIZE) {
            allCubes.add(new HashMap<>(cube));
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (visited[i]) continue;
            int[][] map = originalCube.get(i);

            visited[i] = true;
            cube.put(depth, map);

            combination(depth + 1, cube);

            visited[i] = false;
            cube.remove(depth);
        }

    }

    //최단 거리 측정
    private static int BFS(int[][][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visit = new boolean[SIZE][SIZE][SIZE];

        //출발 설정
        visit[0][0][0] = true;
        q.offer(new int[]{0, 0, 0});
        int[][][] distMap = new int[SIZE][SIZE][SIZE];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 6; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                int nz = now[2] + dz[d];

                if (isValid(nx, ny, nz) && !visit[nx][ny][nz] && map[nz][nx][ny] == OPEN) {
                    int[] newPosition = new int[]{nx, ny, nz};
                    visit[nx][ny][nz] = true;
                    distMap[nx][ny][nz] = distMap[now[0]][now[1]][now[2]] + 1;
                    q.offer(newPosition);
                }
            }
        }

        //1. 결국 참가자가 선택할 수 있는 출발 또는 도착 꼭짓점은 8개 -
        //2. 서로 면이 공유 되면 안되므로 도착 지점은 각각 1개로 정해져 있음
        //3. 도착->출발 OR 출발->도착 거리값은 같으므로 출발 지점 선택할 떄 4가지 경우에 대해서만 돌리면됨.

        return visit[4][4][4] ? distMap[4][4][4] : Integer.MAX_VALUE;
    }

    //이동 시 유효성 검사
    private static boolean isValid(int row, int col, int z) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && z >= 0 && z < SIZE;
    }

    //시계 방향 회전
    private static int[][] rotation(int[][] arr) {
        int[][] newArr = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                newArr[i][j] = arr[j][SIZE - i - 1];
            }
        }
        return newArr;
    }

    //동작
    private static void operation(int depth, int[][][] cube) {
        if (depth == SIZE) {
            if (cube[0][0][0] == LOCKED || cube[4][4][4] == LOCKED) return;

            int d = BFS(cube);
            dist = Math.min(d, dist);
            return;
        }

        //현재 층
        int[][] base = cube[depth];
        for (int r = 0; r < 4; r++) {
            operation(depth + 1, cube);
            cube[depth] = rotation(cube[depth]);
        }
        cube[depth] = base;
    }

    private static int[][][] buildArr(Map<Integer, int[][]> map) {
        int[][][] arr = new int[SIZE][SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            int[][] now = map.get(i);
            arr[i] = now;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        init();
        combination(0, new HashMap<>());
        for (Map<Integer, int[][]> map : allCubes) {
            int[][][] cube = buildArr(map);
            operation(0, cube);
        }
        System.out.println(dist == Integer.MAX_VALUE ? -1 : dist);
    }
}
