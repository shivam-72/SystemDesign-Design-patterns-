package com.StrategyPattern;

interface PaymentStrategy{
	void processpayment();
}

class DebitCard implements PaymentStrategy{


	@Override
	public void processpayment() {
		// TODO Auto-generated method stub
		System.out.println("payment via debitcard");
	}
	
	
}

class CreditCard implements PaymentStrategy{


	@Override
	public void processpayment() {
		// TODO Auto-generated method stub
		System.out.println("payment via creditcard");
	}
	
	
}

class UPI implements PaymentStrategy{


	@Override
	public void processpayment() {
		// TODO Auto-generated method stub
		System.out.println("payment via upi");
	}
	
	
}

class PaymentService{
	private PaymentStrategy strategy;
	void setPaymentService(PaymentStrategy strategy){
		 this.strategy=strategy;
	 }
	void pay() {
		strategy.processpayment();
	}
}

public class StrategyPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentService ps=new PaymentService();
		ps.setPaymentService(new UPI());
		ps.pay();
		ps.setPaymentService(new CreditCard());
		ps.pay();
	}

}
