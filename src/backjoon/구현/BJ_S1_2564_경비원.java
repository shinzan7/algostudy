package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int X,Y,N;
	static Point security, stores[];
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken()); //가로
		Y = Integer.parseInt(st.nextToken()); //세로
		
		N = Integer.parseInt(br.readLine());
		stores = new Point[N];
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int leng = Integer.parseInt(st.nextToken());
			stores[i] = new Point(dir, leng);
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int leng = Integer.parseInt(st.nextToken());
		security = new Point(dir, leng);
		br.close(); //입력완료
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += Math.min(howFar(security, stores[i]), howFar(stores[i], security));
		}

		System.out.println(ans);
		
	}
	
	static int howFar(Point guard, Point store) {
		int distance = 0;
		
		//같은 방향
		if(guard.dir == store.dir) {
			distance = Math.abs(guard.length - store.length);
		}
		//건너편 방향 1234
		else if(guard.dir == 1 && store.dir == 2) {
			distance += X - guard.length;
			distance += Y;
			distance += X - store.length;
		}
		else if(guard.dir == 2 && store.dir == 1) {
			distance += guard.length;
			distance += Y;
			distance += store.length;
		}
		else if(guard.dir == 3 && store.dir == 4) {
			distance += guard.length;
			distance += X;
			distance += Y - store.length;
		}
		else if(guard.dir == 4 && store.dir == 3) {
			distance += Y - guard.length;
			distance += X;
			distance += Y - store.length;
		}
		
		//인접한 방향
		else {
			int x_g, y_g, x_s, y_s;
			if(guard.dir == 1 || guard.dir == 2) {
				x_g = guard.length;
				if(guard.dir == 1) y_g = Y;
				else y_g = 0;
			}else {
				y_g = Y - guard.length;
				if(guard.dir == 3) x_g = 0;
				else x_g = X;
			}
			
			if(store.dir == 1 || store.dir == 2) {
				x_s = store.length;
				if(store.dir == 1) y_s = Y;
				else y_s = 0;
			}else {
				y_s = Y - store.length;
				if(store.dir == 3) x_s = 0;
				else x_s = X;
			}
			//맨하탄거리
			distance = Math.abs(x_g - x_s) + Math.abs(y_g - y_s);	
		}
		
		
		return distance;
	}
	
	static class Point{
		int dir, length;

		public Point(int direction, int distance) {
			super();
			this.length = distance;
			this.dir = direction;
		}

		@Override
		public String toString() {
			return "[dir=" + dir + ", length=" + length + "]";
		}
		
	}
	
	static String src = "10 5\r\n" + 
			"3\r\n" + 
			"1 4\r\n" + 
			"3 2\r\n" + 
			"2 8\r\n" + 
			"2 3";
	
}
