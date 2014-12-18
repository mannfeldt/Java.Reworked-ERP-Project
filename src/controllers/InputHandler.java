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
	
	
	public boolean checkIFProjectNumber(String pn){
		
		boolean isValid = false;
		
		if(pn.length()>0){
			isValid=true;
		}
		

		if(isValid==false){
		JOptionPane.showMessageDialog(null,
				"Projectnumber must be defined",
				"User not added", JOptionPane.ERROR_MESSAGE);
		}
		return isValid;
	}
	
}
