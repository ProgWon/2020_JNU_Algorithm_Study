package week1;

import java.io.*;
import java.util.*;

public class Q17299 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[1000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		int[] ans = new int[n];
		
		pair[] arr2 = new pair[n];
		
		for(int i = 0; i < n; i++) {
			int token = Integer.parseInt(st.nextToken());
			cnt[token]++;
			arr[i] = token;
		}
		
		for(int i = 0; i < n; i++) {
			arr2[i] = new pair(cnt[arr[i]], arr[i]);
		}
		
		Stack<Integer> s = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			
			if(i+1 == n) {
				ans[i] = -1;
				continue;
			}
			
			while(!s.isEmpty() && arr2[s.peek()].count < arr2[i+1].count) {
				int x = s.pop();
				ans[x] = arr2[i+1].value;
			}
			
			if(arr2[i].count < arr2[i+1].count) {
				ans[i] = arr2[i+1].value;
			}
			else s.add(i);
		}
		
		while(!s.isEmpty()) {
			int x = s.pop();
			ans[x] = -1;
			//System.out.println("남아있는 i : " + x);
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.println(sb);
	}
}

class pair{
	int count;
	int value;
	
	public pair(int count, int value) {
		this.count = count;
		this.value = value;
	}
}
