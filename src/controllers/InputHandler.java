package controllers;

import javax.swing.JOptionPane;

public class InputHandler {

	
	public boolean checkIFSSN(String SSN){
		
		boolean isSSNValid = false;
		
		if(SSN.length()==12){
			isSSNValid=true;
		}
		
		
		
		
		if(isSSNValid==false){
		JOptionPane.showMessageDialog(null,
				"SSN must be on form yyyymmddnnnn",
				"User not added", JOptionPane.ERROR_MESSAGE);
		}
		return isSSNValid;
	}
	
}
