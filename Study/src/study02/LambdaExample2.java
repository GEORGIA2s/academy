package study02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaExample2 {

	public static void main(String[] args) {
		
		Integer[] numbers = {1,2,3,4,5};
		
		int sumOperator = Arrays.stream(numbers)
				.map(n -> n*n)
				.reduce(0, Integer::sum);
		
		System.out.println(sumOperator);
		
		//=============================================
		
		List<String> words = Arrays.asList("Hello","Functional","Programming","World");
		String result = words.stream()
				.collect(joining(" "));
		
		System.out.println("RESULT : "+result);
		
		//=============================================
		
		ComplexFunction<Integer, Integer, Integer> cf = (a,b) -> a * a + b * b;
		
		int result2 = cf.apply(3, 4);
		
		System.out.println(result2);
		
		Function<Integer,String> af = r -> "result : " + r;
		
		ComplexFunction<Integer,Integer,String> cf2 = cf.andThen(af);
		
		String result3 = cf2.apply(3, 4);
		
		System.out.println(result3);
	}

	public static Collector<CharSequence, ?, String> joining(CharSequence delimeter){
		return Collectors.joining(delimeter);
	}
}

@FunctionalInterface
interface ComplexFunction<T, U, R>{
	R apply(T t, U u);
	
	default <V> ComplexFunction<T, U, V> andThen(Function<? super R, ? extends V> after){
		return (T t, U u) -> after.apply(apply(t,u));
	}
}
