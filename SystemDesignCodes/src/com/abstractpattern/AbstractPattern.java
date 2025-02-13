package com.abstractpattern;

interface Button {
	void render();
}
interface Scrollbar{
	void scroll();
}
class WindowsButton implements Button{
	public void render() {
      System.out.println("window render");
	}
}

class WindowsScrollbar implements Scrollbar{
	public void scroll() {
		 System.out.println("window scroll");
	}
}
class MacOsButton implements Button{
	public void render() {
      System.out.println("window render");
	}
}

class MacOsScrollbar implements Scrollbar{
	public void scroll() {
		 System.out.println("window scroll");
	}
}
interface UiFactory{
	Button createButton();
	Scrollbar createscrollbar();
}

class WindowFactory implements UiFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WindowsButton();
	}

	@Override
	public Scrollbar createscrollbar() {
		// TODO Auto-generated method stub
		return new WindowsScrollbar();
	}
	
}
class MacokFactory implements UiFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new MacOsButton();
	}

	@Override
	public Scrollbar createscrollbar() {
		// TODO Auto-generated method stub
		return new MacOsScrollbar();
	}
	
}
//here queston is we can render specific ui like mac or windows without concrete logic.
//this class is app where we want to load for specific os
public class AbstractPattern {
    private Button button;
    private Scrollbar scrollbar;
    AbstractPattern(UiFactory factory){
    	this.button=factory.createButton();
    	this.scrollbar=factory.createscrollbar();
    }
    public void renderUi(){
    	button.render();
    	scrollbar.scroll();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       UiFactory factory=new WindowFactory();
       AbstractPattern app=new AbstractPattern(factory);
       app.renderUi();
	}

}
