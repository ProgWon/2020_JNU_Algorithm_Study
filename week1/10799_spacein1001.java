package BojStackQueueDeque;

import java.util.*;

public class IronBar_Cut_10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Stack <String> s = new Stack<>();
		
		int cnt = 0;       // �ڸ� �� ���� ���� 
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i) == '(') {    // String�� ���ڿ��̱� ������ charAt�� ���� ����
				s.push("(");
			}
			
			else if(str.charAt(i) == ')'){   // ���� ó���� �ü� x , ������ ���
				
				if(str.charAt(i-1) == '(') { //      ')' �ٷ� ���� '(' �� ��� 
					s.pop();                 
					cnt += s.size();         //cnt >> stack�� size���� ��
				}
				
				else if(str.charAt(i-1) == ')'){ //     ')' �� ���밡 ������ �ǹ���
					s.pop();
					cnt ++; // ()�� �ٷο��°� �ƴϰ�, )))������ ���� ���밡 ���� ������ +1 ����
				}
			}
		}
		System.out.print(cnt);
	}
}
