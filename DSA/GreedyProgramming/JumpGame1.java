//Jump Game

//Given maximum number of steps you can jump forward from that element,

//VAR-1 return true if we can reach the last index starting from the first index. Otherwise, return false.

//VAR-2 Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

class JumpGame1{

//Sol VAR-1
//keep track of farthest position that we can reach at any point of time in currMax
//Return false, if we reach a point in iteration that is not a reachable farthest point; i.e., i>currMax
//Else we can reach endpoint, so return true.

	public static boolean isReachable(int[] arr){
		int currMax=0;
		for(int i=0;i<arr.length;i++){
			if(i>currMax){
				return false;
			}
			currMax = Math.max(currMax, i+arr[i]);
		}
		return true;
	}

//Sol VAR-2
//Consider two pointers l,r that are boundaries of current window.
//In each window, get the farthest point reachable, and update the next window boundary with next element to next farthest point reachable.
//Increment jump as we change the window

	public static int minNoOfSteps(int[] arr){
		int l=0, r=0, currMax =0, res=0;
		while(r<arr.length-1){
			currMax=r;
			for(int i=l;i<=r;i++){
				currMax = Math.max(currMax, i+arr[i]);
			}
			l=r+1;
			r=currMax;
			res++;
		}
		return res;
	}

	public static void main(String[] args){
		int[] arr = {2,3,1,0,4};
		System.out.println(isReachable(arr)); //VAR-1
		System.out.println(minNoOfSteps(arr)); //VAR2
	}
}