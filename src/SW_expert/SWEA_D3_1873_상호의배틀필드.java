package SW_expert;

import java.util.Scanner;

public class SWEA_D3_1873_상호의배틀필드 {
	
	static int T,H,W,N;
	static int sr, sc;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		
		for(int t=0; t<T; t++) {
			H = scan.nextInt();
			W = scan.nextInt();
			map = new char[H][W];
			
			for(int h=0; h<H; h++) {
				String temp = scan.next();
				for(int w=0; w<W; w++) {
					map[h][w] = temp.charAt(w);
					if(map[h][w]=='<' || map[h][w]=='>' || map[h][w]=='^' || map[h][w]=='v') {
						sr = h;
						sc = w; //전차의 현재위치 column
					}
				}
			}
			N = scan.nextInt();
			
			String moveStr = scan.next();
			char[] moveChar = moveStr.toCharArray();
			
			for (char c : moveChar) {
				if(c == 'S') {
					shoot(map[sr][sc]);
				}else {
					move(c);
				}
			}
			
			System.out.print("#"+(t+1)+" ");
			for (char[] m : map) {
				for (char c : m) {
					System.out.print(c);
				}
				System.out.println();
			}
			
		}//T.C
		
		
		
	}//main
	
	public static void shoot(char dir) { //포탄 발사
		if(dir == '<') {
			for(int c=sc; c>=0; c--) {
				if(map[sr][c] == '*') {
					map[sr][c] = '.';
					return;
				}else if(map[sr][c] == '#') {
					return;
				}
			}
		}else if(dir == '>') {
			for(int c=sc; c<W; c++) {
				if(map[sr][c] == '*') {
					map[sr][c] = '.';
					return;
				}else if(map[sr][c] == '#') {
					return;
				}
			}
		}else if(dir == '^') {
			for(int r=sr; r>=0; r--) {
				if(map[r][sc] == '*') {
					map[r][sc] = '.';
					return;
				}else if(map[r][sc] == '#') {
					return;
				}
			}
		}else if(dir == 'v') {
			for(int r=sr; r<H; r++) {
				if(map[r][sc] == '*') {
					map[r][sc] = '.';
					return;
				}else if(map[r][sc] == '#') {
					return;
				}
			}
		}
			
	}// 포탄 발사
	
	public static void move(char arrow) {
		if(arrow == 'L') {
			if(sc>0 && map[sr][sc-1]=='.') { //평지로 이동
				map[sr][sc] = '.';
				map[sr][--sc] = '<';
			}else {
				map[sr][sc] = '<';
			}
		}else if(arrow == 'R') {
			if(sc<W-1 && map[sr][sc+1]=='.') { //평지로 이동
				map[sr][sc] = '.';
				map[sr][++sc] = '>';
			}else {
				map[sr][sc] = '>';
			}
		}else if(arrow == 'U') {
			if(sr>0 && map[sr-1][sc]=='.') {
				map[sr][sc] = '.';
				map[--sr][sc] = '^';
			}else {
				map[sr][sc] = '^';
			}
		}else if(arrow == 'D') {
			if(sr<H-1 && map[sr+1][sc]=='.') {
				map[sr][sc] = '.';
				map[++sr][sc] = 'v';
			}else {
				map[sr][sc] = 'v';
			}
		}
	}
	
}