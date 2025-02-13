package com.prototype;

import java.util.ArrayList;
import java.util.List;

interface ProtoType<T>{
	T cloneobj();
}
class GamePeice implements ProtoType<GamePeice>{
	
	private String color;
	private int position;
	
	public GamePeice(String color,int position){
		this.color=color;
		this.position=position;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "GamePeice [color=" + color + ", position=" + position + "]";
	}
	@Override
	public GamePeice cloneobj() {
		// TODO Auto-generated method stub
		return new GamePeice(this.color,this.position);
	}
	
}
class GameBoard implements ProtoType<GameBoard>{
	private List<GamePeice> peices=new ArrayList<>();
	public void addGamePeice(GamePeice peice){
		peices.add(peice);
	}
	public List<GamePeice> getPeices() {
		return peices;
	}
	public void setPeices(List<GamePeice> peices) {
		this.peices = peices;
	}
	public void showboardState() {
		for(GamePeice peice:peices) {
			System.out.println(peice);
		}
	}
	@Override
	public String toString() {
		return "GameBoard [peices=" + peices + "]";
	}
	@Override
	public GameBoard cloneobj() {
		// TODO Auto-generated method stub
		GameBoard gameBoard=new GameBoard();
		for(GamePeice peice:peices) {
			gameBoard.addGamePeice(peice.cloneobj());
		}
		
		return gameBoard;
	}
	
}
public class ProtoTypeExample {
     public static void main(String args[]) {
    	 //by this pattern we are making copy in the  class and decoupled from client class ensuring each element knows
    	 //how to clone itself making system flexible and easy to maintain
    	 GameBoard gameBoard1=new GameBoard(); 
    	 gameBoard1.addGamePeice(new GamePeice("blue",3));
    	 gameBoard1.addGamePeice(new GamePeice("red",2));
    	 gameBoard1.addGamePeice(new GamePeice("green",5));
    	 System.out.println("original");
    	 gameBoard1.showboardState();
    	 System.out.println("copied");
    	 GameBoard copyBoard=gameBoard1.cloneobj();
    	 copyBoard.showboardState();
     }
}
