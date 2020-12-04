package week2;

import java.io.*;
import java.util.*;

public class Q2644 {

	static ArrayList<Integer>[] a;
	static int[] check;
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		int target1 = Integer.parseInt(s.nextToken()), target2 = Integer.parseInt(s.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		a = new ArrayList[n+1];
		check = new int[n+1];
		
		for(int i = 1; i < n+1; i++) {
			a[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			s = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(s.nextToken());
			int child = Integer.parseInt(s.nextToken());
			a[child].add(parent);
			a[parent].add(child);
		}
		
		int cnt = 0;
		
		System.out.println(bfs(target1, target2,cnt));
		
		Arrays.fill(check,0);
		
		dfsrec(target1, target2, cnt);
		
		if(check[target2] == 0) {
			System.out.println(-1);
		}
		else System.out.println(check[target2]);
		
		Arrays.fill(check,0);
		
		dfsstack(target1,target2,0);
		
		if(check[target2] == 0) {
			System.out.println(-1);
		}
		else System.out.println(check[target2]);
		
	}
	
	public static int bfs(int t1, int t2,int cnt) {
		check[t1] = cnt;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(t1);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i : a[temp]) {
				if(check[i] == 0) {
					q.add(i);
					check[i] = check[temp] + 1;
					if(i == t2) return check[i];
				}
			}
		}
		return -1;
	}
	
	public static void dfsrec(int t1, int t2, int cnt) {
		check[t1] = cnt;
		
		for(int i : a[t1]) {
			if(check[i] == 0) {
				check[i] = check[t1]+1;
				dfsrec(i,t2,check[t1]+1);
			}
		}
	}
	
	public static void dfsstack(int t1, int t2, int cnt) {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(t1);
		check[t1] = cnt;
		
		while(!stack.isEmpty()) {
			int temp = stack.peek();
			boolean flag = false;
			
			for(int i : a[temp]) {
				if(check[i] == 0) {
					stack.add(i);
					check[i] = ++cnt;
					flag = true;
					
					break;
				}
			}
			
			if(!flag) {
				stack.pop();
				cnt--;
			}
			
		}
	}
}
