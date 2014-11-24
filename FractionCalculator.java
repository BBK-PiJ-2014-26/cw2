import java.util.Scanner;

public class FractionCalculator {
	
	private Fraction f1;
	private Fraction f2; 
	private boolean operatorPresent;
	private boolean add;
	private boolean subtract;
	private boolean divide;
	private boolean multiply;
	private	Scanner input;

	public FractionCalculator(Scanner input) {
		this.input = new Scanner(input);
		this.operatorPresent = false;
		this.add = false;
		this.subtract = false;
		this.divide = false;
		this.multiply = false;
		this.f1 = null;
		this.f2 = null;
	}

	public Fraction launch(Scanner input) {
		System.out.println("0");
		this.operatorPresent = false;
		this.add = false;
		this.subtract = false;
		this.divide = false;
		this.multiply = false;
		this.f1 = null;
		this.f2 = null;
		do {
			String s = input.next();
			if (f1 == null) {
				this.setF1(s);
			} else if (!operatorPresent) {
				this.setOperator(s);
			} else {
				this.setF2(s);
			}

		} while (input.hasNext());
		return this.f1;
	}

	public void error() {
		System.out.println("0");
		System.out.println("Invalid input, please try again.");
		this.input = new Scanner(" ");
	}

	public void setF1(String s) {		
		int sLength = s.length();
		int count = 0;
		int slashPos = 0;
		boolean slashPresent = false;
		for (count = 0; count < sLength; count++) {
			char slash = s.charAt(count);
			if (slash == ('/')) {
				slashPos = count;
				slashPresent = true;
			}
		}
		if (slashPresent) {
			String temp = s.substring(0, slashPos);
			int num = Integer.parseInt(temp);
			temp = s.substring((slashPos + 1), (sLength - 1)); 
			int denom = Integer.parseInt(temp);
			this.f1 = new Fraction(num, denom);
			System.out.println(this.f1.toString());	
		} else {
			String temp = s.substring(0, (sLength - 1));
			int num = Integer.parseInt(temp);
			int denom = 1;
			this.f1 = new Fraction(num, denom);
			System.out.println(this.f1.toString());	
		}

	}
		
		
	public void setOperator(String s) {
		if (s.equals("+")) {
			if (!add) {
				this.add = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("-")) {
			if (!subtract) {
				this.subtract = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("/")) {
			if (!divide) {
				this.divide = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("*")) {
			if (!multiply) {
				this.multiply = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("a") || s.equals("A") || s.equals("abs")) {
			this.f1 = this.f1.absValue();
			System.out.println(this.f1.toString());	
		} else if (s.equals("n") || s.equals("N") || s.equals("neg")) { 
			this.f1 = this.f1.negate();
			System.out.println(this.f1.toString());	
		} else if (s.equals("c") || s.equals("C") || s.equals("clear")) {
			this.f1 = null;
			System.out.println("0");
		} else if (s.equals("q") || s.equals("Q") || s.equals("quit")) {
			this.input = new Scanner(" ");
		} else {
			this.error();
		}
	}

	public void setF2(String s) {		
		int sLength = s.length();
		int count = 0;
		int slashPos = 0;
		boolean slashPresent = false;
		for (count = 0; count < sLength; count++) {
			char slash = s.charAt(count);
			if (slash == ('/')) {
				slashPos = count;
				slashPresent = true;
			}
		}
		if (slashPresent) {
			String temp = s.substring(0, slashPos);
			int num = Integer.parseInt(temp);
			temp = s.substring((slashPos + 1), (sLength - 1)); 
			int denom = Integer.parseInt(temp);
			this.f2 = new Fraction(num, denom);

		} else {
			String temp = s.substring(0, (sLength - 1));
			int num = Integer.parseInt(temp);
			int denom = 1;
			this.f2 = new Fraction(num, denom);
		}
		if (add) {
			this.f1 = this.f1.add(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
			System.out.println(this.f1.toString());	
		} else if (subtract) {
			this.f1 = this.f1.subtract(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;	
			System.out.println(this.f1.toString());	
		} else if (divide) {
			this.f1 = this.f1.divide(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
			System.out.println(this.f1.toString());	
		} else if (multiply) {
			this.f1 = this.f1.multiply(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
			System.out.println(this.f1.toString());	
		} else {
			this.error();
		}
	}

	public void evaluate(Fraction fraction, String inputString) {		
	
}

