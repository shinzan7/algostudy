package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의역량테스트2382_미생물격리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K, result;
	static PriorityQueue<mic> pq;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //셀 길이
			M = Integer.parseInt(st.nextToken()); //경과시간
			K = Integer.parseInt(st.nextToken()); //미생물 수
			result = 0;
			pq = new PriorityQueue<>();
			for (int i = 0; i < K; i++) {
				// 미생물 정보
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				pq.offer(new mic(r, c, num, dir));
			}
			
			for (int m = 1; m <= M; m++) {
				PriorityQueue<mic> resultQ = new PriorityQueue<>();
				PriorityQueue<mic> startQ = new PriorityQueue<>();
				
				while(!pq.isEmpty()) {
					mic now = pq.poll();
					now.move();
					startQ.offer(now);
				}
				
				while(!startQ.isEmpty()) {
					mic cur = startQ.poll();
					if(!startQ.isEmpty() && cur.r == startQ.peek().r && cur.c == startQ.peek().c) { //합칠 미생물이 있다면
						List<mic> fusionList = new LinkedList<>();
						fusionList.add(cur);
						while(!startQ.isEmpty() && cur.r == startQ.peek().r && cur.c == startQ.peek().c) {
							fusionList.add(startQ.poll()); //다른 위치가 나올때까지 뽑아서 추가
						}
						cur = fusion(fusionList);
					}//합체완료
					resultQ.offer(cur); //결과물 저장		
				}
				while(!resultQ.isEmpty()) {
					pq.offer(resultQ.poll());
				}
				
			}
			//시간 모두 경과
			while(!pq.isEmpty()) {
				result += pq.poll().num;
			}

			sb.append("#").append(t).append(" ");
			sb.append(result).append("\n");
		} // T.C
		
		System.out.println(sb);

		
		
		
	}// main
	
	static mic fusion(List<mic> mics) {
		int sum = 0;
		int maxN = 0;
		int dir = -1;
		int r = mics.get(0).r;
		int c = mics.get(0).c;
		
		for (mic mic : mics) {
			sum += mic.num;
			if(maxN < mic.num) {
				dir = mic.dir;
				maxN = mic.num;
			}
		}
		return new mic(r, c, sum, dir);
		
	}
	
	
	static class mic implements Comparable<mic>{
		int r, c, num, dir;

		public mic(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir; // 1234 상하좌우
		}
		
		public void move() {
			if(this.dir == 1) this.r -= 1;
			else if(this.dir == 2) this.r += 1;
			else if(this.dir == 3) this.c -= 1;
			else this.c += 1;
			if(this.r == 0 || this.c == 0 || this.r == N-1 || this.c == N-1) redCell();
		}

		public void redCell() { //빨간약품에 도착
			this.num /= 2;
			if(this.dir == 1) this.dir = 2;
			else if(this.dir == 2) this.dir = 1;
			else if(this.dir == 3) this.dir = 4;
			else this.dir = 3;
		}

		@Override
		public int compareTo(mic o) {
			if(this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}

		@Override
		public String toString() {
			return "mic [r=" + r + ", c=" + c + ", num=" + num + ", dir=" + dir + "]";
		}
		
		
	}

	static String src = "10\r\n" + "7 2 9\r\n" + "1 1 7 1\r\n" + "2 1 7 1\r\n" + "5 1 5 4\r\n" + "3 2 8 4\r\n"
			+ "4 3 14 1\r\n" + "3 4 3 3\r\n" + "1 5 8 2\r\n" + "3 5 100 1\r\n" + "5 5 1 1\r\n" + "10 17 46\r\n"
			+ "7 5 724 2\r\n" + "7 7 464 3\r\n" + "2 2 827 2\r\n" + "2 4 942 4\r\n" + "4 5 604 4\r\n" + "7 2 382 1\r\n"
			+ "6 5 895 3\r\n" + "8 7 538 4\r\n" + "6 1 299 4\r\n" + "4 7 811 4\r\n" + "3 6 664 2\r\n" + "6 8 868 2\r\n"
			+ "7 6 859 2\r\n" + "4 6 778 2\r\n" + "5 4 842 3\r\n" + "1 3 942 1\r\n" + "1 1 805 3\r\n" + "3 2 350 3\r\n"
			+ "2 5 623 2\r\n" + "5 3 840 1\r\n" + "7 1 308 4\r\n" + "1 8 323 3\r\n" + "2 3 82 3\r\n" + "2 6 115 2\r\n"
			+ "8 3 930 1\r\n" + "6 2 72 1\r\n" + "2 1 290 3\r\n" + "4 8 574 4\r\n" + "8 5 150 3\r\n" + "8 2 287 2\r\n"
			+ "2 8 909 2\r\n" + "2 7 588 2\r\n" + "7 3 30 3\r\n" + "5 8 655 3\r\n" + "3 8 537 1\r\n" + "4 2 350 3\r\n"
			+ "5 6 199 1\r\n" + "5 5 734 2\r\n" + "3 3 788 1\r\n" + "8 4 893 1\r\n" + "1 4 421 4\r\n" + "6 3 616 2\r\n"
			+ "1 2 556 4\r\n" + "7 8 8 1\r\n" + "5 2 702 2\r\n" + "4 4 503 3\r\n" + "10 5 28\r\n" + "3 3 796 1\r\n"
			+ "7 2 798 2\r\n" + "2 6 622 1\r\n" + "3 5 179 3\r\n" + "7 8 888 4\r\n" + "5 8 634 3\r\n" + "1 8 646 1\r\n"
			+ "3 7 433 4\r\n" + "6 7 416 1\r\n" + "2 7 651 3\r\n" + "6 4 476 2\r\n" + "5 6 712 4\r\n" + "1 7 869 4\r\n"
			+ "6 1 789 2\r\n" + "8 8 585 3\r\n" + "7 6 426 1\r\n" + "1 5 154 2\r\n" + "1 2 692 1\r\n" + "2 4 549 3\r\n"
			+ "2 1 60 2\r\n" + "4 8 996 4\r\n" + "8 2 437 2\r\n" + "3 6 195 2\r\n" + "1 3 734 4\r\n" + "3 8 355 2\r\n"
			+ "1 1 945 1\r\n" + "2 5 558 2\r\n" + "7 7 144 2\r\n" + "10 22 26\r\n" + "2 2 450 4\r\n" + "6 3 659 1\r\n"
			+ "5 8 24 2\r\n" + "3 7 649 2\r\n" + "3 2 22 3\r\n" + "1 3 905 4\r\n" + "7 8 625 3\r\n" + "6 7 824 3\r\n"
			+ "7 3 159 1\r\n" + "2 7 297 4\r\n" + "7 2 270 2\r\n" + "4 5 985 1\r\n" + "7 1 627 2\r\n" + "3 4 625 4\r\n"
			+ "8 5 972 4\r\n" + "6 6 432 4\r\n" + "6 8 142 1\r\n" + "7 7 900 1\r\n" + "4 1 974 2\r\n" + "4 2 760 4\r\n"
			+ "1 4 550 2\r\n" + "5 7 624 4\r\n" + "4 6 694 1\r\n" + "4 3 593 3\r\n" + "3 1 152 4\r\n" + "1 8 926 1\r\n"
			+ "10 7 15\r\n" + "3 4 227 1\r\n" + "4 7 109 1\r\n" + "3 7 487 2\r\n" + "2 3 627 2\r\n" + "6 1 520 4\r\n"
			+ "7 3 596 4\r\n" + "2 6 525 4\r\n" + "1 5 116 3\r\n" + "7 7 771 4\r\n" + "4 4 520 2\r\n" + "7 5 763 1\r\n"
			+ "5 4 829 3\r\n" + "5 2 578 3\r\n" + "6 8 200 2\r\n" + "3 8 760 4\r\n" + "10 24 12\r\n" + "6 5 887 2\r\n"
			+ "2 3 428 1\r\n" + "2 1 540 2\r\n" + "8 1 356 4\r\n" + "1 7 485 4\r\n" + "5 1 357 3\r\n" + "7 6 271 2\r\n"
			+ "6 2 22 1\r\n" + "6 1 41 2\r\n" + "8 2 565 2\r\n" + "8 5 855 1\r\n" + "6 3 734 1\r\n" + "10 22 44\r\n"
			+ "2 2 963 1\r\n" + "8 4 635 4\r\n" + "4 1 938 4\r\n" + "8 7 511 3\r\n" + "6 8 825 4\r\n" + "6 7 934 3\r\n"
			+ "3 7 701 4\r\n" + "2 7 534 2\r\n" + "5 2 705 1\r\n" + "3 5 300 2\r\n" + "6 2 855 4\r\n" + "7 7 877 4\r\n"
			+ "1 7 443 1\r\n" + "1 2 313 1\r\n" + "3 3 932 2\r\n" + "1 8 831 2\r\n" + "1 1 90 2\r\n" + "2 6 145 3\r\n"
			+ "2 3 740 4\r\n" + "5 3 759 4\r\n" + "1 6 181 1\r\n" + "8 6 608 4\r\n" + "5 6 556 2\r\n" + "2 4 541 4\r\n"
			+ "2 1 174 2\r\n" + "6 1 601 1\r\n" + "7 5 84 4\r\n" + "4 3 970 3\r\n" + "8 8 503 1\r\n" + "3 4 171 3\r\n"
			+ "5 7 913 4\r\n" + "8 1 232 3\r\n" + "7 6 539 4\r\n" + "3 8 648 1\r\n" + "8 2 944 2\r\n" + "2 5 508 2\r\n"
			+ "5 1 87 1\r\n" + "5 8 88 4\r\n" + "2 8 681 2\r\n" + "1 5 758 2\r\n" + "3 1 690 3\r\n" + "6 4 620 3\r\n"
			+ "5 4 783 1\r\n" + "6 6 748 1\r\n" + "10 9 38\r\n" + "2 7 955 1\r\n" + "7 7 25 4\r\n" + "4 2 496 2\r\n"
			+ "1 4 342 1\r\n" + "7 5 72 1\r\n" + "3 7 429 2\r\n" + "5 2 812 3\r\n" + "8 6 36 2\r\n" + "1 6 994 3\r\n"
			+ "1 5 838 1\r\n" + "3 4 131 4\r\n" + "7 2 11 2\r\n" + "6 3 650 3\r\n" + "7 3 353 2\r\n" + "1 7 454 2\r\n"
			+ "8 3 256 4\r\n" + "5 5 213 2\r\n" + "6 5 80 1\r\n" + "2 1 676 4\r\n" + "4 6 561 3\r\n" + "2 5 653 3\r\n"
			+ "3 5 923 3\r\n" + "8 2 259 3\r\n" + "4 4 781 2\r\n" + "1 1 313 2\r\n" + "3 6 938 3\r\n" + "2 6 700 3\r\n"
			+ "4 1 215 2\r\n" + "4 8 39 3\r\n" + "5 1 954 3\r\n" + "6 7 774 1\r\n" + "5 8 541 4\r\n" + "3 1 885 4\r\n"
			+ "7 8 867 2\r\n" + "2 8 825 1\r\n" + "5 6 598 3\r\n" + "6 6 80 3\r\n" + "8 1 405 2\r\n" + "10 16 11\r\n"
			+ "5 7 87 3\r\n" + "2 5 686 1\r\n" + "6 7 64 2\r\n" + "6 8 873 3\r\n" + "5 6 762 2\r\n" + "8 4 268 3\r\n"
			+ "7 3 307 4\r\n" + "1 7 809 3\r\n" + "5 5 293 3\r\n" + "5 1 345 3\r\n" + "4 1 114 4\r\n" + "10 8 19\r\n"
			+ "3 1 52 4\r\n" + "6 8 423 3\r\n" + "7 3 498 4\r\n" + "7 5 633 3\r\n" + "7 7 392 3\r\n" + "6 6 458 4\r\n"
			+ "3 8 830 3\r\n" + "5 1 799 3\r\n" + "1 1 540 3\r\n" + "4 8 567 3\r\n" + "1 6 897 3\r\n" + "5 4 230 1\r\n"
			+ "2 6 229 3\r\n" + "1 5 147 1\r\n" + "4 1 754 2\r\n" + "3 3 569 1\r\n" + "7 8 515 4\r\n" + "2 4 528 4\r\n"
			+ "2 1 962 2\r\n" + "";

}
