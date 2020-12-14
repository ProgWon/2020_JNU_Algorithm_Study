package BojBruteForce;

import java.util.*;
import java.io.*;

public class BruteForce_CandyGame_3085 { // swap�� c/c++ó�� ��������� ���ư��� �ʴ´ٴ� ������
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
		
		// ���� 1.���� Ž���ؼ� ������ȯ �� ���� ��κ��� ���ϰ� ���� >> ���Ʈ���� , ���ζ� ���� ���� 
		// ���� 2.�ϳ��� swap�ؼ�  ���Ʈ ������ ������ �� ���� dp�� ����
		
		char tmp = ' ';
		
		for(int i=0;i<N;i++) { // ����        
			for(int j=0;j<N-1;j++) {
				if(j+1<N) { // �� �κ��� map[i][j] != map[i][j+1] �� �ϸ� ���� ������춧 0����
							// �������� ���� �ٸ� ������ ��ĭ�� �����ϴ� �Է¸� �־����ٰ� ��
					
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
		
		for(int i=0;i<N;i++) { // ����
			for(int j=0;j<N-1;j++) {
				if(i+1<N) {
/*					swap(map[j][i],map[j+1][i]); // �ٲ�
					BruteForce();
					swap(map[j][i],map[j+1][i]); // ���ڸ��� ����	    */
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
	}*/                  //  >> �۵� X
	
	static void BruteForce() { // ���� ���� ����

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
								// ���� ���� ����
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
