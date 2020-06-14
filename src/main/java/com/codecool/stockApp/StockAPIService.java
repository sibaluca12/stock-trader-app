package com.codecool.stockApp;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Stock price service that gets prices from Yahoo.
 **/
public class StockAPIService {
	private String symbol;

	private static final String apiPath = "https://financialmodelingprep.com/api/v3/stock/real-time-price/%s";
	
	/** Get stock price from iex and return as a double
//     *  @param symbol Stock symbol, for example "aapl"
     **/
	public double getPrice() throws IOException {
        String url = String.format(apiPath, this.symbol);
        RemoteURLReader remoteURLReader = new RemoteURLReader();
        remoteURLReader.setEndpoint(url);
        String result = remoteURLReader.readFromUrl();
        JSONObject json = new JSONObject(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);
	}
	
	/** Buys a share of the given stock at the current price. Returns false if the purchase fails */
	public boolean buy() {
		// Stub. No need to implement this.
		return true;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}