package com.example.jamesreilly.simplecalc;
/**
 * Multiply Expression
 * 
 * @author jmr8893 James Reilly
 */
public class MulExpression implements Expression {

	/** Holds the Expression exp1 */
	private Expression myExp1;
	/** Holds the Expression exp2 */
	private Expression myExp2;

	/**
	 * Initializes the private variables with the given Expressions
	 * 
	 * @param exp1 the left node of the tree
	 * 
	 * @param exp2 the right node of the tree
	 * 
	 */
	public MulExpression(Expression exp1, Expression exp2) {
		myExp1 = exp1;
		myExp2 = exp2;

	}

	/**
	 * Multiplies the given expressions
	 * 
	 * @return The evaluated function
	 */
	@Override
	public Integer evaluate() {
		// TODO Auto-generated method stub
		return myExp1.evaluate() * myExp2.evaluate();
	}

	/**
	 * Creates a string that shows the infix expression
	 * 
	 * @return A string that represents the left exp being multiplies by the
	 *         right exp
	 */
	@Override
	public String emit() {
		// TODO Auto-generated method stub
		return "(" + myExp1.emit() + " * " + myExp2.emit() + ")";
	}

}
