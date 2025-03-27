import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][4];

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

    // 1. 국어 점수가 감소하는 순서로 (내림차순)
    // 2. 국어 점수가 같으면 : 영어 점수가 증가하는 순서로 (오름차순)
    // 3. 국어 점수와 영어 점수가 같으면 : 수학 점수가 감소하는 순서로 (내림차순)
    // 4. 모든 점수가 같으면 : 이름이 사전 순으로 증가하는 순서로 (오름차순)
    Arrays.sort(arr, new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            // 국어 점수가 같은 경우
            if (o1[1].equals(o2[1])) {

                // 영어 점수가 같은 경우
                if (o1[2].equals(o2[2])) {

                    // 수학 점수가 같은 경우
                    if (o1[3].equals(o2[3])) {
                        return o1[0].compareTo(o2[0]); // 이름 오름차순, ex) 내림차순 : o2[0].compareTo(o1[0])
                    } 

                    else {
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]); // 수학 내림차순
                    }

                }

                else {
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); // 영어 오름차순
                }
            }

            else {
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]); // 국어 내림차순순
            }
        }
    });

    for (int i=0; i < N; i++) {
        System.out.println(arr[i][0]);
    }
    }
}
