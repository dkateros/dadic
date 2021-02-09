package gr.dkateros.dadic.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Some utilities useful for debugging calculation contexts.
 * 
 * @author dkateros
 */
public class Debug {
	
	/**
	 * Pretty-prints a map alphabetically by key.
	 * 
	 * @param map
	 */
	public static void printMap(Map<String, ?> map) {
		if(map.isEmpty()) {
			System.out.println("{}");
		}
		int maxLine = 0;
		List<Entry<String, ?>> list = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.<Map.Entry<String, ?>>toList());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String prefix = " ";
			String suffix = "\n";
			if(i==0) {
				prefix = "{";
			}
			if(i==list.size()-1) {
				suffix = "}";
			}
			String line = prefix + list.get(i).getKey() + "=" + list.get(i).getValue() + suffix;
			maxLine = line.length() > maxLine ? line.length() : maxLine; 
			sb.append(line);
		}
		
		sb.append("\n");
		for(int i=0; i< maxLine-1; i++) {
			sb.append("-");
		}
		sb.append(">" + list.size());
		System.out.println(sb.toString());
	}

}
