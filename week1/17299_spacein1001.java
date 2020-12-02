package BojStackQueueDeque;

import java.util.*;
import java.io.*;

public class BigSameNumberOnTheRight17299bf {
	static int[] arr;
	static int[] cnt;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		cnt = new int[1000000+1];
		result = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// StringTokenizer�� split�� �ٸ��� util �޼ҵ�ȿ� ������ �ܼ��� ������ ���ܿ´�.
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // �ڿ������Է�
			cnt[arr[i]] += 1;
		}
		
		Stack <Integer> s = new Stack<>();
		
		for(int i=1;i<=N;i++) {
			while(!s.isEmpty() && cnt[arr[s.peek()]] < cnt[arr[i]]) {
				result[s.pop()] = arr[i];
			} 
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			result[s.pop()] = -1;
		}
		
		for(int i=1;i<result.length;i++) {
			bw.write(result[i]+ " ");
		}
		
		bw.flush();
	}
}
