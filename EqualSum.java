package test;

public class EqualSum {
	
	   private static boolean foundOneSubArray(int[] A, long avg) {
            // A = {18,12,-18,18,-19,-1,10,10};
		   long sum=0;
		   for(int i=0; i<A.length; i++) {
			    sum = sum + A[i];
			    A[i]=0;
			    if(sum == avg) return true;
		   }
		   
		   return false;
		   
	   }
	
	    //determine whether array can be divided into 3 sub-arrays, with same sum
	    public static boolean canThreePartsEqualSum(int[] A) {
	    	long sum=0;
	    	for(int i=0; i<A.length; i++) {
	    		sum += A[i];
	    	}
	    	long avg = sum % 3;
	        if(avg!=0) return false;
	        avg = sum / 3;
	        System.out.println("Avg="+avg);
	        
	        int foundTotal = 0;
	        boolean found=true;
	        do {
	        	found = foundOneSubArray(A, avg);
	        	if(found) foundTotal++;
	        } while(found && foundTotal <3);
	        
	        if(foundTotal==3) return true;
	        
	        return false;
	    	
	    }
	    
	    
	    public static void main(String[] args) {
            int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
            //int[] A = {0,2,1,-6,6,7,9,-1,2,0,1};
            //int[] A = {18,12,-18,18,-19,-1,10,10};  //this is hard one: notice that fist 6 sum is 10; group sum is 10 too
            System.out.println(canThreePartsEqualSum(A));
	    }

}

