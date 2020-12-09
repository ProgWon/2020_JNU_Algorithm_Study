package week3;

import java.io.*;

public class Q3085 {

	static char[][] arr;
	static Integer[][] candy;
	static int n;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		candy = new Integer[n][n];
		
		String s;
		
		for(int i = 0; i < n; i++) {
			s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				swap(i,j);
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(candy[i][j]);
//			}
//			System.out.println();
//		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result = Math.max(result, candy[i][j]);
			}
		}
		
		System.out.println(result);
	}
	
	static void swap(int x, int y) {
		char temp;
//		System.out.println("-------"+x + " " + y + "--------");
		
		
		int[] cost = new int[4];
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
			
			temp = arr[x][y];
			arr[x][y] = arr[nextX][nextY];
			arr[nextX][nextY] = temp;
			cost[i] = count(arr);
			
			temp = arr[x][y];
			arr[x][y] = arr[nextX][nextY];
			arr[nextX][nextY] = temp;
		}
		
		int max = 0;
		for(int j = 0; j < 4; j++) {
//			System.out.print(cost[j] +" ");
			max = Math.max(cost[j], max);
		}
//		System.out.println();
		candy[x][y] = max;
	}
	
	static int count(char[][] arr) {
		int row = 0, rowmax = 0;
		int col = 0, colmax = 0;
		char ch = arr[0][0];
		
		for(int i = 0; i < n; i++) {
			row = 0;
			for(int j = 0; j < n; j++) {
				if(ch == arr[i][j]) row ++;
				else {
					rowmax = Math.max(rowmax, row);
					ch = arr[i][j];
					row = 1;
				}
				rowmax = Math.max(rowmax,row);
			}
		}
		
		for(int i = 0; i < n; i++) {
			col = 0;
			for(int j = 0; j < n; j++) {
				if(ch == arr[j][i]) col ++;
				else {
					colmax = Math.max(colmax,col);
					ch = arr[j][i];
					col = 1;
				}
			}
			colmax = Math.max(colmax, col);
		}
		
		return Math.max(rowmax, colmax);
	}
}
