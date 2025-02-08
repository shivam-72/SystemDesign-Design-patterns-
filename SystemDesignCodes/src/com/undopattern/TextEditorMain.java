package com.undopattern;

public class TextEditorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Texteditor editor=new Texteditor();
     HistoryCareTaker careTaker=new HistoryCareTaker();
     editor.write("Hello All");
     careTaker.saveState(editor);
     editor.write("Hello Everyone");
     careTaker.saveState(editor);
     careTaker.undo(editor);
     System.out.println(editor.getContent());
	}

}
