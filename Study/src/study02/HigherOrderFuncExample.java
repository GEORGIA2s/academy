package study02;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class HigherOrderFuncExample {
	public static void main(String[] args) {
		// 두 개의 함수를 합성하는 고차 함수
		IntUnaryOperator add = x -> x + 2;
		IntUnaryOperator multiply = x -> x * 3;
		
		IntUnaryOperator addAndMultiply = add.andThen(multiply);
		// 두 함수를 합성하여 새로운 함수 생성
		
		System.out.println("Result : " + addAndMultiply.applyAsInt(5));
		// (5 + 2) * 3 = 21
		
		Function<Integer, Function<Integer,Integer>> f = x-> y-> x+y;
		// 두 개의 인수를 받아 더하는 커링된 함수
		
		Function<Integer, IntUnaryOperator> fx = x-> y-> x*y;
		
		int result = f.apply(5).apply(10);
		// 커링된 함수 사용
		
		int result2 = fx.apply(10).applyAsInt(10);
		
		System.out.println("RESULT : " + result);
		System.out.println("RESULT2 : " + result2);
		// 결과 출력 5 + 10 = 15
		
		String[] words = {"Hello","Functional","Programming","World"};
		
		Arrays.stream(words)
				.filter(s -> s.length() > 5)
				.map(String::toUpperCase)
				.forEach(System.out::println);
	}
}