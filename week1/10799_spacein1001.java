package BojStackQueueDeque;

import java.util.*;

public class IronBar_Cut_10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Stack <String> s = new Stack<>();
		
		int cnt = 0;       // 자른 후 조각 개수 
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i) == '(') {    // String은 문자열이기 때문에 charAt로 각각 본다
				s.push("(");
			}
			
			else if(str.charAt(i) == ')'){   // 제일 처음에 올수 x , 문제에 명시
				
				if(str.charAt(i-1) == '(') { //      ')' 바로 전에 '(' 온 경우 
					s.pop();                 
					cnt += s.size();         //cnt >> stack의 size들의 합
				}
				
				else if(str.charAt(i-1) == ')'){ //     ')' 는 막대가 끝남을 의미함
					s.pop();
					cnt ++; // ()가 바로오는게 아니고, )))같은게 오면 막대가 끝에 자투리 +1 해줌
				}
			}
		}
		System.out.print(cnt);
	}
}
