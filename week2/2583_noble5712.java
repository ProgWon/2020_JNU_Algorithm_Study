package week2;

import java.io.*;
import java.util.*;

public class Q2583 {

	static int[][] arr;
	static int m,n,cnt;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(s.nextToken());
		n = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		
		arr = new int[m][n];
		check = new boolean[m][n];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			s = new StringTokenizer(br.readLine());
			Input(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()), 
					Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!check[i][j] && arr[i][j] == 0) {
					cnt = 0;
					list.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.println(list.size());
		System.out.println(sb);
	}
	
	public static void Input(int x1, int y1, int x2, int y2) {
		
		for(int i = y1; i < y2; i++) {
			for(int j = x1; j < x2; j++) {
				arr[m-i-1][j] += 1;
			}
		}
	}
	
	public static int bfs(int i, int j) {
		check[i][j] = true;
		
		Queue<spot4> q = new LinkedList<>();
		
		q.add(new spot4(i,j));
		
		while(!q.isEmpty()) {
			
			cnt++;
			spot4 temp = q.poll();
			
			for(int x = 0; x < 4; x++) {
				int nextX = temp.x + dx[x];
				int nextY = temp.y + dy[x];
				
				if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;
				if(check[nextX][nextY] || arr[nextX][nextY] != 0) continue;
				
				check[nextX][nextY] = true;
				q.add(new spot4(nextX,nextY));
			}
		}
		return cnt;
	}
}

class spot4{
	int x;
	int y;
	
	public spot4(int x, int y){
		this.x = x;
		this.y = y;
	}
}
