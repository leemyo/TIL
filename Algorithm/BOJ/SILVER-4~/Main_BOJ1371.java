package July.week3;

import java.io.*;
import java.util.*;
// 인텔리제이 한 줄 복사: ctrl+D

public class Main_BOJ1371 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String str;

        while((str=br.readLine())!=null) {
            for(int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                if('a'<=ch && ch<='z') arr[ch-'a']++;
            }
        }

        int maxalpha = 0;
        for(int i=0;i<26;i++) {
            if(maxalpha<arr[i]) maxalpha=arr[i];
        }

        for(int i =0;i<26;i++) {
            if(arr[i]==maxalpha) System.out.print((char)('a'+i));
        }
        br.close();
    }
}
