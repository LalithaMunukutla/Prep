//Fractional Knapsack --- Greedy

//The weight of N items and their corresponding values are given. We have to put these items in a knapsasck of weight W such that total value is maximised

//As the res has to be maximised, focus on picking items having higher (value/weight). Sort items in descending order wrt (value/weight)

import java.util.Comparator; 
import java.util.Arrays;


class FractionalKnapsack{
	class Item{
		int value;
		int weight;
		Item(int x, int y){
			this.value = x;
			this.weight = y; 
		}
	}

	class ItemComparator implements Comparator<Item>{
		public int compare(Item a, Item b){
			double x = (double)a.value/(double)a.weight;
			double y = (double)b.value/(double)b.weight;
			if(x<y){
				return 1;
			}
			if(x>y){
				return -1;
			}
			return 0;
		}
	}

	public double maxValue(Item arr[], int w){
		Arrays.sort(arr, new ItemComparator());
		double res =0.0;
		int currWeight = 0;
		//Iterate through the loop, on adding weight to currWeight is less than or equal to given weight then add the weight to currWeight and its value to res
		//else get the remaining weight and add that partial value to res and return res. 
		for(int i=0;i<arr.length;i++){
			if(currWeight + arr[i].weight <= w){
				currWeight += arr[i].weight;
				res += arr[i].value;
			}
			else{
				int rem = w- currWeight;
				res += ((double)arr[i].value/(double)arr[i].weight)*rem;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args){
		FractionalKnapsack fk = new FractionalKnapsack();
		Item arr[] = {fk.new Item(100,20), fk.new Item(60,10), fk.new Item(120,30)};
		int w = 50;
		System.out.println(fk.maxValue(arr, w));
	}
}