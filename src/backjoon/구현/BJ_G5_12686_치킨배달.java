package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_12686_치킨배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M, cityChickenDistance;
	static List<Point> stores = new ArrayList<Point>();
	static List<Point> homes = new ArrayList<Point>();
	
	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) homes.add(new Point(r, c));
				else if(a==2) stores.add(new Point(r, c));
			}
		}
		cityChickenDistance = Integer.MAX_VALUE;
		comb(0, 0, new Point[M]);
		System.out.println(cityChickenDistance);
	}
	
	public static void comb(int cnt, int start, Point[] choosed) {
		if(cnt==M) {
			int sum = 0;
			for (Point home : homes) {
				int chickenDistance = Integer.MAX_VALUE;
				for (Point store : choosed) {
					chickenDistance = Math.min(chickenDistance, home.getDistance(store));
				}
				//최소치킨거리 더하기
				sum += chickenDistance;
			}
			cityChickenDistance = Math.min(sum, cityChickenDistance);
			return;
		}
		
		for (int i = start; i < stores.size(); i++) {
			choosed[cnt] = stores.get(i);
			comb(cnt+1, i+1, choosed);
		}
		
		
	}
	
	public static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public int getDistance(Point p) {
			return Math.abs(this.r - p.r) + Math.abs(this.c - p.c);
		}
		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}
		
	}
	

	
}
