package objects;


public class InputString {

	private String inputText;
	private int maxSize; 
	private String variableType;
	public InputString(String inputText, int maxSize, String variableType) {
		super();
		this.inputText = inputText;
		this.maxSize = maxSize;
		this.variableType = variableType;
	}
	public String getInputText() {
		return inputText;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public String getVariableType() {
		return variableType;
	}
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}
	
	




	
}
