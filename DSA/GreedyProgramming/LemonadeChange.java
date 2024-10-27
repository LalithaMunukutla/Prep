//Customers can only pay with 5$, 10$ or 20$ bills and we initially do not have any change at hand. 
//Return true, if it is possible to provide correct change for each customer otherwise return false.

class LemonadeChange{

	public static boolean isChangeAvailable(int[] bills){
		int[] change = {0,0};
		for(int i=0;i<bills.length;i++){
			if(bills[i] == 5){
				change[0]++;
			}
			else if(bills[i] ==10){
				if(change[0]<=0){
					return false;
				}
				change[1]++;
				change[0]--;
			}
			else {
				if(change[1]>0 && change[0]>0){
					change[1]--;
					change[0]--;
				}
				else if(change[0]>=3){
					change[0]-=3;
				}
				else{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args){
		int[] bills = {5,5,10,10,20};
		System.out.println(isChangeAvailable(bills));
	}
}