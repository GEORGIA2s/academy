package study02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String[] args) {
		
		List<String> languages = new ArrayList<>(Arrays.asList("JAVA","PYTHON","JAVASCRIPT","C#","RUBY"));
		
		languages.stream()
				.filter(s -> s.length() >= 4)
				.forEach(System.out::println);
		
		languages = Stream.of("JAVA","PYTHON","JAVASCRIPT","C#","RUBY")
				.collect(Collectors.toList());
		
		languages.forEach(System.out::println);
	}

}
