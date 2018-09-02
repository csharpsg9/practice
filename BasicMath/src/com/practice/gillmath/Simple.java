package com.practice.gillmath;

public class Simple {
	
	private Integer add(int x, int y)
	{	return x + y;	}
	
	private Integer subtract(int x, int y)
	{	return x - y;	}
	
	private void getOSDetails()
	{
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("os.arch"));
	}

	public static void main(String[] args) {
		Simple numbers = new Simple();
		int number1 = 6, number2 = -3;
		
		System.out.println(numbers.add(number1, number2));
		System.out.println(numbers.subtract(number1, number2));
		numbers.getOSDetails();
	}

}
