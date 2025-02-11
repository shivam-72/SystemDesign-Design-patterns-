package com.factorypattern;

//now this factory is used to create create class so we do need to change the client code when class name is changed 
//will follow open closed principle 
class TransportFactory {

	public static Transport createTransport(String type) {
		switch (type.toLowerCase()) {
		case "car":
			return new Car();
		case "bus":
			return new Bus();
		case "bike":
			return new Bike();
		default:
			throw new IllegalArgumentException("Unsupported transport");
		}
	}

}

interface Transport {
	void deliver(); // Abstract method to be implemented by classes
}

class Car implements Transport {

	@Override
	public void deliver() {
		System.out.println("Car is delivering goods.");
	}
}

class Bike implements Transport {

	@Override
	public void deliver() {
		System.out.println("Bike is delivering goods.");
	}
}

class Bus implements Transport {

	@Override
	public void deliver() {
		System.out.println("Bus is delivering goods.");
	}
}

public class factoryPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transport transport = TransportFactory.createTransport("car");
		transport.deliver();
	}

}
