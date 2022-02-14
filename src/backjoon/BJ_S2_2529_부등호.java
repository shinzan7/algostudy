package backjoon;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_S2_2529_부등호 {
	
	static Scanner scan = new Scanner(System.in);
	static String[] arr;
	static int K;
	static int[] nums = {0,1,2,3,4,5,6,7,8,9};
	static boolean[] visited = new boolean[10];
	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
//		scan = new Scanner(new StringReader(src));
		K = scan.nextInt();
		arr = new String[K]; //부등호 갯수
		
		for (int k = 0; k < K; k++) {
			arr[k] = scan.next();
		}
		
		for (int i = 0; i < nums.length; i++) {
			visited[i] = true;
			dfs(0, i, i + "");
		}
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	
	}//main
	
	public static void dfs(int cnt, int n, String s) { //n 현재 숫자
		
		if(cnt == K) {
			list.add(s);
		}
		else {
			for (int i = 0; i < nums.length; i++) {
				if(!visited[i]) {
					if(arr[cnt].equals("<")) {
						if(n >= i) continue;
					}else {
						if(n <= i) continue;
					}
					visited[i] = true;
					dfs(cnt+1, i, s + i);
				}
			}			
		}
		visited[n] = false;
		
	}
	
	
//	public static String src = "9\r\n" + 
//			"> < < < > > > < <";
	
}
