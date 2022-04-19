package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D3_1225_암호생성기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokens;
		Queue<Integer> code = new LinkedList<Integer>();
		
		while(true) {
			String T = input.readLine();
			if(T == null || T.equals("")) break;
			
			tokens = new StringTokenizer(input.readLine());
			while(tokens.hasMoreTokens()) {
				code.add(Integer.parseInt(tokens.nextToken()));
			}
			
			int c = 1;
			outer : while(true) {
				if(c == 6) c = 1;
				
				int temp = code.poll() - c++;
				
				if(temp > 0) {
					code.add(temp);
				}else {
					code.add(0);
					break outer;
				}
			}
			output.write("#"+ T + " ");
			for (Integer integer : code) {
				output.write(integer + " ");
			}
			output.newLine();
			code.clear();
		}
		
		input.close();
		output.close();
		
	}//main

	
}
