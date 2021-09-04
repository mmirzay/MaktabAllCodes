package com.project.my.homeworks.hw4.q3;

public class Main {
	public static void main(String[] args) {
		System.out.println("Example 1:");
		int[] ex1 = { 7, 1, 5, 3, 6, 4 };
		getProfit(ex1);
		System.out.println("Example 2:");
		int[] ex2 = { 7, 6, 4, 3, 1 };
		getProfit(ex2);
		System.out.println("Example 3:");
		int[] ex3 = { 7, 2, 8, 7, 6, 1, 5, 9, 6 };
		getProfit(ex3);
	}

	private static void getProfit(int[] prices) {
		System.out.print("Input : prices= [");
		for (int i = 0; i < prices.length - 1; i++)
			System.out.print(prices[i] + ",");
		System.out.println(prices[prices.length - 1] + "]");
		int profit = 0;
		int minStock = Integer.MAX_VALUE;
		int maxStock = Integer.MIN_VALUE;
		int buyingDay = 0;
		int sellingDay = 0;
		for (int i = 0; i < prices.length; i++)
			if (prices[i] < minStock) {
				minStock = prices[i];
				buyingDay = i + 1;
				profit = 0;
			} else if (prices[i] > maxStock) {
				maxStock = prices[i];
				profit = maxStock - minStock;
				sellingDay = i + 1;
			}

		System.out.println("Output: " + profit);
		System.out.print("Explanation: ");
		if (profit == 0)
			System.out.println("In this case, no transactions are done and the max profit = 0.");
		else
			System.out.printf("Buy on day %d (price = %d) and sell on day %d (price = %d), profit = %d - %d = %d.%n",
					buyingDay, prices[buyingDay - 1], sellingDay, prices[sellingDay - 1], prices[sellingDay - 1],
					prices[buyingDay - 1], profit);
		System.out.println("---------------------------------------");
	}
}
