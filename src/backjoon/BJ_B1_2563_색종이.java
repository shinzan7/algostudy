package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_2563_색종이 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//br = new BufferedReader(new StringReader(src));
		int[][] map = new int [100][100];
		
		int paperN = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < paperN; t++) {
			st = new StringTokenizer(br.readLine());
			
			int distance_x = Integer.parseInt(st.nextToken());
			int distance_y = Integer.parseInt(st.nextToken());
			
			for (int r = distance_x; r < distance_x + 10; r++) {
				for (int c = distance_y; c < distance_y + 10; c++) {
					map[r][c] = 1;
				}
			}
			
		}//색종이case
		
		int count = 0;
		
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if(map[r][c] == 1) count++;
			}
		}
		
		System.out.println(count);
		
	}
	
}
