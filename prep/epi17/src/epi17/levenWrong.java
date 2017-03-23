package epi17;
import java.util.*;

public class levenWrong{
	public static int leven;
	public static int pos;
	
	public static void dist(String a, String b) {
		pos=0;
		leven = 0;
		String in = a;
		String out = b;

		System.out.println("HERE");
		while(!out.equals(in)) {
			if(in.length()<= pos) {
				//insert space
				in += " ";
			}
//			else if(out.length()<=pos) {
//				//insert space
//				 out += " ";
//			}
			else {
				if(in.charAt(pos)!=out.charAt(pos)) {
					//algo
					
					if(in.length()<=pos+1 ? (out.length()<=pos+1 ? in.charAt(pos+1) == out.charAt(pos+1) : false) : false) {
						//Replace
						char r = out.charAt(pos);
						in = in.substring(0, pos) + r + in.substring(pos+1,in.length());
						pos++;
						leven++;
					}
					else {
						if(in.length()>out.length()) {
							//delete
							in = in.substring(0, pos) + in.substring(pos+1,in.length());
							leven++;
						}
						if(in.length()<out.length()) {
							//insert
							in = in.substring(0, pos) + out.charAt(pos) + in.substring(pos+1,in.length());
							pos++;
							leven++;
						}
					}
				}
				else {
					//chars are equal, move to next char
					pos++;
				}
			}
			
		}
		System.out.println("Leven dist is " + leven);
		
		
	}
	
	
	public static void main(String[] args) {
		String a = "HELLO";
//		char[] A = a.toCharArray();
//		A[1] = 'r';
//		System.out.println(A);
//		a = a.substring(2, a.length());
		int pos = 2;
		a = a.substring(0, pos) + 'R' + a.substring(pos+1,a.length());
		System.out.println(a);
		dist("sar","ra");
	}
	
	
}