import java.util.*;
import java.io.*;

public class Main {

    public static int L,C;
    public static String[] password;
    public static String[] alpha;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        
        // 암호 길이
        L = Integer.parseInt(str1[0]);
        C = Integer.parseInt(str1[1]);

        password = new String[L];
        alpha = new String[C];

        alpha = br.readLine().split(" ");
        Arrays.sort(alpha);

        //System.out.println(Arrays.toString(password));
        //System.out.println(Arrays.toString(alpha));
        combin(0,0);

    }

    public static void combin(int len, int start) {

        if (len >= L) {
            if (check(password)) {
                for (String p : password) {
                    System.out.print(p);
                }
                System.out.println();
            }

            return;
        }

        for (int i=start; i < C; i++) {
            password[len] = alpha[i];
            combin(len+1, i+1);
        }
    }

    public static boolean check(String[] pw) {
        int c = 0; // 자음
        int v = 0; // 모음

        for (int i=0; i < password.length; i++) {
            if (password[i].equals("a") || password[i].equals("e") || password[i].equals("i") || password[i].equals("o") || password[i].equals("u")) {
                v += 1;
            }

            else {
                c += 1;
            }
        }

        if (c >= 2 && v >= 1) {
            return true;
        }

        else {
            return false;
        }
    }
}
