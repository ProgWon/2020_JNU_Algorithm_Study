package week1;

import java.io.*;
import java.util.*;

public class Q17298 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		
		int[] arr = new int[n];
		int[] ans = new int[n]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			arr[i] = (Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < n; i++) {
			if(i+1 == n) {
				ans[i] = -1;
				continue;
			}
			
			while(!s.isEmpty() && arr[s.peek()] < arr[i+1]) {
				int x = s.pop();
				//System.out.print("x :" + x);
				ans[x] = arr[i+1];
				//System.out.println(" i :" + i);
			}
			
			if(arr[i] < arr[i+1]) {
				ans[i] = arr[i+1];
			}
			else s.add(i);
			
		}
		
		while(!s.isEmpty()) {
			ans[s.pop()] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			bw.append(ans[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
