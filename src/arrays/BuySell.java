package com.rohit.arrays;

public class BuySell {
	
	
	public static void main(String[] args) {
		
		int prices[] = {1,2};
		System.out.println(new BuySell().maxProfit(prices));	
	}
	

	public int maxProfit(int[] prices) {

		int maxProfit = 0;

		int i = 0;
		int j = 1;

		while (i < prices.length-1 && j < prices.length) {

			while (j < prices.length && i < prices.length - 1 && prices[i] < prices[j] && prices[i] > prices[j] ) {
				i++;
				j++;
				continue;
			}

			int temp_i=i;
			while ( j < prices.length && i < prices.length-1 && prices[i] < prices[j]) {
				i++;
				j++;
			}

			if (prices[i] > prices[temp_i]) {
				maxProfit += prices[i] - prices[temp_i];

			}

			i = j;
			j++;
		}

		return maxProfit;
	}

}
