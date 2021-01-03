package com.dq.learning;

public class SquareRootWithPrecesion {
   double squareRootWithPrecision(int target, int precision) {
	   int start=0; int end=target;
	 
	   double ans=0;
	   int bigPart=0;
	   //do the integral part
	   while(start<=end) {  //try all the numbers in-between start to end;
		   int mid = (start+end) / 2;
		   
		   double square = mid*mid;
		   if(square == target) {
			   bigPart = mid;
			   break;
		   }
		   
		   if(square < target) {
			   //too small
			   start=mid+1;
			   bigPart = mid;
			   
		   } else {
			   //too big
			   end = mid -1;
		   }
	   } //while for getting the integral part    
		 
		 //now, start to do the precision part
		   double step=1;
		   ans=bigPart+step;
		   for(int i=0; i<precision; i++) {
			   step = step / 10;
			   
			   double square = ans*ans;
			   while(square<=target) {
				   ans+=step;
				   square=ans*ans;
			   }
			   ans = ans - step;
		   }
		   
		   
	   
	   
	   return ans;
	   
   }
   
   public static void main(String[] args) {
	   SquareRootWithPrecesion ins = new SquareRootWithPrecesion();
	   System.out.println(ins.squareRootWithPrecision(9,0));
	   System.out.println(ins.squareRootWithPrecision(99, 5));;
	   
	   
   }
	
}
