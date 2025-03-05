import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());

        int answer = 0;

        if (n >= 500) {
            answer += n / 500;
            n = n % 500;
        }

        if (n >= 100) {
            answer += n / 100;
            n = n % 100;
        }

        if (n >= 50) {
            answer += n / 50;
            n = n % 50;
        }

        if (n >= 10) {
            answer += n / 10;
            n = n % 10;
        }

        if (n >= 5) {
            answer += n / 5;
             n = n % 5;
        }

        answer += n;

        System.out.println(answer);
    }
}
