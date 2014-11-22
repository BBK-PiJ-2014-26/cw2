/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // extend with extra tests

	// Tests add function
	Fraction q = new Fraction(3, 5);
	Fraction w = new Fraction(4, 15);
	Fraction e = new Fraction(1, 3);
	if (!q.equals(w.add(e))) System.out.println("Add failed");

	// Tests subtract function
	Fraction r = new Fraction(-1, 15);
	if (!r.equals(w.subtract(e))) System.out.println("Subtract failed");

	// Tests absValue function
	Fraction p = new Fraction(1, 15);
	if (!p.equals(r.absValue())) System.out.println("Absolute Value failed");
	
	// Tests divide function
	Fraction v = new Fraction(5, 6);
	if (!v.equals(g.divide(h))) System.out.println("Divide Value failed");

    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
