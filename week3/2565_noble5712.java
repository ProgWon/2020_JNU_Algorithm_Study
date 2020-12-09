package week3;

import java.io.*;
import java.util.*;

public class Q2565 {
	
	static int[][] wire;
	static Integer[] dp;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		wire = new int[N][2];
		dp = new Integer[N];
		
		StringTokenizer s;
		for(int i = 0; i < N; i++) {
			s = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(s.nextToken());
			wire[i][1] = Integer.parseInt(s.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int []>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(LIS(i), max);
		}
		
		System.out.println(N-max);
		
		
		max = 0;
		
		Arrays.fill(dp, null);
		
		for(int i = 0; i < N; i++) { // Bottom - up
			
			if(dp[i] == null) {
				dp[i] = 1;
				
				for(int j = 0; j < i; j++) {
					if(wire[i][1] > wire[j][1]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
			}	
		}
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	static int LIS(int n) {
		
		if(dp[n] == null) {
			dp[n] = 1;
			for(int i = n+1 ; i < dp.length; i++) {
				if(wire[i][1] > wire[n][1]) {
					dp[n] = Math.max(dp[n], LIS(i) +1);
				}
			}
		}
		return dp[n];
	}
}