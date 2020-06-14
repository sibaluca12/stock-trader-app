package com.codecool.stockApp;

import java.io.IOException;

/**
 * Business logic for stock trading
 **/
public class Trader {
	private String symbol;
	private double bid;
	private static Trader instance;

	public static Trader getInstance() {
	    if (instance == null) {
	        instance = new Trader();
        }
        return instance;
    }

	private StockAPIService stockService;

	public Trader() {

		this.stockService = new StockAPIService();
    }

	/** Checks the price of a stock, and buys it if the price is not greater than the bid amount.
	 * 	@return whether any stock was bought */
	public boolean buy() throws IOException {
		stockService.setSymbol(this.symbol);
		double price = stockService.getPrice();

        boolean result;
        Logger logger = new Logger();
		if (price <= this.bid) {
			result = true;
			stockService.buy();

//			Logger.getInstance().log();
			logger.setMessage("Purchased " + this.symbol + " stock at $" + this.bid + ", since its higher that the current price ($" + price + ")");
		}
		else {
			logger.setMessage("Bid for " + this.symbol + " was $" + this.bid + " but the stock price is $" + price + ", no purchase was made.");
//            Logger.getInstance().log();
			result = false;
		}
		logger.log();
		return result;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}
}