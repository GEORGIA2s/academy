package study02;

@FunctionalInterface
interface MathOperator {
	int operate(int a, int b);
}

public class LambdaExample {

	public static void main(String[] args) {

		MathOperator addOperator = (a, b) -> a + b;

		MathOperator multiOperator = (a, b) -> a * b;

		System.out.println("10 + 5 = " + operate(10, 5, addOperator));
		System.out.println("10 * 5 = " + operate(10, 5, multiOperator));

	}

	private static int operate(int a, int b, MathOperator operation) {
		return operation.operate(a, b);
	}
}
