package com.observerpattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
	void update(float temp);
}
interface Subject{
	void attach (Observer obs);
	void detach(Observer obs);
	void notifyObserver();
}
class WheatherStation implements Subject{
	private float temperature;
	private List<Observer>observerList;
	WheatherStation(){
		observerList=new ArrayList<>();
	}
	
	public void setTemperature(float temperature) {
		this.temperature=temperature;
		notifyObserver();
	}
	
	@Override
	public void attach(Observer obs) {
		// TODO Auto-generated method stub
		observerList.add(obs);
		
	}
    
	@Override
	public void detach(Observer obs) {
		// TODO Auto-generated method stub
		observerList.remove(obs);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer obj:observerList) {
			obj.update(temperature);
		}
	}
	
}
class DisplayDevice implements Observer{
    public float temparature;
    public String deviceName;
    DisplayDevice(String name){
    	deviceName=name;
    }
	@Override
	public void update(float temp) {
		// TODO Auto-generated method stub
		 temparature=temp;
		 System.out.println("updated temparature is "+temp+" for "+deviceName);
	}
	
}
class MobileDevice implements Observer{
	
	public float temparature;
	@Override
	public void update(float temp) {
		// TODO Auto-generated method stub
		 temparature=temp;
		 System.out.println("updated temparature is "+temp+" for Mobile");
	}
	
}
public class ObserverPatternExample {
    public static void main(String args[]) {
    	 WheatherStation ws=new  WheatherStation();
    	 MobileDevice md=new MobileDevice();
    	 DisplayDevice tv=new DisplayDevice("Tv");
    	 ws.attach(md);
    	 ws.attach(tv);
    	 ws.setTemperature(30);
    	 ws.detach(tv);
    	 ws.setTemperature(34);
    }
}
