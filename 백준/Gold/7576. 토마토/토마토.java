import java.util.*;
import java.io.*;

public class Main {
    
    // 북 / 동 / 남 / 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static int[][] visited;
    static int M,N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        Queue<int[]> list = new LinkedList<>();
        board = new int[N][M];
        visited = new int[N][M];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    list.add(new int[]{i,j});
                }
            }
        }
        bfs(list,board,visited);
        //System.out.println(Arrays.deepToString(board));
        //System.out.println(Arrays.deepToString(visited));

        int answer = 0;
        int chk = 0;
        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                if (board[i][j] == 0) {
                    answer = -1;
                    chk = 1;
                    break;
                }

                else {
                    answer = Math.max(answer,board[i][j]);
                }
            }
        }

        if (chk == 1) {
            answer = 0;
        } 

        System.out.println(answer - 1);

    }

    public static void bfs(Queue<int[]> list, int[][] board, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int L = list.size();
        for (int i=0; i < L; i++) {
            int[] arr = list.poll();
            int x = arr[0];
            int y = arr[1];
            q.add(new int[]{x,y});
            visited[x][y] = 1;
        }

        while (!q.isEmpty()) {
            int[] init = q.poll();
            int sx = init[0];
            int sy = init[1];

            for (int d=0; d < 4; d++) {
                int nx = sx + dx[d];
                int ny = sy + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] == 0 && visited[nx][ny] == 0) {
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = 1;
                        board[nx][ny] = board[sx][sy] + 1;
                    }
                }
            }
        }
    }
}
