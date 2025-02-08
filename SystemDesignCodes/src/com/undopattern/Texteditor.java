package com.undopattern;

public class Texteditor {
  
   private String content;
   
   public void write(String text) {
	  this.content=text;
   }
   
   public String getContent() {
	   
	return content;  
	
   }
   public EditorMemento save() {
	   return new EditorMemento(content);
   }
   public void restore(EditorMemento memento) {
	   content=memento.getContext();
   }
}
