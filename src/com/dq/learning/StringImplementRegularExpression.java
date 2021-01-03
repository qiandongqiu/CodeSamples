package com.dq.learning;

//regular expresion contains . or *;  . matches any sigle char; * matches zeror or more of the preceding element
public class StringImplementRegularExpression {
	public static boolean isMatch(String s, String p) {
		if(s==null || s.isEmpty()) return true;
		if(p==null || p.isEmpty()) return false;
		System.out.println(s+"  ====  "+p);
		// s: aab
		// p: c*a*b //result: match
		// p: .* match
		char ch = s.charAt(0);
		char pCh = p.charAt(0);
		// ch matches P's first
		if (ch == pCh) {
			if(p.length()>1 && p.charAt(1)!='*') {
			  return isMatch(s.substring(1), p.substring(1));
			} else {
			  return isMatch(s.substring(1), p);
			}
		} else {
			// ch does not equal's P's first
			if (pCh == '.') {
				
				if(p.length()>1 && p.charAt(1)=='*') {
				    return isMatch(s.substring(1), p);
				} else {
				    return isMatch(s.substring(1), p.substring(1));
				}
			} else {
				if (pCh == '*') {
					return isMatch(s, p.substring(1));
				} else {
					//in case: "aab" with pattern "c*a*b"
					if(p.length()>=2 && p.charAt(1)=='*') {
					   return isMatch(s, p.substring(2));
					}
					else return false;
				}
			}
		}

	}
	
	public static void main(String[] args) {
//		String s="aab";
//		String p="c*a*b";
//		System.out.println(isMatch(s,p));
//		String s1="ab";
//		String p1=".*";
//		System.out.println(isMatch(s1,p1));
		String s2="mississippi";
		String p2="mis*is*p*.";
		System.out.println(isMatch(s2,p2));
	}

}
