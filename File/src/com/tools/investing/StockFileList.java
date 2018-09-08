package com.tools.investing;

import java.util.TreeMap;

public class StockFileList 
{
	protected TreeMap<Integer, String> stockFileList = new TreeMap<Integer, String>();
	
	protected StockFileList(){}
	
	protected StockFileList(TreeMap<Integer, String> stockFile)
	{
		stockFileList = stockFile;
	}
}
