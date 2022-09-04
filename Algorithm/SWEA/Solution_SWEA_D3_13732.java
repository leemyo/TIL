import java.io.*;

public class Solution_SWEA_D3_13732 {

    static int N, sr, sc, er, ec;
    static char map[][];

    static void inputData(BufferedReader br) throws IOException {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='#') {
                    if(!flag){
                        sr = i; sc = j; er = i; ec = j; flag = true;
                    }
                    else{
                        er = i; ec = j;
                    }
                }
            }
        } // input
    }

    static boolean findAnswer(){

        if(er-sr != ec-sc) return false;

        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if(map[i][j]!='#') return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            inputData(br);
            if(findAnswer()) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.println(sb.toString());
    }
}
