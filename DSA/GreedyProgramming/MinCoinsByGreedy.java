//Given, an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

import java.util.List;
import java.util.ArrayList;

class MinCoinsByGreedy{

	public static int numOfCoins(int[] coins, int sum, List<Integer> resList){
		int res = 0;
		//Iterate over the coins array, if the coin value is less than or equal to remaining sum, reove the coin value from sum and add that coin in result.
		for(int i = coins.length-1; i>= 0; i--){
			while(sum>=coins[i]){
				res++;
				sum-=coins[i];
				resList.add(coins[i]);
			}
		}
		return res;
	}

	public static void main(String[] args){
		int[] coins = {1,2,5,10,20,50,100,500,1000};
		List<Integer> resList = new ArrayList<>();
		int sum = 49;
		System.out.println(numOfCoins(coins, sum, resList));
		for(int t: resList){
			System.out.print(t+ " ");
		}
	}
}