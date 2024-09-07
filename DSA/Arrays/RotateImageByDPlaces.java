//to rotate an array by k places right, break reverse then complete reverse
//to rotate an array by k places left, full reverse then break and reverse

public class RotateImageByDPlaces{

	public static void reverse(int[] arr, int l, int h){
		while(l<h){
			int temp = arr[l];
			arr[l]=arr[h];
			arr[h]=temp;
			l++;
			h--;
		}
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7};
		int k=3;
		k%=arr.length;
		reverse(arr,0, arr.length-1);
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}