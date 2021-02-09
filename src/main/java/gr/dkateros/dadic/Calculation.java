package gr.dkateros.dadic;

import java.util.Map;

/**
 * Calculates a value based on the existing calculation context.
 * 
 * There are several strategies to implement this. The most straightforward one
 * is to implement it with code. This strategy should be used on overly complicated
 * calculations or calculations that require integration with external systems.
 * 
 * More interesting implementations may refer to lookups of stored tabular values 
 * or implementations that allow applying pre-defined formulas.
 * 
 * @author dkateros
 */
public interface Calculation {
	
	/**
	 * A calculation may be a byproduct or may refer to a dictionary element. A byproduct's 
	 * identifier is always a top level dictionary element, i.e. it never contains a '.'. 
	 * A calculation that refers to a dictionary element on the other hand has an id that is 
	 * constructed as the concatenation of the name of the object that owns the element, a '.'
	 * and the name of the field that holds the value of the dictionary element.
	 * 
	 * @return The calculation identifier.
	 */
	String id();
	
	/**
	 * The calculation order likely affects the result, so we need to be able to define
	 * the order explicitly.
	 * 
	 * @return The priority of the calculation.
	 */
	int priority();
	
	/**
	 * Performs the calculation given the available context.
	 * 
	 * @param context
	 *        The context of the calculation so far. Immutable.
	 * 
	 * @return The calculated value.
	 */
	Object perform(Map<String, Object> context);
	
	/**
	 * The calculation may depend on additional data. 
	 *  
	 * @return Returns a provider of additional data that back this calculation.
	 */
	DataProvider dataProvider();
	
}
