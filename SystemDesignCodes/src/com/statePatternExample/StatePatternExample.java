package com.statePatternExample;

interface TransportationMode{
	int calCETA();
	String getDirection();
}

class Car implements TransportationMode{

	@Override
	public int calCETA() {
		// TODO Auto-generated method stub
		System.out.println("car mode Eta");
		return 5;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		System.out.println("Direction for car");
		return "South";
	}
	
}
class Cycling implements TransportationMode{

	@Override
	public int calCETA() {
		// TODO Auto-generated method stub
		System.out.println("cycle mode Eta");
		return 10;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		System.out.println("Direction for cycle");
		return "North";
	}
	
}
class DirectionService{
	private TransportationMode mode;
	DirectionService(TransportationMode mode){
		this.mode=mode;
	}
	public void setTransportationMode(TransportationMode mode) {
		this.mode=mode;
	}
	public int getETA(){
		return mode.calCETA();
	}
	public String direction(){
		return mode.getDirection();
	}
	
}
public class StatePatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectionService directionService=new DirectionService(new Cycling());
		directionService.setTransportationMode(new Car());
		directionService.getETA();

	}

}
