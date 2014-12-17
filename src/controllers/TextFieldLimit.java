package controllers;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldLimit extends PlainDocument{

	private int limit;

	public TextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet set)throws BadLocationException
	{
		if (str==null){
			return;
		}else if((getLength() + str.length())<=limit)
		{
			if(getLength()==0){
				str=str.trim();
			}
			super.insertString(offset, str, set);
		}
	}

}
