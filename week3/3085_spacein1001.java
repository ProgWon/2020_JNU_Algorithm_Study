package BojBruteForce;

import java.util.*;
import java.io.*;

public class BruteForce_CandyGame_3085 { // swap을 c/c++처럼 만들었지만 돌아가지 않는다는 문제점
	static int N;
	static char[][] map;
	static int cnt = 0;
	static int result = 0;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 방향 1.전부 탐색해서 사탕교환 전 가장 긴부분을 구하게 만듬 >> 브루트포스 , 가로랑 세로 따로 
		// 방향 2.하나씩 swap해서  브루트 포스를 돌려봄 그 값을 dp에 저장
		
		char tmp = ' ';
		
		for(int i=0;i<N;i++) { // 가로        
			for(int j=0;j<N-1;j++) {
				if(j+1<N) { // 이 부분이 map[i][j] != map[i][j+1] 로 하면 모든게 같은경우때 0나옴
							// 문제에서 색이 다른 인접한 두칸이 존재하는 입력만 주어진다고 함
					
/*					swap(map[i][j],map[i][j+1]); // swap
					BruteForce();
					swap(map[i][j],map[i][j+1]); // return swap		*/
					tmp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = tmp;
					BruteForce();
					tmp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = tmp;
				} 
			}
		}
		
		for(int i=0;i<N;i++) { // 세로
			for(int j=0;j<N-1;j++) {
				if(i+1<N) {
/*					swap(map[j][i],map[j+1][i]); // 바꿈
					BruteForce();
					swap(map[j][i],map[j+1][i]); // 제자리로 돌림	    */
					tmp = map[j][i];
					map[j][i] = map[j+1][i];
					map[j+1][i] = tmp;
					BruteForce();
					tmp = map[j][i];
					map[j][i] = map[j+1][i];
					map[j+1][i] = tmp;
				}
			}
		}
		
		bw.write(result+" ");
		bw.flush();
	}
	
/*	static void swap(char a,char b) {
		char tmp;
		tmp = a;
		a = b;
		b = tmp;
	}*/                  //  >> 작동 X
	
	static void BruteForce() { // 세로 연속 개수

		for(int i=0;i<N;i++) {
			cnt = 1;
			for(int j=0;j<N-1;j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
					
					if(result < cnt) {
						result = cnt;
					}
				}
				else {
					cnt = 1;
				}
			}
			result = Math.max(cnt, result);
		}
								// 가로 연속 개수
		for(int i=0;i<N;i++) {
			cnt = 1;
			for(int j=0;j<N-1;j++) {
				if(map[i][j] == map[i][j+1]) {
					cnt++;
					
					if(result < cnt) {
						result = cnt;
					}
				}
				else {
					cnt = 1;
				}
			}
		}
		result = Math.max(cnt, result);
	}
	
}
