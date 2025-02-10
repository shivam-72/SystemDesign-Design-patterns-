package com.TemplateMethod;

abstract class Dataparser{
	void parse() {
		openFile();
		parseFile();
		closeFile();
	}

	protected abstract void parseFile();

	protected void openFile() {
		// TODO Auto-generated method stub
		System.out.println("file is openend");
		
	}

	protected void closeFile() {
		// TODO Auto-generated method stub
		System.out.println("file is closed");
	}

	
}
class CSVParser extends Dataparser{

	@Override
	protected void parseFile() {
		// TODO Auto-generated method stub
		System.out.println("parsing csv");
		
	}
	
}
class JSONParser extends Dataparser{

	@Override
	protected void parseFile() {
		// TODO Auto-generated method stub
		System.out.println("parsing Json");
	}
	
}

public class TemplateMethodExample {
   public static void main(String args[]) {
	   Dataparser csvparser=new CSVParser();
	   Dataparser jsonparser=new JSONParser();
	   jsonparser.parse();
	   csvparser.parse();
	   
   }
}
