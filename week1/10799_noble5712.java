package week1;
import java.io.*;
import java.util.*;

public class Q10799 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		String s = new String(br.readLine());
		
		char ch;
		
		int cnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if(ch == '(') {
				stack.add(1);
			}
			else if(ch == ')'){
				stack.pop();
				if(s.charAt(i-1) == '(') {
					cnt += stack.size();
				} else cnt ++;
			}
		}
		System.out.println(cnt);
	}
}
