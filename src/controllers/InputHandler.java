package controllers;

import javax.swing.JOptionPane;

public class InputHandler {

	
	public boolean checkIFSSN(String SSN){
		
		boolean isSSNValid = false;
		String input = SSN;
		String messege="SSN must be on form: yyyymmddnnnn";
		
		if(SSN.length()==12){
			
			String year = input.substring(0, 4);
			String month = input.substring(4, 6);
			String day = input.substring(6, 8);
			String number = input.substring(8, 12);
			
			if((Integer.parseInt(year)<2015) & (Integer.parseInt(year)>1900)){
				if((Integer.parseInt(month)<13) & (Integer.parseInt(month)>0)){
					if((Integer.parseInt(day)<32) & (Integer.parseInt(day)>0)){
						isSSNValid=true;
					}else{messege="SSN, day not valid";}
				}else{messege="SSN, month not valid";}
			}else{messege="SSN, year not valid";}
			
			
		}
		

		if(isSSNValid==false){
		JOptionPane.showMessageDialog(null,
				messege,
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
	
	public boolean checkIFTime(String pn){
		String input = pn;
		String messege="start/stop must be on form: hhmm";
		boolean isValid = false;
		
		if(pn.length()==4){
			String hour = input.substring(0, 2);
			String min = input.substring(2, 4);
			
			if((Integer.parseInt(hour)<25) & (Integer.parseInt(hour)>0)){
				if((Integer.parseInt(min)<61) & (Integer.parseInt(min)>0)){
					isValid=true;
				}else{messege="start/stop, min not valid (hhmm)";}
			}else{messege="start/stop, hour not valid (hhmm)";}
			
			
		}
		

		if(isValid==false){
		JOptionPane.showMessageDialog(null,
				messege,
				"User not added", JOptionPane.ERROR_MESSAGE);
		}
		return isValid;
	}
	
}
