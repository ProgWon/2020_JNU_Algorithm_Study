package week2;

import java.io.*;
import java.util.*;

public class Q2234 {

	static int n,m,cnt;
	static wall[][] arr;
	static int check[][], next[][];
	static HashMap<pair,Integer> map;
	static ArrayList<Integer> al;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		
		arr = new wall[m][n];
		check = new int[m][n];
		map = new HashMap<>();
		al = new ArrayList<>(); 
		
		
		for(int i = 0; i < m; i++) {
			s = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Input(Integer.parseInt(s.nextToken()));
				//System.out.println(arr[i][j].w + " " + arr[i][j].n + " " + arr[i][j].e + " " + arr[i][j].s);
			}
		}
		
		int roomnum = 1;
		int max = 1;
		int temp = 0;
		al.add(0);
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(check[i][j] == 0) {
					cnt = 0;
					temp = dfs(i,j,roomnum);
					al.add(temp);
					roomnum++;
					max = (max > temp) ? max : temp;
				}
			}
		}
		
		System.out.println(roomnum-1);
		
		System.out.println(max);
		
		Iterator<pair> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			pair p = itr.next();
			if(p.index1 == 0) itr.remove();
			if(p.index1 == p.index2) itr.remove();
		}
		
		int last = 0;
		
		for(pair i : map.keySet()) {
			last = (last > al.get(i.index1) + al.get(i.index2)) ? last : al.get(i.index1) + al.get(i.index2);
		}
		
		System.out.println(last);
	}
	
	public static wall Input(int x) {
		
		String s = Integer.toBinaryString(x);
		
		char arr[] = new char[4];
		//System.out.println(s);
		
		if(s.length() < 4) {
			int j = s.length();
			for(int i = 0; i < s.length(); i++) {
				j--;
				arr[i] = s.charAt(j);
			}
			
			int length = s.length();
			
			while(length != 4) {
				arr[length] = '0';
				length++;
			}
		}
		else {
			int j = 3;
			for(int i = 0; i < 4; i++) {
				arr[i] = s.charAt(j);
				j--;
			}
		}
		
		wall a = new wall(arr[0],arr[1],arr[2],arr[3]);
		
		return a;
	}
	
	public static int dfs(int i, int j, int roomnum) {
		check[i][j] = roomnum;
		wall temp = arr[i][j];
		
		char array[] = {temp.w, temp.n, temp.e, temp.s};
		
			for(int x = 0; x < 4; x++) {
				if(array[x] == '0') {
					switch (x) {
					case 0 :
						
						if(check[i][j-1] != 0) continue;
						dfs(i,j-1,roomnum);
						check[i][j-1] = roomnum;
						break;
						
					case 1 :
						
						if(check[i-1][j] != 0) continue;
						dfs(i-1,j,roomnum);
						check[i-1][j] = roomnum;
						break;
						
					case 2 :

						if(check[i][j+1] != 0) continue;
						dfs(i,j+1,roomnum);
						check[i][j+1] = roomnum;
						break;
						
					case 3 :
						
						if(check[i+1][j] != 0) continue;
						dfs(i+1,j,roomnum);
						check[i+1][j] = roomnum;
						break;
				}
			}
			else {
				switch (x) {
				case 0 :
					if(j-1 < 0) continue;
					map.put(new pair(check[i][j-1],check[i][j]), cnt);
					break;
					
				case 1 :
					if(i-1 < 0) continue;
					map.put(new pair(check[i-1][j],check[i][j]), cnt);
					break;
					
				case 2 :
					if(j+1 >= n) continue;
					map.put(new pair(check[i][j+1],check[i][j]), cnt);
					break;
					
				case 3 :
					if(i+1 >= m) continue;
					map.put(new pair(check[i+1][j],check[i][j]), cnt);
					break;
				}
			}
		}
		
		return ++cnt;
	}
}

class wall{
	char w;
	char n;
	char e;
	char s;
	
	public wall(char w, char n, char e, char s) {
		this.w = w;
		this.n = n;
		this.e = e;
		this.s = s;
	}
}

class pair{
	int index1;
	int index2;
	
	public pair(int index1, int index2){
		this.index1 = index1;
		this.index2 = index2;
	}
}
