package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S4_1158_요세푸스문제 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				// K-1개 뒤로 미루고
				q.add(q.poll());
			}
			// 1개 빼버리기
			list.add(q.poll());
		}

		sb.append("<");
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i)).append(", ");
		}
		sb.append(list.get(list.size() - 1)).append(">");

		System.out.println(sb);

	}

//	static String src = "7 3";

}
