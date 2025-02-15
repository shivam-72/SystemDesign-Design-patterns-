package com.flyweightpattern;

import java.util.HashMap;

//here we have separated bullet common properties like when we build a game and in game we want a 1000 object of bullet 
//while creating 1000 object it will take as lot of memory so we can separate intrinsic properties(common properties like
//color and shape ) that will be same for all the object and we can create one object for common projection point to common
//properties for thie we need bullettype object inside bullet.
class Bullet {
    private int x;//extrinsic property
    private int y;//extrinsic property
    private int velocity;//extrinsic property
    //intrinsic properties that is common for all object so we can move out and create a separate class and define properties
    //there  and save memory
//    private String shape;
//    private String image;
    private BulletType bulletType ;

    // Constructor
    public Bullet(int x, int y,int velocity,String color,String shape) {
        this.x = x;
        this.y = y;
        this.velocity=velocity;
        this.bulletType=BulletTypeFactory.getBulletType(color,shape);
    }

    // Setter for coordinates
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter for coordinates
    public int[] getCoordinates() {
        return new int[] { x, y };
    }
}

class BulletType {
    private String shape;
    private String image;

    // Constructor
    public BulletType(String shape, String image) {
        this.shape = shape;
        this.image = image;
    }

    // Setter for shape
    public void setShape(String shape) {
        this.shape = shape;
    }

    // Getter for shape
    public String getShape() {
        return this.shape;
    }

    // Setter for image
    public void setImage(String image) {
        this.image = image;
    }

    // Getter for image
    public String getImage() {
        return this.image;
    }
}

class BulletTypeFactory{
	private static final HashMap<String,BulletType> bulletTypes=new HashMap<>();

	public static HashMap<String, BulletType> getBullettypes() {
		return bulletTypes;
	}
	//so BulletType Object will only created once
	public static BulletType getBulletType(String image,String shape) {
		if(!bulletTypes.containsKey(shape)) {
			bulletTypes.put(shape,new BulletType(shape,image) );
		}
		return bulletTypes.get(shape);
	}
	
}

public class FlyWeightPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			Bullet bullet=new Bullet(i*10,i+1,30,"round","img");
		}
		System.out.println("here bullet type is only created once for a particular bullet");

	}

}
