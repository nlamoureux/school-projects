package Assignment7;
//Nathan Lamoureux
public class Question9_2 {
    public static void main(String[] args) {
      Stock newStock = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);
      //Printing Stocks + prices
      System.out.println("\n Oracle Corporation");
      System.out.println("Closing price:     " + newStock.previousClosingprice);
      System.out.println("Current price:     " + newStock.currentPrice);
      System.out.println("Price-change percentage:      " + newStock.getChangePercent());

    }
}
//Creating stock class
class Stock {

    String symbol;
    String name;
    double previousClosingprice;
    double currentPrice;

    Stock(String newSymbol, String newName, double PCP, double CP) {
        symbol = newSymbol;
        name = newName;
        previousClosingprice = PCP;
        currentPrice = CP;
    }

    public double getChangePercent(){
        if( previousClosingprice > currentPrice) {
            return (previousClosingprice - currentPrice / previousClosingprice) * 100;
        }
        else{
            return (currentPrice - previousClosingprice / previousClosingprice) * 100;
        }
    }

}
