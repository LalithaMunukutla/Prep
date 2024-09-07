//carry a pointer(j) that points to the first zero in the array
//iterate over the array, if value not equals to zero then swap with j and inc j.

public class MoveZerosToEnd{
	public static void moveZeros(int[] arr){
		int j=-1;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				j=i;
				break;
			}
		}
		for(int i=j+1;i<arr.length;i++){
			if(arr[i]!=0){
				int temp = arr[j];
				arr[j]=arr[i];
				arr[i] = temp;
				j++;
			}
		}
	}

	public static void main(String[] args){
		int[] arr = {0,1,0,3,12};
		moveZeros(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}