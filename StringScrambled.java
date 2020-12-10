package test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/scramble-string/

public class StringScrambled {
	
	    static Map<String,Boolean> remember = new HashMap<>();
	    
	    
	    public static boolean isScramble(String s1, String s2) {
	        
	         if(s1.length()==0) {
	           if(s2.length()==0)
	           return true;
	             else return false;
	         }
	        
	         String key=s1+s2;
		        String key1=s2+s1;
		        if(remember.containsKey(key)) return remember.get(key);
		        if(remember.containsKey(key1)) return remember.get(key1);
		        
		        
		     if(s1.length()==1) {
		    	 boolean r = s1.charAt(0) == s2.charAt(0);
	             remember.put(key, r);
	             remember.put(key1, r);
	             return r;
		     }
		        
	         
	         for(int i=1; i<s1.length(); i++) {
	             String s11 = s1.substring(0,i);
	             String s12 = s1.substring(i);
	             
	             String s21 = s2.substring(0,i);
	             String s22 = s2.substring(i);
	             
	          boolean result=false;   
	           //System.out.println("?: " +s11+","+s12+" ==> " + s21+","+s22);
	          if(isScramble(s11,s21) && isScramble(s12,s22) ){
	            //System.out.println("TRUE: " +s11+","+s12+" ==> " + s21+","+s22);
	            result= true;
	        }
	          
	         //it is also possible that the strings are swapped: abb(a, bb) ==> bba(bb,a) 
	         s21 = s2.substring(0, s2.length()-i);
	         s22 = s2.substring(s2.length()-i);
	         if( isScramble(s11,s22) && isScramble(s12,s21) )  {
	             //System.out.println("TRUE: " +s11+","+s12+" ==> " + s21+","+s22);
	            result= true;
	        }
	             
	             if(result) {
	                 remember.put(key, true);
	                 remember.put(key1, true);
	                 return true;
	             }
	         }
	        
	        remember.put(key, false);
	        remember.put(key1, false);
	        return false;
	        
	        
	    }
	    
	    
	    public static void main(String[] args) {
//	    	String s1="great";
//	    	String s2="rgeat";
	    	
	    	String s1="abb";
	    	String s2="bba";
	    	
	    	System.out.println(isScramble(s1,s2));
	    }

}
