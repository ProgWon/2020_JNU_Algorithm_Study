package BojGraph_DFS_BFS_etc;

import java.util.*;
import java.io.*;

class Point{
	int x,y,cnt;
	public Point(int x,int y,int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class AlgorithmStudy2234_GiveUp {
	static int N,M;
	static boolean[][] visit;
	static int[][] num;
	static String[][] map;
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static Queue<Point> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int max = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[M][N];
		visit = new boolean[M][N];
		num = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				String str = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
				if(str.length()<4) { // 길이가 1 2 3 인 경우 >> 0인경우는 없음, 1~15니까
					while(str.length()<4) {
						str = "0" + str;
					}
					map[i][j] = str;
				}
				else {
					map[i][j] = str;
				}
			}
		}
		
		int Rc = 0; // room count
		int Rs = 1; // room size
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j] == false) {
					visit[i][j] = true;
					max = 0;
					q.add(new Point(i,j,1));
					num[i][j] = Rs;
					BFS(Rs);
					list.add(max+1);
					Rs++;
					Rc++;
				}
			}
		}
		
		int sum = 0;
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<4;k++){
					int x3 = i + dx[k];
					int y3 = j + dy[k];
					
					if(x3 >= 0 && y3 >= 0 && x3 < M && y3 < N){
						if(num[i][j] != num[x3][y3]){
							int tmpS=list.get(num[i][j]-1) + list.get(num[x3][y3]-1);
							
							if(tmpS>sum) sum=tmpS;
						}
					}
				}
			}
		}
		
		Collections.sort(list);
		
		bw.write(Rc+"\n");
		bw.write(list.get(list.size()-1)+"\n");
		bw.write(sum+"\n");
		bw.flush();
	}
	
	public static void BFS(int Rs) {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x2 = 0;
			int y2 = 0;
			
			if(map[p.x][p.y].substring(3, 4).equals("0")){ // 서
				x2=p.x+0;
				y2=p.y-1;

				if(x2 >= 0 && y2 >= 0 && x2 < M && y2 < N){
					if(visit[x2][y2]==false){
						visit[x2][y2]=true; 
						num[x2][y2] = Rs;
						q.add(new Point(x2,y2,p.cnt+1));
						max++;
					}
				}
			}
			
			if( map[p.x][p.y].substring(2, 3).equals("0")){ // 북
				x2=p.x-1;
				y2=p.y+0;
				
				if(x2 >= 0 && y2 >= 0 && x2 < M && y2 < N){
					if(visit[x2][y2]==false){
						visit[x2][y2]=true; 
						num[x2][y2] = Rs;
						q.add(new Point(x2,y2,p.cnt+1));
						max++;
					}
				}
			}
			
			if( map[p.x][p.y].substring(1, 2).equals("0")){ // 동
				x2=p.x+0;
				y2=p.y+1;
				
				if(x2 >= 0 && y2 >= 0 && x2 < M && y2 < N){
					if(visit[x2][y2]==false){
						visit[x2][y2]=true; 
						num[x2][y2] = Rs;
						q.add(new Point(x2,y2,p.cnt+1));
						max=max+1;
					}
				}
			}
			
			if(map[p.x][p.y].substring(0, 1).equals("0")){ // 남
				x2=p.x+1;
				y2=p.y+0;
				
				if(x2 >= 0 && y2 >= 0 && x2 < M && y2 < N){
					if(visit[x2][y2]==false){
						visit[x2][y2]=true; 
						num[x2][y2] = Rs;
						q.add(new Point(x2,y2,p.cnt+1));
						max=max+1;
					}
				}
			}
		}
		
	}
	
}
