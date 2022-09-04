import java.io.*;

public class Solution_SWEA_D3_13218 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int answer = n/3;
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
