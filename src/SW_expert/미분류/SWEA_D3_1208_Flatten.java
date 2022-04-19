package SW_expert.미분류;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_D3_1208_Flatten {
	static int T = 10;
	static int dump;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int t=0; t<T; t++) {
			List<Integer> boxes = new ArrayList<Integer>();

			dump = scan.nextInt();
			
			for(int i=0; i<100; i++) {
				boxes.add(scan.nextInt());
			}
			//System.out.println(Collections.max(boxes));
			
			for(int n=1; n<=dump; n++) {
				if(Collections.max(boxes) > Collections.min(boxes)) {
					int maxIndex = boxes.indexOf(Collections.max(boxes));
					int minIndex = boxes.indexOf(Collections.min(boxes));
					
					boxes.set(maxIndex, boxes.get(maxIndex)-1);
					boxes.set(minIndex, boxes.get(minIndex)+1);
				}else {
					break;
				}
			}
			int diff = Collections.max(boxes) - Collections.min(boxes);
			System.out.println("#"+(t+1)+" "+ diff);
			
		}//T.C
		
	}//main
}