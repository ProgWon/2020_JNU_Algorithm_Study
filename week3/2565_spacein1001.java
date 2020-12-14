package BojDP;

import java.io.*;
import java.util.*;

public class DP_LIS_Wire_2565_Success { // LIS는 최장증가수열을 구하는것이라 같은길이를 구하는게아님
	static int N;
	static int[] arr = new int[501];
	static int[] dp = new int[501];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Arrays.fill(arr, 0); // 초기값
		Arrays.fill(dp, 0); 
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x] = y;
		}
		
		int cnt = 0;
		
		for(int i=1;i<501;i++) { // dp : 시간복잡도 N^2 , BinarySearch : 시간복잡도 N*logN 
			if(arr[i] > 0) { // 입력값이 있으면  or if(dp[i] == 0)해도 됨 
				dp[i] = 1; // '1' 이유 >> 자기자신부터 시작하고 포함하기때문에 최소 LIS길이는 1이다.
			} 
			
			for(int j=1;j<i;j++) { 
			// j<501 아니라 j<i 해도 같다(오히려 좋다) >> LIS 특성상 dp[i]값이 증가하면 그 후는 조건 만족 X ??
				if(arr[j] > 0 && arr[j] < arr[i] && dp[j] +1 > dp[i]) {
				//arr[j]>0 일때만 보기때문에 dp[i]==0으로 dp[i]=1이 되더라도 arr입력값이 없으면 if문 안걸림
				//dp[][] 이차원 배열로 두고 dp[x][y] < dp[x][y]+1와 같음
					dp[i] = dp[j] +1;
				}
			}
			
			cnt = Math.max(cnt, dp[i]); // 구한 LIS길이 
		}
		
		bw.write(N-cnt+" "); // 총 길이에서 LIS가 아닌부분을 뺌
		bw.flush();
	}
}
