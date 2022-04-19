package SW_expert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_모의역량test_특이한자석 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int K, result;
	static List<Magnet> magnets;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new FileReader("input.txt"));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0;
			K = Integer.parseInt(br.readLine());
			magnets = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				magnets.add(new Magnet(new LinkedList<>()));
				while(st.hasMoreTokens()) {
					magnets.get(i).list.add(Integer.parseInt(st.nextToken()));
				}
				
			}
			for (int i = 0; i < K; i++) { //k번 명령처리
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				rotate(idx, dir);
			}
			//점수 합계
			for (int i = 0, n = 1; i < 4; i++) {
				if(magnets.get(i).list.get(0) == 1) {
					result += n;
				}
				n *= 2;
			}
			
			sb.append(String.format("#%d %d\n" , t, result));
		}//TC
		System.out.println(sb);
	}//main
	
	private static void rotate(int idx, int dir) {
		idx--; //list 인덱스 맞추기
		
		//회전할때 영향받는지 확인
		boolean[] isRotate = new boolean[4];
		isRotate[idx] = true;
		int d = 0;
		while(idx + d<3 || idx-d >0) {
			if(idx + d <3 && isRotate[idx+d] && checkRight(idx+d)) {
				isRotate[idx+d+1] = true;
			}
			if(idx - d >0 && isRotate[idx-d] && checkLeft(idx-d)) {
				isRotate[idx-d-1] = true;
			}
		}
		
		//회전
		magnets.get(idx).cw(dir);
		int copy = dir;
		for (int i = 1; i < 4; i++) {
			copy *= -1;
			if(idx + i < 4 && isRotate[idx + i]) {
				magnets.get(idx+i).cw(copy);
			}
		}
		copy = dir;
		for (int i = 1; i < 4; i++) {
			copy *= -1;
			if(idx - i >=0 && isRotate[idx - i]) {
				magnets.get(idx-i).cw(copy);
			}
		}
		
	}
	private static boolean checkRight(int idx) {
		return magnets.get(idx).list.get(2) != magnets.get(idx+1).list.get(6);
	}
	private static boolean checkLeft(int idx) {
		return magnets.get(idx).list.get(6) != magnets.get(idx-1).list.get(2);
	}
	
	private static class Magnet{
		List<Integer> list;

		public Magnet(List<Integer> list) {
			super();
			this.list = list;
		}
		
		public void cw(int dir) {
			if(dir == 1) {
				int size = this.list.size() - 1;
				int temp = this.list.get(size);
				this.list.remove(size);
				this.list.add(0, temp);				
			}else {
				int temp = this.list.get(0);
				this.list.remove(0);
				this.list.add(temp);
			}
		}

		@Override
		public String toString() {
			return list.toString();
		}
		
		
	}
	
}
