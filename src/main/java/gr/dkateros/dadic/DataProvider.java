package gr.dkateros.dadic;

/**
 * This type is designed to reduce the coupling between a {@link Calculation} and
 * provisioning of data it may depend on.
 * 
 * @author dkateros
 */
public interface DataProvider {
	
	/**
	 * @param id
	 *        {@link Calculation} identifier.
	 *        
	 * @return Returns the additional data a {@link Calculation} depends on. The actual
	 *         return type depends on the {@link Calculation} implementation.
	 */
	Object data(String id);

}
