//Given an array nums, return true if the array was originally sorted in non-decreasing order, 
//then rotated some number of positions (including zero). Otherwise, return false. There may be duplicates.


public class CheckIfArraySortedAndRotated{

	public static Boolean isArraySorted(int[] nums, int n){
		int count =0;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]>nums[i+1]){
				count++;
			}
		}
		if(nums[0]<nums[n-1]){
			count++;
		}
		return count<=1;
	}

	public static void main(String[] args){
		int[] nums = {6,5,2,3,4};
		System.out.println("Array is sorted and rotated: " + isArraySorted(nums, nums.length));
	}
}