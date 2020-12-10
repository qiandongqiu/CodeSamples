package test;
//take a look at ArrayJumpGame.java, the array and conditions are the same; but this one try to solve: min steps to reach the end

public class ArrayMinJumps {
	/* since it has sub problems, we can use recursive calls
	 */
	
	public static int jumpUtil_WITHOUT_MEMORY(int[] numbs, int start) {
		int N=numbs.length;
		if(start== (N-1)) return 0;
		
		int minJump = Integer.MAX_VALUE;

		int steps = numbs[start];
		for(int i=start+1; i<N && i<=start+steps; i++) {
			int jumpsNeeded = jumpUtil_WITHOUT_MEMORY(numbs, i);
			if(jumpsNeeded!=Integer.MAX_VALUE && jumpsNeeded+1 < minJump) {
				minJump = jumpsNeeded+1;
			}
		}
		return minJump;
	}
	
	public static int jumpUtil(int[] numbs, int start, int[] minSteps) {
		int N=numbs.length;
		if(start== (N-1)) return 0;
		
		int minJump = Integer.MAX_VALUE;

		int steps = numbs[start];
		for(int i=start+1; i<N && i<=start+steps; i++) {
			int jumpsNeeded = minSteps[i];

			if(jumpsNeeded==Integer.MAX_VALUE) {
			   jumpsNeeded = jumpUtil(numbs, i, minSteps);
			   if(jumpsNeeded!=Integer.MAX_VALUE) {
				   minSteps[i] = Math.min(minSteps[i], jumpsNeeded);
			   }
			}


			if(jumpsNeeded!=Integer.MAX_VALUE && jumpsNeeded+1 < minJump) {
				minJump = jumpsNeeded+1;
			}
		}
		return minJump;
	}

	 public  static int jump(int[] nums) {
		 int N = nums.length;
		 if(N==0) return Integer.MAX_VALUE;
		 
		 int[] minSteps = new int[nums.length];
		 for(int i=0; i<nums.length;i++)
			 minSteps[i]=Integer.MAX_VALUE;
		 
		 
		 if(nums[0]==0) return Integer.MAX_VALUE;

		 minSteps[0]=0;
		 
		 for(int i=0; i<N; i++) {
			 System.out.println("i="+i);
			 int steps=nums[i];
			 for(int j=i+1; j<N && j<=i+steps; j++) {
				 System.out.println("   j="+j);
				 if(minSteps[i]!=Integer.MAX_VALUE) {
				   minSteps[j]=Math.min(minSteps[j],minSteps[i]+1);
				 }
			 }
		 }
		 
		 return minSteps[N-1];
		 
	        
	 }

	 public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
   	    //int[] nums = {2,0,1};
		System.out.println(jump(nums));
	 }
}
