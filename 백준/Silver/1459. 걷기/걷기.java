import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long answer = 0;

        // 위치 X , Y
        long X = Long.parseLong(arr[0]);
        long Y = Long.parseLong(arr[1]);
        
        // 한 블록 이동 시간 : W
        long W = Long.parseLong(arr[2]);
        
        // 블록 대각선으로 가로지르는 시간 : S
        long S = Long.parseLong(arr[3]);

        if  (2 * W < S) {
            answer = (X+Y) * W;
        }

        else if (2 * W > 2 * S) {
            if ((X+Y) % 2 == 0) {
                answer = Math.max(X,Y) * S;
            }

            else {
                answer = (Math.max(X,Y) - 1) * S;
                answer += W;
            }
        }

        else {
            if (X == Y) {
                answer = S * X;
            }

            else {
                answer = Math.min(X * S, Y * S);
                answer += Math.abs(X-Y) * W;
            }
        }

        System.out.println(answer);
    }
}
