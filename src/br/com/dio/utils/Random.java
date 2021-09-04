package br.com.dio.utils;

public abstract class Random {
	
	public static int getRandomValueBetween(int min, int max) {
		final double constant = Math.random();
		
		final int result  = (int)(constant * (max - min) + min);
		
		return result;
	}

}
