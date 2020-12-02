package BojStackQueueDeque;

import java.util.*;
import java.io.*;

public class BigNumberOnTheRigth17298bf{
	static int[] arr;
	static int[] max;
	
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        max = new int[N];
       
        String[] str = bf.readLine().split(" ");
       
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        
        Stack <Integer> s = new Stack<>();
        
        s.push(0);
        
        for (int i = 1; i < N; i++) {
            
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                max[s.pop()] = arr[i];
            }
            s.push(i);
        }
        
        while (!s.empty()) {
            max[s.pop()] = -1;
        }
        
 
       
        for (int i = 0; i < N; i++) {
            bw.write(max[i] + " ");
        }
       
        bw.flush();
    }
}
