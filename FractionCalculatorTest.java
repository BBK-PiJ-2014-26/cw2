public class FractionCalculatorTest {

	public static void main(String[] args) {

		// Tests simple addition
		String s = "1/2 + 1/4";
		Fraction f = new Fraction(3,4);
		FractionCalculator test1 = new FractionCalculator();
		test1.evaluate(f, s);

		// Tests addition using whole numbers
		s = "1 + 1/4";
		f = new Fraction(5, 4);
		test1.evaluate(f, s);

		// Tests subtraction
		s = "6/4 - 1/4";
		test1.evaluate(f, s);

		// Tests multiply
		s = "6/4 * 1/4";
		f = new Fraction(6, 16);
		test1.evaluate(f, s);

		// Tests divide
		s = "6/4 / 2/3";
		f = new Fraction(9, 4);
		test1.evaluate(f, s);

		//Tests absValue
		s = "-9/3 A";
		f = new Fraction(9, 3);
		test1.evaluate(f, s);

		//Tests negate
		s = "-9/3 N";
		test1.evaluate(f, s);

		//Test clear
		s = "1/4 C 1/2";
		f = new Fraction(1, 2);
		test1.evaluate(f, s);

		//Test quit
		s = "1/4 q 3/4 + 1/3";
		f = new Fraction(1, 4);
		test1.evaluate(f, s);
	} 

}