//Minimum number of platforms required for a railway

//given two arrays that represent the arrival and departure times of trains that stop at the platform. 
//Find the minimum number of platforms needed at the railway station so that no train has to wait.

//sol: sort the arrival and departure arrays.
//Initially, we would need atleast one platform. If next arrival time is less than or equal to departure time, then we need one more platform for this arrival time.
//Else, it means we have an extra platform, so reduce it and inc departure time. Update number of platforms needed with max of curr platforms needed and final res.


import java.util.Arrays;

class MinNoOfPlatformsNeeded{

	public static int getNoOfPlatforms(int[] arr, int[] dep){
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i=1, j=0, res=0, pf =1;
		while(i<arr.length && j<dep.length){
			if(arr[i]<=dep[j]){
				pf++;
				i++;
			}
			else {
				pf--;
				j++;
			}
			res = Math.max(pf, res);
		}
		return res;
	}

	public static void main(String[] args){
		int[] arr = {900,955,1100,945,1500,1800};
		int[] dep = {920,1200,1130,1150,1900,2000};
		System.out.println(getNoOfPlatforms(arr, dep)); 
	}
}