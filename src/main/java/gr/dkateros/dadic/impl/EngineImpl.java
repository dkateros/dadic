package gr.dkateros.dadic.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gr.dkateros.dadic.Calculation;
import gr.dkateros.dadic.Engine;
import gr.dkateros.dadic.util.Reflections;
import gr.dkateros.dadic.util.Debug;

/**
 * {@link Engine} implementation.
 * 
 * @author dkateros
 */
public class EngineImpl implements Engine {
	
	Map<String, Object> dictionary;

	@Override
	public void plant(Map<String, Object> seed) {
		Debug.printMap(seed);
		dictionary = new HashMap<>();
		seed.forEach(this::expand);
		Debug.printMap(dictionary);
	}

	@Override
	public void perform(List<Calculation> calculations) {
		Collections.sort(calculations, Comparator.comparing(Calculation::priority));
		calculations.forEach(this::calculate);
	}

	@Override
	public Map<String, Object> reap() {
		dictionary.forEach(this::bind);
		return dictionary.entrySet().stream().filter(entry -> !entry.getKey().contains("."))
			.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
	}
	
	void expand(String key, Object value) {
		dictionary.put(key, value);
		dictionary.putAll(Reflections.dictionaryElementsOf(key, value));
	}
	
	void calculate(Calculation calculation) {
		Object result = calculation.perform(Collections.unmodifiableMap(dictionary));
		dictionary.put(calculation.id(), result);
	}
	
	void bind(String key, Object value) {
		if(key.contains(".")) {
			String[] keys = key.split("\\.");
			Reflections.set(dictionary.get(keys[0]), keys[1], value);
		}
	}

}
