package com.example.jamesreilly.simplecalc;
/**
 * Parse Function
 * 
 * @author jmr8893 James Reilly
 */
public class Parse extends Object {

	/**
	 * @param args
	 */
	private static int index;

	/**
	 * parseString takes in a prefix Expression and returns the parent node of
	 * the the tree.
	 * 
	 * @param s
	 *            The given prefix String
	 * @return The output of the recursive method parseHelper
	 */
	public static Expression parseString(String s) {
		String[] prefix = s.split("\\s+");
		index = 0;
		return parseHelper(prefix);
	}

	/**
	 * parseHelper recursively creates a tree from a prefix expression
	 * 
	 * @param prefix the given prefix expression as an array
	 *            
	 * @return the parent node of the created tree
	 */
	private static Expression parseHelper(String[] prefix) {
		String current = prefix[index];
		index++;

		if (current.equals("+")) {
			Expression left = parseHelper(prefix);
			Expression right = parseHelper(prefix);
			return new AddExpression(left, right);
		}

		if (current.equals("-")) {
			Expression left = parseHelper(prefix);
			Expression right = parseHelper(prefix);
			return new SubExpression(left, right);
		}
		if (current.equals("*")) {
            Expression left = parseHelper(prefix);
            Expression right = parseHelper(prefix);
            return new MulExpression(left, right);
        }
        if (current.equals("/")){
            Expression left = parseHelper(prefix);
            Expression right = parseHelper(prefix);
            return new DivExpression(left,right);

		} else {
			return new IntExpression(current);
		}

	}

}
