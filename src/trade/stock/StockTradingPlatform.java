package trade.stock;

import java.util.Scanner;

public class StockTradingPlatform {
    private Market market;
    private Portfolio portfolio;
    private Scanner scanner;

    public StockTradingPlatform() {
        market = new Market();
        portfolio = new Portfolio();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    market.printMarket();
                    break;
                case 2:
                    buyStock();
                    break;
                case 3:
                    sellStock();
                    break;
                case 4:
                    portfolio.printPortfolio();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void buyStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Stock stock = market.getStock(symbol);
        if (stock != null) {
            portfolio.buyStock(stock, quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getName());
        } else {
            System.out.println("Stock not found.");
        }
    }

    private void sellStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Stock stock = market.getStock(symbol);
        if (stock != null) {
            portfolio.sellStock(stock, quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getName());
        } else {
            System.out.println("Stock not found.");
        }
    }

    public static void main(String[] args) {
        StockTradingPlatform platform = new StockTradingPlatform();
        platform.start();
    }
}


