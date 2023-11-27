package study02;

import java.util.Arrays;

public class ParallelStreamExample {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		int sum = Arrays.stream(numbers)
		.parallel()
		.map(n -> n*n)
		.sum();
		
		System.out.println(sum);
	}

}
