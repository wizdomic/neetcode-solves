class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE; // store the lowest price seen so far
        int maxProfit = 0; // store the maximum profit achievable

        // iterate through each stock price
        for (int price : prices) {
            if (price < minprice) {
                minprice = price; // update minimum price if a lower one is found
            }
            if (maxProfit < price - minprice) {
                maxProfit = price - minprice; // update profit if current difference is greater
            }
        }

        return maxProfit; // return the maximum profit possible
    }
}
