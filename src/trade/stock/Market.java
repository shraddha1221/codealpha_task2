package trade.stock;

import java.util.HashMap;
import java.util.Map;

public class Market {
    private Map<String, Stock> stocks;

    public Market() {
        stocks = new HashMap<>();
        stocks.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.00));
        stocks.put("GOOG", new Stock("GOOG", "Alphabet Inc.", 2800.00));
        stocks.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3400.00));
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public void updateStockPrice(String symbol, double price) {
        if (stocks.containsKey(symbol)) {
            stocks.get(symbol).setPrice(price);
        }
    }

    public void printMarket() {
        for (Stock stock : stocks.values()) {
            System.out.println("Symbol: " + stock.getSymbol() + " Name: " + stock.getName() + " Price: $" + stock.getPrice());
        }
    }
}

