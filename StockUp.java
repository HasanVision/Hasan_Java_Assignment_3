import objects.*;
import utility.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StockUp {
  private static Scanner input = new Scanner(System.in);
  private static Ink ink = new Ink();
  private static Validator validator = new Validator();
  private static Market market = new Market();
  private static Portfolio portfolio;

  private static int min = 1; // used for menu selections
  private static int max = 4; // we need a way to set that based on menu items!!
  private static boolean isDone = false;
  private static boolean goBack = false;

  public static void main(String[] args) {

    ink.printWelcome();

    // sets the starting balance for our portfolio
    System.out.println("How much money are you starting with?");
    double deposit = input.nextDouble();
    portfolio = new Portfolio(deposit);

    seedStocks(); // seed out stocks with some pretend stocks
    seedMarket(); // creates our test Market stocks

    while(!isDone) {
      int choice = validator.selValidation(ink, input, min, max);
    
      switch (choice) {
        case 1: // print portfolio
          ink.printPortfolio(portfolio.getStocks(), portfolio.getNetworth(),
            portfolio.getBalance());
          break;
        case 2: // print market
          while(!goBack) {
            ink.printMarket(market.getStocks());
            int idx = input.nextInt();
            Stock stock = market.getStock(idx - 1);
            ink.printStock(stock);
            int qty = input.nextInt();
            boolean isSuccess = market.buyStocks(stock, qty, portfolio.getBalance());
            if(isSuccess) {
              double purchaseAmount = stock.getPrice() * qty; 
              portfolio.buyStock(stock, qty, purchaseAmount);
              goBack = !goBack;
            } // if
          } // while
          goBack = !goBack; // resets goBack to false
          break;
        case 3: // add funds
          double amount = validator.fundValidation(ink, input, portfolio.getBalance());
          portfolio.addFunds(amount);
          // print the new balance
          System.out.printf("New balance: $%.2f\n", portfolio.getBalance());
          break;
        case 4:
          isDone = !isDone;
          break;
      } // switch
    } // while
    ink.printGoodday();
  } // main()

  public static void seedStocks() {
    // the purpose is to create some TEST stocks!
    Stock stock = new Stock("Microsoft", "MSFT", 420.00, 100);
    portfolio.addStock(stock);
    stock = new Stock("Uber", "UBR", 120.00, 50);
    portfolio.addStock(stock);
    stock = new Stock("Nvidia", "NVD", 250.00, 90);
    portfolio.addStock(stock);
  } // seedStocks()

  public static void seedMarket() {
    ArrayList<Stock> stocks = new ArrayList<>();
    // the purpose is to create some TEST stocks for the Market
    Stock stock = new Stock("Adobe", "ADB", 20.00, 0);
    stocks.add(stock);
    stock = new Stock("Netflix", "NFX", 120.00, 0);
    stocks.add(stock);
    stock = new Stock("Apple", "APL", 250.00, 0);
    stocks.add(stock);
    stock = new Stock("Disney", "MOUSE", 1250.00, 0);
    stocks.add(stock);
    stock = new Stock("Microsoft", "MSFT", 420.00, 0);
    stocks.add(stock);
    stock = new Stock("Uber", "UBR", 120.00, 0);
    stocks.add(stock);
    stock = new Stock("Nvidia", "NVD", 900.00, 0);
    stocks.add(stock);
    market.setStocks(stocks);
  } // seedMarket()
} // class