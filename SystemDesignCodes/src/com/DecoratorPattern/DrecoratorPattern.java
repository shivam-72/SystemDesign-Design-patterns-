package com.DecoratorPattern;
interface Pizza{
	String getDescription();
	int getCost();
}
class BasicPizza implements Pizza{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "basic pizza";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 100;
	}
	
}
//without decorator pattern there will be class explosion and no scalibility
//class Cheezepizaa extends BasicPizza{
//
//	@Override
//	public String getDescription() {
//		// TODO Auto-generated method stub
//		return super.getDescription()+"cheese";
//	}
//
//	@Override
//	public int getCost() {
//		// TODO Auto-generated method stub
//		return super.getCost()+100;
//	}
//	
//}
//class MushroomPizza extends BasicPizza{
//
//	@Override
//	public String getDescription() {
//		// TODO Auto-generated method stub
//		return super.getDescription()+"mushroom";
//	}
//
//	@Override
//	public int getCost() {
//		// TODO Auto-generated method stub
//		return super.getCost()+50;
//	}
//	
//}

//with decorated pattern
abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza decoratedPizza) {
    	this.decoratedPizza=decoratedPizza;
    }
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDescription();
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost();
	}
	
}
class CheeseDecorater extends PizzaDecorator{

	public CheeseDecorater(Pizza decoratedPizza) {
		super(decoratedPizza);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDescription()+" cheese ";
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost()+50;
	}
	
}
class MushroomDecorater extends PizzaDecorator{

	public MushroomDecorater(Pizza decoratedPizza) {
		super(decoratedPizza);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDescription()+" Mushroom ";
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost()+50;
	}
	
}
class PannerDecorater extends PizzaDecorator{

	public PannerDecorater (Pizza decoratedPizza) {
		super(decoratedPizza);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDescription()+" panner ";
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost()+50;
	}
	
}
//pizza app
//follows
//open closed principle because pizza is open for extensions as we are able to add topings
//single responsibility principle because we can add toppings asthey all have only one responsibility like adding cheese only
//or mushroom only
public class DrecoratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Pizza pizza=new BasicPizza();
      pizza=new CheeseDecorater(pizza);
      pizza=new PannerDecorater(pizza);
      pizza=new MushroomDecorater(pizza);
      //panner_mushroom_cheese pizza is created and we can add as many topings.
      System.out.println(pizza.getDescription());
	}

}
