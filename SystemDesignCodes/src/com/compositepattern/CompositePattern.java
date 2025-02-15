package com.compositepattern;

import java.util.ArrayList;
import java.util.List;

//with composite pattern we can hold a list of both file and folder both in list of folder because folder can contain both
interface FileSystemComponent{
	void showDetails();
	
}
//without composite pattern 
//class File{
//	private String name;
//	public File(String name){
//		this.name=name;
//	}
//	public void showDetails() 
//	{
//		System.out.println("file name: " + name);
//	}
//}
//class Folder{
//	private String name;
//	private List<File> files=new ArrayList<>();
//	public Folder(String name){
//		this.name=name;
//	}
//	void showDetails() 
//	{
//		for(File file:files) {
//		 file.showDetails();
//		}
//	}
//}

//with composite pattern 
class File implements FileSystemComponent{
	private String name;
	public File(String name){
		this.name=name;
	}
	public void showDetails() 
	{
		System.out.println("file name: " + name);
	}
}
class Folder implements FileSystemComponent{
	private String name;
	//here we are creating a list of filesystem so i can hold both file and folder in the list
	private List<FileSystemComponent> components=new ArrayList<>();
	public Folder(String name){
		this.name=name;
	}
	public void showDetails() 
	{
		System.out.println("file for folder: "+name);
		for(FileSystemComponent component:components) {
			component.showDetails();
		}
	}
	public void addComponent(FileSystemComponent component) {
		components.add(component);
	}
}
public class CompositePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileSystemComponent file1=new File("file1.txt");
		FileSystemComponent file2=new File("file2.txt");
		
		Folder folder=new Folder("folder1");
		Folder subfolder=new Folder("folder2");
		folder.addComponent(subfolder);
		folder.addComponent(file1);
		folder.addComponent(file2);
		
		folder.showDetails();
	}

}
