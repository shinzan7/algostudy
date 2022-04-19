package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B0_00_빈파일2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String[] arr = {"123", "563", "12345"};
		System.out.println(solution(arr));
	}

	public static boolean solution(String[] phoneBook) {
		Arrays.sort(phoneBook);
		for (int i = 0; i < phoneBook.length - 1; i++) {
			if (phoneBook[i + 1].startsWith(phoneBook[i]))
				return false;
		}

		return true;
	}
}
