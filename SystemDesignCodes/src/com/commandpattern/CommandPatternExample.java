package com.commandpattern;

interface Command{
	void execute();
}

class BoldCommand implements Command{
	TextEditor editor;
	public BoldCommand(TextEditor editor) {
		this.editor=editor;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editor.boldText();
	}
}

class ItalicCommand implements Command{
	TextEditor editor;
	public ItalicCommand(TextEditor editor) {
		this.editor=editor;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editor.italicText();
	}
}

class UnderlineCommand implements Command{
	TextEditor editor;
	public UnderlineCommand(TextEditor editor) {
		this.editor=editor;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editor.underlineText();
	}
}

class Button{
	Command command;
	public void setCommand(Command command){
		this.command=command;
	}
	public void onClick() {
		command.execute();
	}
}

class TextEditor{
	public void boldText(){
		System.out.println("Text is bold now");
	}
	public void italicText() {
		System.out.println("Text is italic now");
	}
	public void underlineText() {
		System.out.println("Text is underline now");
	}
}

public class CommandPatternExample {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  TextEditor editor=new TextEditor();
       Button button=new Button();
       button.setCommand(new UnderlineCommand(editor));
       button.onClick();
	}

}
