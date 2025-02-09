package com.mementopattern;

import java.util.Stack;

public class HistoryCareTaker {
       private final Stack<EditorMemento>history=new Stack<>();
       public void saveState(Texteditor editor) {
    	  history.push(editor.save());
       }
       public void undo(Texteditor editor) {
    	   if(!history.isEmpty()) {
    		   history.pop();
    		   if(history.size()>=1)
    		   editor.restore(history.peek());
    	   }
    	   
       }
       
}
