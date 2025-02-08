package com.undopattern;

public class EditorMemento {
	  private final String content;
	  
  public EditorMemento(String content) {
		this.content = content;
	}
  
  public String getContext() {
	  return content;
  }

}
