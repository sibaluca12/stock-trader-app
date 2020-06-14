package com.codecool.stockApp;

import sun.rmi.runtime.Log;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a command line interface for stock trading.
 **/
public class TradingApp {
	public static void main(String[] args) {
	    TradingApp app = new TradingApp();
	    app.start();
	}

	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a stock symbol (for example aapl):");
		String symbol = keyboard.nextLine();
		System.out.println("Enter the maximum price you are willing to pay: ");
		double price;
		Logger logger = new Logger();
		try {
			price = keyboard.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Enter a number");
			return;
		}

		try {
			Trader trader = new Trader();
			trader.setBid(price);
			trader.setSymbol(symbol);
			boolean purchased = trader.buy();

			if (purchased) {
//				Logger.getInstance().log();
				logger.setMessage("Purchased stock!");
			}
			else {
//				Logger.getInstance().log();
				logger.setMessage("Couldn't buy the stock at that price.");
			}
		} catch (Exception e) {
//			Logger.getInstance().log();
			logger.setMessage("There was an error while attempting to buy the stock: " + e.getMessage());

		}
		logger.log();
	}
}