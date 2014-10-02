package com.example.jamesreilly.simplecalc;
/**
 * Integer Expression
 * 
 * @author jmr8893 James Reilly
 */
public class IntExpression implements Expression{

	/** Holds the String valString*/
	private Integer myVal;
	
	public IntExpression(String valString){
		myVal = new Integer(valString);
		
	}
	/**  @return The given Integer */
	@Override
	public Integer evaluate() {
		// TODO Auto-generated method stub
		return myVal;
	}

	/**  @return A String that represents the given Integer */
	@Override
	public String emit() {
		return myVal.toString();
	}

}
