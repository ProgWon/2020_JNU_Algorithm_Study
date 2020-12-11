package BojGraph_DFS_BFS_etc;

import java.util.*;
import java.io.*;

public class AlgorithmStudy2583_Success {
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map;
	static boolean[][] visit;
	static int M,N,K;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visit = new boolean[M][N];
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=y1;i<y2;i++) {
				for(int j=x1;j<x2;j++) {
					map[i][j] = 9;
				}
			}
		}
		int land = 0;
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] != 9  && visit[i][j] == false) {
					BFS(i,j);
					land++;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(land);
		for(int num : list) {
			System.out.print(num + " ");
		}
		
/*		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}*/
	}
	
	public static void BFS(int x,int y) {
		Queue<Point> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new Point(x,y));

		int landCnt = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int x2 = p.x + dx[i];
				int y2 = p.y + dy[i];
				
				if(x2 >= 0 && y2 >= 0 && x2 < M && y2 < N) {
					if(map[x2][y2] != 9 && visit[x2][y2] == false) {
						visit[x2][y2] = true;
						landCnt++;
						q.add(new Point(x2,y2));
					}
				}
			}
		}
		list.add(landCnt);
	}
}
