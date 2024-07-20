package trade.stock;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<Stock, Integer> stocks;

    public Portfolio() {
        stocks = new HashMap<>();
    }

    public void buyStock(Stock stock, int quantity) {
        stocks.put(stock, stocks.getOrDefault(stock, 0) + quantity);
    }

    public void sellStock(Stock stock, int quantity) {
        if (stocks.containsKey(stock) && stocks.get(stock) >= quantity) {
            stocks.put(stock, stocks.get(stock) - quantity);
            if (stocks.get(stock) == 0) {
                stocks.remove(stock);
            }
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public void printPortfolio() {
        for (Map.Entry<Stock, Integer> entry : stocks.entrySet()) {
            System.out.println("Stock: " + entry.getKey().getSymbol() + " Quantity: " + entry.getValue());
        }
    }

    public double getTotalValue() {
        double total = 0;
        for (Map.Entry<Stock, Integer> entry : stocks.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}

