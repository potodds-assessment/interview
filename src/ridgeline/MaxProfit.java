package ridgeline;

/*
 * Click `Run` to execute the snippet below!
 */

 import java.io.*;
 import java.util.*;
 
 /*
  * To execute Java, please define "static void main" on a class
  * named Solution.
  *
  * If you need more classes, simply define them inline.
  */
 
 import java.util.Map;
 import java.util.HashMap;
 
 class MaxProfit {
   double cash;
   Map<String, Integer> tickerQtyMap = new HashMap<>();;
 
   public MaxProfit(double cash) {
     this.cash = cash;
   }
 
   public void buyShares(String ticker, Integer qty, double price) 
     throws Exception {
     double stockCost = price * qty;
     if (stockCost < cash) {
       cash -= stockCost;
       if (tickerQtyMap.get(ticker) == null)
         tickerQtyMap.put(ticker, qty);
       else {
         Integer existingQty = tickerQtyMap.get(ticker);
         tickerQtyMap.put(ticker, existingQty+qty);
       }      
     } else 
       throw new Exception("Not enough cash: " + cash);
   }
 
   public void sellShares(String ticker, Integer qty, double price)  
     throws Exception {
     Integer existingQty = tickerQtyMap.get(ticker);
     if (existingQty != null && existingQty > qty) {
       cash += price * qty;
       tickerQtyMap.put(ticker, existingQty-qty);
     } else 
       throw new Exception("Not enough qty to sell: " + qty);    
   }
 
   public double GetCashBalance() {
     return cash;
   }
 
   public Integer GetQuantityOfShares(String ticker) {
     return tickerQtyMap.get(ticker);
   }
 
   public int getMaxProfit(int[] prices) {
     int ans=0;
 
     int minPrice=prices[0];
     for(int i=1; i<prices.length; ++i) {
       ans=Math.max(ans, prices[i]-minPrice);
       minPrice=Math.min(minPrice, prices[i]);
     }
 
     return ans;
   }
 
 
   public static void main(String[] args) {
    MaxProfit testP = new MaxProfit(1000000);
 
     int[] prices = new int[]{170,175,172,178,180};
     System.out.println(testP.getMaxProfit(prices));
 
 
 /*
     try {
       testP.buyShares("MSFT", 10, 1000);
       System.out.println(testP.GetCashBalance());
     } catch(Exception e) {
       e.printStackTrace();
     }
 */
   }
 }
 
 /*
 Step 1 - Accounting (limit 15 minutes): 
 Build a class / object that can track your portfolio.  You don’t need to track individual trades, but
 it should capture the net impact of the trade on the portfolio (+/- cash and +/- quantity of shares).  
 
 It should have methods:
     * Buy(ticker, quantity, pricePerShare) : void : exception
        - Must have sufficient cash
     * Sell(ticker, quantity, pricePerShare) : void : exception
        - Must have sufficient quantity
     * GetCashBalance() : decimal
     * GetQuantityOfShares(ticker) : integer
 
 Step 2 - Trading (limit 30 minute):
 Write code that generates trades to maximize gains in a single stock.  You may trade at most
 once per day, but are not required to trade every day.  Shares must be purchased as whole
 numbers (no fractional shares).  Shares and cash cannot be negative.  
 
 Using code from Step 1 may be helpful, but is not required.  
 
 Starting Cash: 100000
 Ticker: ABCD
 
 Predicted Stock Price:
 Day 1: 170
 Day 2: 175
 Day 3: 172
 Day 4: 178
 Day 5: 180
 
 Output:
     * Daily Activity
         Format: (BUY|SELL|HOLD) 100 Shares ABCD at $170 : cash balance $1000
     * BONUS: the ending portfolio value 
         Format: Ending Value: $123456 (23.46%)
  */