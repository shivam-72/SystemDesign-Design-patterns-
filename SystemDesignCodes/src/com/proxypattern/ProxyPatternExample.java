package com.proxypattern;
interface Image{
	void display();
}
class RealImage implements Image{
   private String filename;
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("displayimage");
		
	}
	public RealImage(String filename){
		this.filename=filename;
		loadimagefromdisk();//heavy operations
	}
	private void loadimagefromdisk() {
		// TODO Auto-generated method stub
		System.out.println("loading iamge from disk");
	}
	
}
class ProxyImage implements Image{
	private String filename;
	private RealImage realImage;
	 public ProxyImage(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		if(realImage==null)
			realImage=new RealImage(filename);//image is loaded and cached as we are only loading one time if it is not loaded.
		realImage.display();
	}
	
}
public class ProxyPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       Image img1=new RealImage("file1");
//       Image img2=new RealImage("file1");
       //real image is loaded evrytime we create object
       //which can be inefficient as image is not required. 
		
		//this image is loaded lazily when needed,
		//saving time and resources if the image is never displayed.
		Image img1=new ProxyImage("first");
		//img2 is not loaded as we do not call display for that so no wastage of resource
		Image img2=new ProxyImage("first");
		img1.display();
		img1.display();
	}

}
