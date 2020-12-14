package BojDP;

import java.util.*;
import java.io.*;

public class DP_LCS_2_9252 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String L1 = br.readLine(); // char는 -127~128 까지
		String L2 = br.readLine();
		
		char[] L1C = L1.toCharArray();
		char[] L2C = L2.toCharArray();
		
		int x = L1.length();
		int y = L2.length();
		
		int LCS_length[][] = new int[x+1][y+1];
		
		for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++) {
				
				if(L1C[i-1] == L2C[j-1]) {
					LCS_length[i][j] = LCS_length[i-1][j-1] +1;
				}
				
				else {
					LCS_length[i][j] = Math.max(LCS_length[i-1][j],LCS_length[i][j-1]);
				}
				
			}
		}
		
		if(LCS_length[x][y] > 0) {
			bw.write(LCS_length[x][y]+"\n");
		}
		else {
			bw.write("0\n");
		}
		
		Stack <Character> s = new Stack<>();
		
		while(x > 0 && y > 0) { // LCS개수 구하고 역추적 
			
			if(LCS_length[x][y] == LCS_length[x-1][y]) {
				x--;
			}
			
			else if(LCS_length[x][y] == LCS_length[x][y-1]) {
				y--;
			}
			
			else {
				s.push(L1C[x-1]);
				x--;
				y--;
			}
		}
		
		while(!s.isEmpty()) {
			bw.write(s.pop());
		}
		
//		bw.write(LCS_length[3][6]+" ");
		
		bw.flush();
	}
}
