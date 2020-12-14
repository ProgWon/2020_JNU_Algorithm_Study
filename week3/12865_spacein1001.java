package BojDP;

import java.util.*;
import java.io.*;

public class Knapsack_Algorithm_12865 { // �賶 ���� ��ġ �˰���, ���� '���� �˰���'
	static int N,K;
	static int[][] dp;
	static int[] w,v;
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ����
		K = Integer.parseInt(st.nextToken()); // �ִ���빫��
		
		dp = new int[N+1][K+1];
		w = new int[N+1];
		v = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken()); // ����  
			v[i] = Integer.parseInt(st.nextToken()); // ��ġ
		}
		
		Knapsack();
		
		bw.write(result+" ");
		bw.flush();
	}
	
	static void Knapsack() {
		// 
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				
				if(w[i]<=j) {
					dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i] , dp[i-1][j]); 
				}
				
				else { // w[i] > j
					dp[i][j] = dp[i-1][j];
				}
				
				result = Math.max(dp[i][j], result);
			}
		}
	}
	
}
