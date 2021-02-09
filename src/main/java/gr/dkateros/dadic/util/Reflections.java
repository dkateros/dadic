package gr.dkateros.dadic.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gr.dkateros.dadic.DictionaryElement;
import gr.dkateros.dadic.Engine;

/**
 * Some class inspection and reflection related methods required for the implementation
 * of an {@link Engine}. 
 * 
 * @author dkateros
 */
public class Reflections {
	
	public static void set(Object o, String name, Object value) {
		try {
			Field field = o.getClass().getDeclaredField(name);
			field.setAccessible(true);
			field.set(o, value);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Map<String, Object> dictionaryElementsOf(String name, Object o) {
		Map<String, Object> fields = new HashMap<>();
		List<Field> annotatedFields = annotatedFields(o.getClass(), DictionaryElement.class);
		annotatedFields.forEach(f -> {
			try {
				f.setAccessible(true);
				fields.put(name + "." + f.getName(), f.get(o));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		});
		return fields;
	}
	
	static List<Field> annotatedFields(Class<?> type, Class<? extends Annotation> annotation) {
		return annotatedFields(type, annotation, new ArrayList<>());
	}
	
	static List<Field> annotatedFields(Class<?> type, Class<? extends Annotation> annotation, List<Field> acc) {
		List<Field> annotatedFields = Arrays.asList(type.getDeclaredFields()).stream().filter(f -> f.isAnnotationPresent(annotation)).collect(Collectors.toList());
		acc.addAll(annotatedFields);
		if(type.getSuperclass() != Object.class) {
			annotatedFields(type.getSuperclass(), annotation, acc);
		}
		return acc;
	}

}
