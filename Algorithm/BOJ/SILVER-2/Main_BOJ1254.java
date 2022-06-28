package week4;

import java.io.*;
import java.util.*;

//public class Main_BOJ1254 {
//
//	public static void main(String[] args)throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		char[] arr = new char[str.length()];
//		arr = str.toCharArray();
//		
//		for(int i=;i<)
//	}
//
//}


public class Main_BOJ1254 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calculate(input));
    }

    private static int calculate(String input) {
        int len = input.length();

        for (int i=0; i<len; i++) {
            if (isPalin(input.substring(i))) {
                return len+i;
            }
        }
        return len*2;
    }

    private static boolean isPalin(String input) {
        int len = input.length();

        for (int i=0; i<len; i++) {
            if (input.charAt(i) != input.charAt(len-i-1)) {
                return false;
            }
        }

        return true;
    }
}