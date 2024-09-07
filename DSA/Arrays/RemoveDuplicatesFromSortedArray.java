//Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. 
//The relative order of the elements should be kept same

//when you find a new number, move it to desired location
public class RemoveDuplicatesFromSortedArray{

	public static int removeDuplicates(int[] arr){
		int k=0, i=1;
		while(i<arr.length){
			if(arr[i]==arr[i-1]){
				i++;
			}
			else{
				arr[++k] = arr[i++];
			}
		}
		return (k+1);
	}

	public static void main(String[] args){
		int[] arr = {1,1,2,3,4,4,5};
		int k = removeDuplicates(arr);
		for(int i=0;i<k;i++){
			System.out.println(arr[i]);
		}
	}
}