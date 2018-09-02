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
	}

	public static void main(String[] args) {
		Simple numbers = new Simple();
		int number1 = -5, number2 = 22;
		
		System.out.println(numbers.add(number1, number2));
		System.out.println(numbers.subtract(number1, number2));
		numbers.getOSDetails();
	}

}
