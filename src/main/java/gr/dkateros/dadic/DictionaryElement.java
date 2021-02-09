package gr.dkateros.dadic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A class field can participate in the dictionary. If that is the case,
 * the field must be marked with this annotation.
 * 
 * @author dkateros
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DictionaryElement {
}
