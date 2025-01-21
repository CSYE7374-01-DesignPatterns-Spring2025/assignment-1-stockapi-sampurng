package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void showAllStocks() {
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }

    public void tradeStocks(String name, String bid) {
        for (Stock stock : stocks) {
            if(stock.getName().equals(name))
                stock.setBid(bid);
        }
    }

    public void removeStock(String name) {
        int index = -1;
        for (int i=0;i < stocks.size();i++) {
            if(stocks.get(i).getName().equals(name))
                index = i;
        }
        if(index!=-1)
            stocks.remove(index);
    }

    public void startTrading() {

        System.out.println("Trading starts  here");

        this.addStock(new MSFT("MSFT", 200, "Microsoft Stock"));
        this.addStock(new GOOG("GOOG", 150, "This is the stock for Google/Alphabet LLC", 150, 1));
        System.out.println("All  the stocks available in the stock market at the start");
        showAllStocks();

        tradeStocks("MSFT", "35");
        tradeStocks("GOOG", "145");
        System.out.println("\n\nCurrent status of the Stocks in the stock market after bid one");
        showAllStocks();
        tradeStocks("MSFT", "39");
        tradeStocks("GOOG", "129");
        System.out.println("\n\nCurrent status of the Stocks in the stock market after bid two");
        showAllStocks();
        tradeStocks("MSFT", "29");
        tradeStocks("GOOG", "159");
        System.out.println("\n\nCurrent status of the Stocks in the stock market after bid three");
        showAllStocks();
        tradeStocks("MSFT", "42");
        tradeStocks("GOOG", "167");
        System.out.println("\n\nCurrent status of the Stocks in the stock market after bid four");
        showAllStocks();
        tradeStocks("MSFT", "39");
        tradeStocks("GOOG", "170");
        System.out.println("\n\nCurrent status of the Stocks in the stock market after bid five");
        showAllStocks();
        tradeStocks("MSFT", "36");
        tradeStocks("GOOG", "150");
        System.out.println("\n\nCurrent status of the Stocks in the stock market after bid six");
        showAllStocks();
        showAllStocks();

        removeStock("MSFT");
        System.out.println("\n\nStocks available in the stock market after removing a stock");
        showAllStocks();
    }


}