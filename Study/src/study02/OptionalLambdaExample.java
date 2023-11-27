package study02;

import java.util.Optional;

public class OptionalLambdaExample {
	public static void main(String[] args) {
		Optional<String> opt = Optional.of("Hello World");
		
		opt.ifPresent(v -> System.out.println("Value Exists : " + v));
		
		Optional<String> emptyOpt = Optional.empty();
        String result = emptyOpt.orElse("Default Value");
        
        System.out.println("Value is absent, Default Value : " + result);
	}
}
