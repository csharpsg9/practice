package com.tools.webutils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scraper {

	public static Stock getStockPrice(String symbol)
	{
		Stock stockInformation = new Stock();
		String stockPrice = "";
		
		try{
			Document document = Jsoup.connect("https://www.tdameritrade.com/search/results.page?q=" + symbol).timeout(6000).get();
			Elements htmlElement = document.select("div#1523666861761");
		
			for(Element element : htmlElement){
				stockPrice = element.select("span.current-stock-price").text();
				stockPrice = stockPrice.substring(1, stockPrice.length());
			}
		} catch(Exception e){	
			e.printStackTrace();
		}
		
		stockInformation.stockSymbol = symbol;
		stockInformation.price = Double.parseDouble(stockPrice);
		
		return stockInformation;
	}
}
