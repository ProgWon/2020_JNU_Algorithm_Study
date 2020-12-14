package BojDP;

import java.io.*;
import java.util.*;

public class DP_LIS_Wire_2565_Success { // LIS�� �������������� ���ϴ°��̶� �������̸� ���ϴ°Ծƴ�
	static int N;
	static int[] arr = new int[501];
	static int[] dp = new int[501];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Arrays.fill(arr, 0); // �ʱⰪ
		Arrays.fill(dp, 0); 
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x] = y;
		}
		
		int cnt = 0;
		
		for(int i=1;i<501;i++) { // dp : �ð����⵵ N^2 , BinarySearch : �ð����⵵ N*logN 
			if(arr[i] > 0) { // �Է°��� ������  or if(dp[i] == 0)�ص� �� 
				dp[i] = 1; // '1' ���� >> �ڱ��ڽź��� �����ϰ� �����ϱ⶧���� �ּ� LIS���̴� 1�̴�.
			} 
			
			for(int j=1;j<i;j++) { 
			// j<501 �ƴ϶� j<i �ص� ����(������ ����) >> LIS Ư���� dp[i]���� �����ϸ� �� �Ĵ� ���� ���� X ??
				if(arr[j] > 0 && arr[j] < arr[i] && dp[j] +1 > dp[i]) {
				//arr[j]>0 �϶��� ���⶧���� dp[i]==0���� dp[i]=1�� �Ǵ��� arr�Է°��� ������ if�� �Ȱɸ�
				//dp[][] ������ �迭�� �ΰ� dp[x][y] < dp[x][y]+1�� ����
					dp[i] = dp[j] +1;
				}
			}
			
			cnt = Math.max(cnt, dp[i]); // ���� LIS���� 
		}
		
		bw.write(N-cnt+" "); // �� ���̿��� LIS�� �ƴѺκ��� ��
		bw.flush();
	}
}
