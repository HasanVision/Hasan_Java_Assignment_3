package utility;

import java.util.ArrayList;

import objects.*;

public class Ink {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_PURPLE = "\u001B[35m";

  public Ink() {
    // do nothing
  }

  public void printWelcome() {
    System.out.println(ANSI_GREEN + "*** Welcome to StockUP beta ***" + ANSI_RESET + "\n");

  }

  public void printGoodday() {
    System.out.println(ANSI_BLUE + "*** Richer Every Day with stockUP ***" + ANSI_RESET + "\n");

  }

  public void printStock(Stock stock) {
    System.out.printf(ANSI_YELLOW + "Name: %s\nSymbol: %s\nPrice: $%.2f" + ANSI_RESET,
        stock.getName(), stock.getSymbol(), stock.getPrice());
    System.out.println("\nHow many units of this stock would you like?? ");
  }

  public void printPortfolio(ArrayList<Stock> stocks, double networth,
      double balance) {
    for (int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f Qty: %d\n",
          i + 1,
          stocks.get(i).getName(),
          stocks.get(i).getSymbol(),
          stocks.get(i).getPrice(),
          stocks.get(i).getQty());
    } // for
    System.out.printf("Networth: $%.2f\n", networth);
    System.out.printf("Balance: $%.2f\n", balance);
  } // printPortfolio()

  public void printMarket(ArrayList<Stock> stocks) {
    for (int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f\n",
          i + 1,
          stocks.get(i).getName(),
          stocks.get(i).getSymbol(),
          stocks.get(i).getPrice());
    } // for
    System.out.println("Which stock would you like to buy?: ");
  } // printMarket()

  public void printMenu() {
    System.out.println("(1) Show Portfolio");
    System.out.println("(2) Show Stocks");
    System.out.println("(3) Add Funds");
    System.out.println("(4) Show Networth");
    System.out.println("(5) Sell Stock");
    System.out.println("(6) Exit");
  } // printMenu()

  public void printStockDetail(Stock stock) {
    System.out.printf("Name: %s Symbol: %s Price: %d Qty: %d",
        stock.getName(), stock.getSymbol(),
        stock.getPrice(), stock.getQty());
  }

  public void printAddFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to add?: ",
        balance);
  }

  public void printNetworth(double networth, ArrayList<Stock> stocks) {
    System.out.println(ANSI_GREEN + "Net Worth: $" + networth + ANSI_RESET);
    // Optionally print details of each stock
    for (Stock stock : stocks) {
      System.out.println(stock.getName() + " - " + stock.getQty() + " shares at $" + stock.getPrice());
    }
  }

  public void printSellStock(ArrayList<Stock> stocks) {
    System.out.println("Available stocks to sell:");
    for (int i = 0; i < stocks.size(); i++) {
      Stock stock = stocks.get(i);
      System.out.printf("%d. %s (%s) - %d shares at $%.2f each\n",
          i + 1, stock.getName(), stock.getSymbol(), stock.getQty(), stock.getPrice());
    }
  }

} // class
