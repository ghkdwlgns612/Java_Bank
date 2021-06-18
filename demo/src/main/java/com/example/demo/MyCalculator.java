package com.example.demo;

public class MyCalculator {
	private Calculator calculator;
	private int a;
	private int b;
	
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public int add() {
		return calculator.plus(a, b);
	}
	
	public int sub() {
		return calculator.minus(a, b);
	}
}