package gr.dkateros.dadic;

import java.util.List;
import java.util.Map;

/**
 * An Object that creates a context based on an initial list of objects, performs the defined 
 * calculations and binds the results back to these objects or returns them simply as results
 * that are associated with a name.
 * 
 * @author dkateros
 */
public interface Engine {
	
	/**
	 * Accepts an initial list of objects and inspects them for fields annotated
	 * with {@link DictionaryElement} so that an initial calculation context can
	 * be created.
	 * 
	 * @param seed
	 */
	void plant(Map<String, Object> seed);
	
	/**
	 * Performs an ordered list of calculations based on the existing context. Each
	 * calculation's result is added to the context with the calculations identifier
	 * replacing the existing value if applicable.
	 * 
	 * @param calculations
	 */
	void perform(List<Calculation> calculations);
	
	/**
	 * Binds the context values to the object fields that are annotated with
	 * {@link DictionaryElement} so that they now reflect the results of all
	 * the calculations.
	 * 
	 * @return Returns the calculation
	 */
	Map<String, Object> reap();

}
