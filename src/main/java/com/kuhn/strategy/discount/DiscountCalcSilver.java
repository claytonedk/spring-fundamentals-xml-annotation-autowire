package com.kuhn.strategy.discount;

public class DiscountCalcSilver implements DiscountCalc {

	@Override
	public double calculateDiscount(double totalValue) {
		return totalValue * 0.05f;
	}

}
