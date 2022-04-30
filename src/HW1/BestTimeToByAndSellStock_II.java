package HW1;

public class BestTimeToByAndSellStock_II {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {6,1,3,2,4,7};
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
//        int[] prices = {1};

        System.out.println("Max profit of multiply dials: " + maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int res = 0;
        int isDeal = 1;

        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i];
            if (temp > prices[i - 1]) {
                if (isDeal < 1) {
                    isDeal = 1;
                    buyPrice = prices[i - 1];
                }
            } else {
                if (isDeal > 0){
                    isDeal = 0;
                    res = res + prices[i - 1] - buyPrice;
                }
            }
        }

        if(prices.length > 1 && prices[prices.length - 1] > prices[prices.length - 2]){
            res = res + prices[prices.length - 1] - buyPrice;
        }

        if(res == 0 & isDeal ==1){
            res = res + prices[prices.length - 1] - buyPrice;
        }

        return res;
    }
}
