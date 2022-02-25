package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_10158_개미 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); // 가로
		int H = Integer.parseInt(st.nextToken()); // 세로
		
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		int x = (w + time) % (W*2);
		int y = (h + time) % (H*2);

		x = W - Math.abs(W-x);
		y = H - Math.abs(H-y);
		
		System.out.print(x + " " + y);
	}

}
