package com.builderpattern;
class House {
    // Declare instance variables
	private String address="near company";
    private int numBedrooms;
    private int numBathrooms;
    private double squareFeet;
    private double price=50000;

    //we will make this private so we can only call in this class with housebuilder
    private House(HouseBuilder houseBuilder) {
		// TODO Auto-generated constructor stub
    	address=houseBuilder.address;
    	numBedrooms=houseBuilder.numBedrooms;
    	numBathrooms=houseBuilder.numBathrooms;
    	squareFeet=houseBuilder.squareFeet;
    	price=houseBuilder.price;
	}

	// Getters and Setters for each field
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(double squareFeet) {
        this.squareFeet = squareFeet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to display house details
    public void displayDetails() {
        System.out.println("House Address: " + address);
        System.out.println("Number of Bedrooms: " + numBedrooms);
        System.out.println("Number of Bathrooms: " + numBathrooms);
        System.out.println("Square Feet: " + squareFeet);
        System.out.println("Price: $" + price);
    }
    public static class HouseBuilder{
    	private String address="near company";
        private int numBedrooms;
        private int numBathrooms;
        private double squareFeet;
        private double price=50000;
        //address and price are optional;
        HouseBuilder(int numBedrooms,int numBathrooms,double squareFeet){
        	this.numBedrooms=numBedrooms;
        	this.numBathrooms=numBathrooms;
        	this.squareFeet=squareFeet;
        }
        //we can now define methods for optional parameters for less complex structure of constructor and also we can 
        //set values in any order.
        public HouseBuilder setPrice(double price){
        	this.price=price;
        	return this;
        }
        public HouseBuilder Setaddress(String address){
        	this.address=address;
        	return this;
        }
        public House build() {
        	return new House(this);
        }
    }
}
public class BuilderPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       House house1=new House.HouseBuilder(5, 1, 200).setPrice(1000000).Setaddress("place").build();
       //here we will not set address still it will work
       House house2=new House.HouseBuilder(5, 1, 200).setPrice(1000000).build();
       System.out.println(house1.getAddress());
       System.out.println(house2.getAddress());
	}

}
