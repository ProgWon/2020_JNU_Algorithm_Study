package BojGraph_DFS_BFS_etc;

import java.util.*;
import java.io.*;

public class AlgorithmStudy2644 {
	static int N,X,Y;
	static int[][] map;
	static int[] cost;
	static boolean[] visit;
	static int cnt = 0;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		cost = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		BFS(X);
		
		if(cost[Y] == 0) {
			bw.write(-1 + " ");
		}
		else {
			bw.write(cost[Y]+" ");
		}
		
		bw.flush();
	}
	
	public static void BFS(int X) {
		Queue <Integer> q = new LinkedList<>();
		q.add(X);
		visit[X] = true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			for(int i=1;i<map.length;i++) {
				if(visit[i] == false && map[p][i] == 1){
					q.add(i);
					visit[i] = true;
					cost[i] = cost[p]+1;
				}
			}
		}
		
	}
	
}
